package br.com.ifter.service;

import br.com.ifter.controller.response.ListarPostResponse;
import br.com.ifter.controller.response.PostResponse;
import br.com.ifter.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdicionarLikesEmPostResponseService {

    @Autowired
    private PostRepository postRepository;

    public void likar(List<ListarPostResponse> response) {
        response.forEach(p ->
                p.setLikes(postRepository.contarLikesByPostId(p.getId())
                ));
    }

    public void likar(PostResponse response) {
        response.setLikes(postRepository.contarLikesByPostId(response.getId()));
    }
}
