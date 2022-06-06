package br.com.ifter.controller.request;

import br.com.ifter.model.CategoryPost;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class IncluirPostRequest {

    @NotBlank
    private String description;
    @NotNull
    private CategoryPost category;
}
