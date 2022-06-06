package br.com.ifter.mapper;

import br.com.ifter.controller.response.PostResponse;
import br.com.ifter.controller.response.UsuarioResponse;
import br.com.ifter.model.Post;
import br.com.ifter.model.Usuario;
import org.modelmapper.ModelMapper;

public class PostMapper {
    public static PostResponse toResponse(Post entity) {
        return new ModelMapper().map(entity, PostResponse.class);
    }
}
