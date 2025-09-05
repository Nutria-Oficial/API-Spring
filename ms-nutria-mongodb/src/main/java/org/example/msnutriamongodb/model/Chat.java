package org.example.msnutriamongodb.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "chat")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    @Id
    @Field(name= "_id")
    private Long id;

    @Field(name= "nCdUsuario")
    private Long idUsuario;

    @Field(name= "iChat")
    private Long indiceChat;

    @Field(name= "lUser")
    private List<String> listaUsuario = new ArrayList<>();

    @Field(name= "lBot")
    private List<String> listaBot = new ArrayList<>();
}
