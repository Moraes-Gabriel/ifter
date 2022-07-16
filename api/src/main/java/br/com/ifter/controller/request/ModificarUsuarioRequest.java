package br.com.ifter.controller.request;

import br.com.ifter.model.Permissao;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class ModificarUsuarioRequest {

    @NotBlank
    private String identify;
    @NotBlank
    private String nickName;
    @NotBlank
    private String image_perfil;
}
