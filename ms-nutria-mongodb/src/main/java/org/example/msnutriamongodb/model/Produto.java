package org.example.msnutriamongodb.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "produto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    @Id
    @Field(name= "_id")
    private Integer id;

    @Field(name = "cNmProduto")
    private String nomeProduto;

    @Field(name = "dCriacao")
    private Date dataCriacao;

    @Field(name = "nCdUsuarioCriacao")
    private Long idUsuarioCriacao;

    @Field(name = "dUltimaAlteracao")
    private Date dataAlteracao;

    @Field(name = "nCdUsuarioUltimaAlteracao")
    private Long idUsuarioAlteracao;
}
