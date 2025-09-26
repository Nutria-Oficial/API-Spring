package org.example.msnutriamongodb.contract;

import org.example.msnutriamongodb.dto.GetTabelaDTO;
import org.example.msnutriamongodb.dto.PostTabelaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/tabelas")
public interface TabelaApi {

    @PostMapping("{idUsuario}")
    ResponseEntity<GetTabelaDTO> criarTabela(@PathVariable Long idUsuario, @RequestBody PostTabelaDTO postTabelaDTO);
}
