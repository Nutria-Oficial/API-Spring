package org.example.msnutriamongodb.service;

import org.example.msnutriamongodb.dto.GetNutrienteDTO;
import org.example.msnutriamongodb.dto.GetProdutoDTO;
import org.example.msnutriamongodb.dto.GetTabelaDTO;
import org.example.msnutriamongodb.exception.NotFoundException;
import org.example.msnutriamongodb.model.Produto;
import org.example.msnutriamongodb.repository.ProdutoRepository;
import org.example.msnutriamongodb.repository.TabelaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final TabelaRepository tabelaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, TabelaRepository tabelaRepository) {
        this.produtoRepository = produtoRepository;
        this.tabelaRepository = tabelaRepository;
    }

    public List<GetProdutoDTO> buscarHistoricoPorUsuario(Long idUsuario){
       return produtoRepository.findAllByIdUsuarioCriacao(idUsuario).stream().map(produto -> new GetProdutoDTO(produto.getNomeProduto())).toList();
    }
    public List<GetTabelaDTO> buscarTabelasPorProduto(Long idProduto){
        Optional<Produto> produto = produtoRepository.findById(idProduto);

        if (produto.isEmpty()){
            throw new NotFoundException("Produto não foi encontrado");
        }
         return tabelaRepository.findAllByIdProduto(idProduto).stream().map(tabela ->
                new GetTabelaDTO(tabela.getId(), tabela.getNomeTabela(), tabela.getQuantidadeTotal(),
                        tabela.getPorcao(), buscarPorcaoPorNutriente(tabela.getListaNutrientes(),tabela.getListaTotal(),tabela.getListaPorcao()))).toList();
    }

    public List<GetNutrienteDTO> buscarPorcaoPorNutriente(List<String> listaNutrientes, List<Double> listaTotal, List<Double> listaPorcao){
        List<GetNutrienteDTO> nutrienteDTOList = new ArrayList<>();
        for (int i = 0; i < listaNutrientes.size(); i++) {
            nutrienteDTOList.add(new GetNutrienteDTO(listaNutrientes.get(i), listaTotal.get(i), listaPorcao.get(i)));
        }
        return  nutrienteDTOList;
    }
}
