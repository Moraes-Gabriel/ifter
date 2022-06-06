package br.com.ifter.service;

import br.com.ifter.controller.response.ListarPostResponse;
import br.com.ifter.model.Post;
import br.com.ifter.repository.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class AdicionarLikesEmPostResponseServiceTest {

    @Mock
    private PostRepository postRepository;


    @Test
    @DisplayName("Deve adicionar likes com sucesso")
    void deveAdicionarLikesComSucesso() {

        ListarPostResponse response = new ListarPostResponse();

        response.setDescription("TESTE BOM");
        response.setId(1L);

        Post post = new Post();
        post.setDescription("TESTE BOM");
        post.setId(1L);

        Mockito.verify(postRepository.contarLikesByPostId(post.getId()));
    }
}