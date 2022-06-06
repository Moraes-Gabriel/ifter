package br.com.ifter.controller.response;

import br.com.ifter.model.Post;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
public class IncluirUsuarioResponse {

    private String identify;
    private String nickName;
    private String email;
    private String image_perfil;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

}
