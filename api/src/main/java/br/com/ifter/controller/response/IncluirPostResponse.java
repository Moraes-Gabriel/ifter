package br.com.ifter.controller.response;

import br.com.ifter.model.CategoryPost;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Builder
public class IncluirPostResponse {

    private String description;
    private CategoryPost category;
    private LocalDateTime dateCreation;

}
