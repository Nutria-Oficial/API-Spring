package org.example.msnutriamongodb.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.util.List;
import org.example.msnutriamongodb.model.ItemIngrediente;

public record PostTabelaDTO(
    @NotBlank String nomeProduto,
    @NotBlank String nomeTabela,
    @Pattern(regexp = "kg|g|ml|l", message = "O tipo de medida deve ser em kg, g, ml, ou l")
        String tipoMedida,
    double porcao,
    @NotNull(message = "Precisa adicionar ingredientes")
        @NotEmpty(message = "Os ingredientes não pode ser vazios")
        List<ItemIngrediente> ingredientes) {}
