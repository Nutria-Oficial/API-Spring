package org.example.msnutriamongodb.contract;

import jakarta.validation.Valid;
import org.example.msnutriamongodb.dto.GetTabelaDTO;
import org.example.msnutriamongodb.dto.GetTabelaEAvaliacaoDTO;
import org.example.msnutriamongodb.dto.PostTabelaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/tabelas")
public interface TabelaApi {

    @PostMapping("/{idProduto}/{idUsuario}")
    ResponseEntity<GetTabelaDTO> criarTabela(@PathVariable(required = false) Integer idProduto, @PathVariable Integer idUsuario, @Valid @RequestBody PostTabelaDTO postTabelaDTO);
    @PostMapping("/{idTabela}")
    ResponseEntity<GetTabelaEAvaliacaoDTO> buscarTabelaComAvaliacao(@PathVariable Integer idTabela);
}
