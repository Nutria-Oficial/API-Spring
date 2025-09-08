package org.example.msnutriamongodb.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class ItemIngrediente {
    @Field(name= "nCdIngrediente")
    private Long idIngrediente;
    @Field(name= "iQuantidade")
    private double quantidade;
}
