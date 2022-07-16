package br.com.ifter.mapper;

import br.com.ifter.controller.response.ListarPostResponse;
import br.com.ifter.controller.response.UsuarioResponse;
import br.com.ifter.model.Post;
import br.com.ifter.model.Usuario;
import io.micrometer.core.instrument.Tags;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {
    public static UsuarioResponse toResponse(Usuario entity) {
        return new ModelMapper().map(entity, UsuarioResponse.class);
    }


    public static Page<UsuarioResponse> toResponse(Page<Usuario> page) {
        return page.map(user -> new ModelMapper().map(user, UsuarioResponse.class));
    }
    public static List<UsuarioResponse> toResponse(List<Usuario> list) {
        return list.stream()
                .map(usuario -> new ModelMapper().map(usuario, UsuarioResponse.class))
                .collect(Collectors.toList());
    }
}

