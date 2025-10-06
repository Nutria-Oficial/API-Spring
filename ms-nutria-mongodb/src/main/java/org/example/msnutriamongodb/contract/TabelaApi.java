package org.example.msnutriamongodb.contract;

import jakarta.validation.Valid;
import org.example.msnutriamongodb.dto.GetTabelaDTO;
import org.example.msnutriamongodb.dto.GetTabelaEAvaliacaoDTO;
import org.example.msnutriamongodb.dto.PostTabelaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/tabelas")
public interface TabelaApi {

    @PostMapping("/{idUsuario}")
    ResponseEntity<GetTabelaDTO> criarTabela(@PathVariable Integer idUsuario, @Valid @RequestBody PostTabelaDTO postTabelaDTO);
    @PostMapping("/{idUsuario}/{idProduto}")
    ResponseEntity<GetTabelaDTO> adicionarTabela(@PathVariable Integer idUsuario, @PathVariable Integer idProduto, @Valid @RequestBody PostTabelaDTO postTabelaDTO);
    @GetMapping("/{idTabela}")
    ResponseEntity<GetTabelaEAvaliacaoDTO> buscarTabelaComAvaliacao(@PathVariable Integer idTabela);
}
