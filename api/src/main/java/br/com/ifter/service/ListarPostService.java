package br.com.ifter.service;

import br.com.ifter.controller.response.ListarPostResponse;
import br.com.ifter.model.Post;
import br.com.ifter.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.ifter.mapper.ListarPostMapper.toResponse;

@Service
public class ListarPostService {

    @Autowired
    private PostRepository postRepository;

    public List<ListarPostResponse> listar() {
        List<Post> posts = postRepository.findAll();
        List<ListarPostResponse> response = toResponse(posts);

            response.forEach(p -> p.setLikes(postRepository.contarLikesByPostId(p.getId())));

            return response;
    }
}
