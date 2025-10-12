package org.example.msnutriamongodb.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemIngrediente {
  @JsonProperty("nCdIngrediente")
  @Field("nCdIngrediente")
  private Integer idIngrediente;

  @JsonProperty("iQuantidade")
  @Field("iQuantidade")
  private double quantidade;
}
