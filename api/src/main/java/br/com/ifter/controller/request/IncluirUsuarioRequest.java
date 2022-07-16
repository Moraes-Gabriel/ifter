package br.com.ifter.controller.request;

import br.com.ifter.model.Permissao;
import br.com.ifter.model.Post;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
public class IncluirUsuarioRequest {

    @NotBlank
    private String identify;
    @NotBlank
    private String nickName;
    @NotBlank
    private String email;
    @NotBlank
    private String senha;

    private LocalDate birthDate;

    private String image_perfil;
    private Permissao permissao;
}
