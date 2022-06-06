package br.com.ifter.controller.response;

import br.com.ifter.model.CategoryPost;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostResponse {
    private Long id;
    private String description;
    private LocalDateTime dateCreation;
    private CategoryPost category;
    private UsuarioResponse usuario;
    private int likes;
}
