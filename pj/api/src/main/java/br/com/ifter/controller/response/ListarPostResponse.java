package br.com.ifter.controller.response;

import br.com.ifter.model.CategoryPost;
import br.com.ifter.model.Usuario;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
public class ListarPostResponse {
    private Long id;
    private String description;
    private LocalDateTime dateCreation;
    private CategoryPost category;
    private UsuarioResponse usuario;
    private int likes;
}
