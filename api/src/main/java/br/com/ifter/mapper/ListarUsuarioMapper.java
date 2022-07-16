package br.com.ifter.mapper;

import br.com.ifter.controller.response.UsuarioResponse;
import br.com.ifter.model.Post;
import br.com.ifter.model.Usuario;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ListarUsuarioMapper {
    public static List<UsuarioResponse> toResponse(List<Usuario> list) {
        return list
                .stream()
                .map(user -> new ModelMapper().map(user, UsuarioResponse.class))
                .collect(Collectors.toList());
    }
}
