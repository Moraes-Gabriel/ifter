package br.com.ifter.controller.response;

import br.com.ifter.model.Permissao;
import br.com.ifter.model.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Builder
public class UsuarioResponse {

    private Long id;
    private String identify;
    private String nickName;
    private String image_perfil;
    private boolean amigo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;
    private List<FollowerResponse> followers;
    private List<FollowerResponse> following;
    private List<FollowerResponse> friends;
}


