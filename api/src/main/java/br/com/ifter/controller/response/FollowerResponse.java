package br.com.ifter.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Builder
public class FollowerResponse {

    private Long id;
    private String identify;
    private String nickName;
    private String image_perfil;
    private boolean amigo;
    private LocalDate birthDate;
}


