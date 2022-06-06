package br.com.ifter.service;

import br.com.ifter.controller.response.PostResponse;
import br.com.ifter.model.CategoryPost;
import br.com.ifter.model.Post;
import br.com.ifter.model.Usuario;
import br.com.ifter.service.buscar.BuscarPostService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BuscarPostPorIdServiceTest {

    @Mock
    private BuscarPostService buscarPostService;

    @Mock
    private AdicionarLikesEmPostResponseService adicionarLikes;


    @Test
    @DisplayName("Deve buscar post por id com sucesso")
    void deveBuscarPostPorIdComSucesso() {

        Long postId  = 2L;

        Post post = new Post();
        post.setDescription("Descricao");
        post.setId(2L);
        post.setCategory(CategoryPost.PUBLIC);

        Mockito.when(buscarPostService.porId(postId))
                .thenReturn(post);

        PostResponse response = new PostResponse();
        Mockito.verify(adicionarLikes).likar(response);
    }
}