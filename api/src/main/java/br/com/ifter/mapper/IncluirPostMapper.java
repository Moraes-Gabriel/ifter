package br.com.ifter.mapper;

import br.com.ifter.controller.request.IncluirPostRequest;
import br.com.ifter.controller.request.IncluirUsuarioRequest;
import br.com.ifter.controller.response.IncluirPostResponse;
import br.com.ifter.controller.response.IncluirUsuarioResponse;
import br.com.ifter.model.Post;
import br.com.ifter.model.Usuario;
import org.modelmapper.ModelMapper;

public class IncluirPostMapper {

    public static Post toEntity(IncluirPostRequest request) {
        return new ModelMapper().map(request, Post.class);
    }

    public static IncluirPostResponse toResponse(Post entity) {
        return new ModelMapper().map(entity, IncluirPostResponse.class);
    }
}
