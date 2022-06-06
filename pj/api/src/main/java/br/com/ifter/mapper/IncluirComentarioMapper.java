package br.com.ifter.mapper;

import br.com.ifter.controller.request.IncluirComentarioRequest;
import br.com.ifter.controller.request.IncluirPostRequest;
import br.com.ifter.controller.response.IncluirComentarioResponse;
import br.com.ifter.controller.response.IncluirPostResponse;
import br.com.ifter.model.Post;
import org.modelmapper.ModelMapper;

public class IncluirComentarioMapper {

    public static Post toEntity(IncluirComentarioRequest request) {
        return new ModelMapper().map(request, Post.class);
    }

    public static IncluirComentarioResponse toResponse(Post entity) {
        return new ModelMapper().map(entity, IncluirComentarioResponse.class);
    }
}
