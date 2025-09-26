package org.example.msnutriamongodb.service;

import org.example.msnutriamongodb.dto.GetNutrienteDTO;
import org.example.msnutriamongodb.dto.GetProdutoDTO;
import org.example.msnutriamongodb.dto.GetTabelaDTO;
import org.example.msnutriamongodb.dto.PostTabelaDTO;
import org.example.msnutriamongodb.exception.DatabaseInsertException;
import org.example.msnutriamongodb.exception.NotFoundException;
import org.example.msnutriamongodb.model.Produto;
import org.example.msnutriamongodb.model.Tabela;
import org.example.msnutriamongodb.repository.ProdutoRepository;
import org.example.msnutriamongodb.repository.TabelaRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.*;

@Service
public class TabelaProdutoService {
    private final TabelaRepository tabelaRepository;
    private final ProdutoRepository produtoRepository;
    private final RedisTemplate<String, Object> redisTemplate;
    private final FastApiService fastApiService;

    public TabelaProdutoService(TabelaRepository tabelaRepository, ProdutoRepository produtoRepository, RedisTemplate<String, Object> redisTemplate, FastApiService fastApiService) {
        this.tabelaRepository = tabelaRepository;
        this.produtoRepository = produtoRepository;
        this.redisTemplate = redisTemplate;
        this.fastApiService = fastApiService;
    }

    public List<GetProdutoDTO> buscarHistoricoPorUsuario(Long idUsuario){
        return produtoRepository.findAllByIdUsuarioCriacao(idUsuario).stream().map(produto -> new GetProdutoDTO(produto.getNomeProduto())).toList();
    }
    public List<GetTabelaDTO> buscarTabelasPorProduto(Long idProduto){ //falar com a lívia sobre deixar a mesma requisição para comparação -> vai ter que chamar por produto
        Optional<Produto> produto = produtoRepository.findById(idProduto);

        if (produto.isEmpty()){
            throw new NotFoundException("Produto não foi encontrado");
        }
        return tabelaRepository.findAllByIdProduto(idProduto).stream().map(tabela ->
                new GetTabelaDTO(tabela.getId(), tabela.getNomeTabela(), tabela.getQuantidadeTotal(),
                        tabela.getPorcao(), buscarPorcaoPorNutriente(tabela.getListaNutrientes(),tabela.getListaTotal(),tabela.getListaPorcao(), tabela.getListaValorDiario()))).toList();
    }

    public GetTabelaDTO criarTabela(PostTabelaDTO tabelaDTO, long idUsuario) {
        Long proximoId = produtoRepository.findLastProdutoId() + 1;
        Produto newProduto = new Produto(proximoId,tabelaDTO.nomeProduto(), new Date(), idUsuario, new Date(), idUsuario);
        produtoRepository.save(newProduto);

        String chaveHash = "requisicao_user:" + idUsuario;
        Map<String, Object> tabelaHash = new HashMap<>();
        tabelaHash.put("nome_tabela", tabelaDTO.nomeTabela());
        tabelaHash.put("porcao_tabela", tabelaDTO.porcao());
        tabelaHash.put("ingredientes", tabelaDTO.ingredientes());
        tabelaHash.put("unidade_medida", tabelaDTO.tipoMedida());
        tabelaHash.put("cod_produto", proximoId);

        redisTemplate.opsForHash().putAll(chaveHash, tabelaHash);

        Mono<String> resposta = fastApiService.criarTabelaNutricional(idUsuario);
        if (resposta.toString().contains("erro")){
            throw new DatabaseInsertException(resposta.toString());
        }
        Tabela tabela = tabelaRepository.findAllByIdProduto(proximoId).getLast();
        return  new GetTabelaDTO(tabela.getId(), tabela.getNomeTabela(), tabela.getQuantidadeTotal(), tabela.getPorcao(),buscarPorcaoPorNutriente(tabela.getListaNutrientes(),tabela.getListaTotal(),tabela.getListaPorcao(), tabela.getListaValorDiario()));
    }
    public List<GetNutrienteDTO> buscarPorcaoPorNutriente(List<String> listaNutrientes, List<Double> listaTotal, List<Double> listaPorcao, List<Double> listaValorDiario){
        List<GetNutrienteDTO> nutrienteDTOList = new ArrayList<>();
        for (int i = 0; i < listaNutrientes.size(); i++) {
            nutrienteDTOList.add(new GetNutrienteDTO(listaNutrientes.get(i), listaTotal.get(i), listaPorcao.get(i), listaValorDiario.get(i)));
        }
        return  nutrienteDTOList;
    }
}
