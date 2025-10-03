package org.example.msnutriamongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TabelaAvaliacao {
    @Field(name = "cClassificacao")
    private Character classificacao;
    @Field(name = "iScore")
    private double pontuacao;
    @Field(name = "cComentarios")
    private String comentarios;
}
