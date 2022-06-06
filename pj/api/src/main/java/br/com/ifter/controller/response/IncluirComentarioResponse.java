package br.com.ifter.controller.response;

import br.com.ifter.model.CategoryPost;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Builder
public class IncluirComentarioResponse {

    private String description;
    private CategoryPost category;
    private LocalDateTime dateCreation;

}
