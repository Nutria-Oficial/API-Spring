package org.example.msnutriamongodb.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class TabelaAvaliacao {
    @Field(name = "cClassificacao")
    private Character classificacao;
    @Field(name = "iScore")
    private double pontuacao;
    @Field(name = "cComentarios")
    private String comentarios;
}
