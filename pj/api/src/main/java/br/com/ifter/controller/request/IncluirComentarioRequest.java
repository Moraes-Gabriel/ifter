package br.com.ifter.controller.request;

import br.com.ifter.model.CategoryPost;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class IncluirComentarioRequest {

    @NotBlank
    private String description;
}
