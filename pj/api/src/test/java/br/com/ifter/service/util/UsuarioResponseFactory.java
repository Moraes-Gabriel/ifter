package br.com.ifter.service.util;

import br.com.ifter.controller.response.UsuarioResponse;

import java.time.LocalDate;

public class UsuarioResponseFactory {

    public static UsuarioResponse get() {
        return getBuilder().build();
    }

    public static UsuarioResponse.UsuarioResponseBuilder getBuilder() {
        return UsuarioResponse.builder()
                .id(1L)
                .identify("moraes24")
                .nickName("moraes")
                .birthDate(LocalDate.of(2022,04,04));

    }
}
