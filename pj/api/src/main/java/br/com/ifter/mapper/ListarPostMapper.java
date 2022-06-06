package br.com.ifter.mapper;

import br.com.ifter.controller.response.ListarPostResponse;
import br.com.ifter.model.Post;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class ListarPostMapper {
    public static List<ListarPostResponse> toResponse(Page<Post> posts) {
        return posts.stream()
                .map(post -> new ModelMapper().map(post, ListarPostResponse.class))
                .collect(Collectors.toList());
    }
    public static List<ListarPostResponse> toResponse(List<Post> posts) {
        return posts.stream()
                .map(post -> new ModelMapper().map(post, ListarPostResponse.class))
                .collect(Collectors.toList());
    }
}
