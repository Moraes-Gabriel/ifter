package br.com.ifter.service;

import br.com.ifter.controller.response.ListarPostResponse;
import br.com.ifter.model.Post;
import br.com.ifter.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.ifter.mapper.ListarPostMapper.toResponse;

@Service
public class ListarComentariosDoPostPorIdService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AdicionarLikesEmPostResponseService likarPost;

    public List<ListarPostResponse> listar(Long postId) {
        List<Post> posts = postRepository.listarComentariosPorPostId(postId);

        List<ListarPostResponse> response = toResponse(posts);
        likarPost.likar(response);

        return response;
    }

}
