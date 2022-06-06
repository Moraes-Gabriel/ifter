package br.com.ifter.service.util;

import br.com.ifter.model.Usuario;

import java.time.LocalDate;

public class UsuarioFactory {

    public static Usuario get() {
        return getBuilder().build();
    }

    public static Usuario.UsuarioBuilder getBuilder() {
        return Usuario.builder()
                .id(1L)
                .identify("moraes24")
                .nickName("moraes").birthDate(LocalDate.of(2022,04,04))
                .email("moraes@Cwi.com.br");
    }
}
