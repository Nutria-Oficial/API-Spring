package org.example.msnutriamongodb.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.util.List;
import org.example.msnutriamongodb.model.ItemIngrediente;

public class PostTabelaDTO{
        @NotBlank String nomeProduto;
        @NotBlank String nomeTabela;
        @Pattern(regexp = "kg|g|ml|l", message = "O tipo de medida deve ser em kg, g, ml, ou l")
        String tipoMedida;
        double porcao;
        @NotNull(message = "Precisa adicionar ingredientes")
        @NotEmpty(message = "Os ingredientes não pode ser vazios")
        List<ItemIngrediente> ingredientes;

        public PostTabelaDTO() {
        }

        public PostTabelaDTO(String nomeProduto, String nomeTabela, String tipoMedida, double porcao, List<ItemIngrediente> ingredientes) {
            this.nomeProduto = nomeProduto;
            this.nomeTabela = nomeTabela;
            this.tipoMedida = tipoMedida;
            this.porcao = porcao;
            this.ingredientes = ingredientes;
        }

        public String getNomeProduto() {
            return nomeProduto;
        }

        public void setNomeProduto(String nomeProduto) {
            this.nomeProduto = nomeProduto;
        }

        public String getNomeTabela() {
            return nomeTabela;
        }

        public void setNomeTabela(String nomeTabela) {
            this.nomeTabela = nomeTabela;
        }

        public String getTipoMedida() {
            return tipoMedida;
        }

        public void setTipoMedida(String tipoMedida) {
            this.tipoMedida = tipoMedida;
        }

        public double getPorcao() {
            return porcao;
        }

        public void setPorcao(double porcao) {
            this.porcao = porcao;
        }

        public List<ItemIngrediente> getIngredientes() {
            return ingredientes;
        }

        public void setIngredientes(List<ItemIngrediente> ingredientes) {
            this.ingredientes = ingredientes;
        }
}
