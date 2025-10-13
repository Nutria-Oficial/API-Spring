package org.example.msnutriamongodb.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;
import org.example.msnutriamongodb.dto.*;
import org.example.msnutriamongodb.exception.JsonSerializationException;
import org.example.msnutriamongodb.exception.NotFoundException;
import org.example.msnutriamongodb.model.Produto;
import org.example.msnutriamongodb.model.Tabela;
import org.example.msnutriamongodb.repository.ProdutoRepository;
import org.example.msnutriamongodb.repository.TabelaRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class TabelaProdutoService {
  private final TabelaRepository tabelaRepository;
  private final ProdutoRepository produtoRepository;
  private final RedisTemplate<String, Object> redisTemplate;
  private final FastApiService fastApiService;

  public TabelaProdutoService(
      TabelaRepository tabelaRepository,
      ProdutoRepository produtoRepository,
      RedisTemplate<String, Object> redisTemplate,
      FastApiService fastApiService) {
    this.tabelaRepository = tabelaRepository;
    this.produtoRepository = produtoRepository;
    this.redisTemplate = redisTemplate;
    this.fastApiService = fastApiService;
  }

  public List<GetProdutoDTO> buscarHistoricoPorUsuario(Integer idUsuario, boolean filtrar) {
    if (filtrar) {
      return produtoRepository.findAllByMoreThenOneTable(idUsuario).stream()
          .map(produto -> new GetProdutoDTO(produto.getNomeProduto()))
          .toList();
    }
    return produtoRepository.findAllByIdUsuarioCriacao(idUsuario).stream()
        .map(produto -> new GetProdutoDTO(produto.getNomeProduto()))
        .toList();
  }

  public List<GetTabelaDTO> buscarTabelasPorProduto(Integer idProduto) {
    Optional<Produto> produto = produtoRepository.findById(idProduto);

    if (produto.isEmpty()) {
      throw new NotFoundException("Produto não foi encontrado");
    }
    return tabelaRepository.findAllByIdProduto(idProduto).stream()
        .map(
            tabela ->
                new GetTabelaDTO(
                    tabela.getId(),
                    tabela.getNomeTabela(),
                    tabela.getQuantidadeTotal(),
                    tabela.getPorcao(),
                    buscarPorcaoPorNutriente(
                        tabela.getListaNutrientes(),
                        tabela.getListaTotal(),
                        tabela.getListaPorcao(),
                        tabela.getListaValorDiario())))
        .toList();
  }

  public GetTabelaEAvaliacaoDTO buscarTabelaEAvaliacao(Integer idTabela) {
    Optional<Tabela> tabelaEncontrada = tabelaRepository.findById(idTabela);

    if (tabelaEncontrada.isEmpty()) {
      throw new NotFoundException("Tabela não foi encontrada");
    }
    Tabela tabela = tabelaEncontrada.get();
    return new GetTabelaEAvaliacaoDTO(
        tabela.getId(),
        tabela.getNomeTabela(),
        tabela.getQuantidadeTotal(),
        tabela.getPorcao(),
        buscarPorcaoPorNutriente(
            tabela.getListaNutrientes(),
            tabela.getListaTotal(),
            tabela.getListaPorcao(),
            tabela.getListaValorDiario()),
        tabela.getAvaliacao());
  }

  public GetTabelaDTO criarTabela(Integer idProduto, PostTabelaDTO tabelaDTO, Integer idUsuario) {
    Integer proximoId;
    if (idProduto != null) {
      if (produtoRepository.findById(idProduto).isEmpty()) {
        throw new NotFoundException("Produto não encontrado");
      }
      proximoId = idProduto;
    } else {
      proximoId = produtoRepository.findLastProdutoId() + 1;
      Produto newProduto =
          new Produto(
              proximoId, tabelaDTO.nomeProduto(), new Date(), idUsuario, new Date(), idUsuario);
      produtoRepository.save(newProduto);
      fastApiService.criarEmbedding();
    }

    try {
      ObjectMapper mapper = new ObjectMapper();
      String jsonIngredientes = mapper.writeValueAsString(tabelaDTO.ingredientes());

      String chaveHash = "requisicao_user:" + idUsuario;
      Map<String, Object> tabelaHash = new HashMap<>();
      tabelaHash.put("nome_tabela", tabelaDTO.nomeTabela());
      tabelaHash.put("porcao_tabela", String.valueOf(tabelaDTO.porcao()));
      tabelaHash.put("ingredientes", jsonIngredientes);
      tabelaHash.put("unidade_medida", tabelaDTO.tipoMedida());
      tabelaHash.put("cod_produto", String.valueOf(proximoId));

      redisTemplate.opsForHash().putAll(chaveHash, tabelaHash);

      fastApiService.criarTabelaNutricional(idUsuario);
    } catch (JsonProcessingException exception) {
      throw new JsonSerializationException("Erro ao processar o Json");
    }

    Tabela tabela = tabelaRepository.findAllByIdProduto(proximoId).getLast();
    return new GetTabelaDTO(
        tabela.getId(),
        tabela.getNomeTabela(),
        tabela.getQuantidadeTotal(),
        tabela.getPorcao(),
        buscarPorcaoPorNutriente(
            tabela.getListaNutrientes(),
            tabela.getListaTotal(),
            tabela.getListaPorcao(),
            tabela.getListaValorDiario()));
  }

  public List<GetNutrienteDTO> buscarPorcaoPorNutriente(
      List<String> listaNutrientes,
      List<Double> listaTotal,
      List<Double> listaPorcao,
      List<Double> listaValorDiario) {
    List<GetNutrienteDTO> nutrienteDTOList = new ArrayList<>();
    for (int i = 0; i < listaNutrientes.size(); i++) {
      nutrienteDTOList.add(
          new GetNutrienteDTO(
              listaNutrientes.get(i),
              listaTotal.get(i),
              listaPorcao.get(i),
              listaValorDiario.get(i)));
    }
    return nutrienteDTOList;
  }
}
