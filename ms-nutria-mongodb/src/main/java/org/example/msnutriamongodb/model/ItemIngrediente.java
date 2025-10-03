package org.example.msnutriamongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemIngrediente {
    @Field(name= "nCdIngrediente")
    private Long idIngrediente;
    @Field(name= "iQuantidade")
    private double quantidade;
}
