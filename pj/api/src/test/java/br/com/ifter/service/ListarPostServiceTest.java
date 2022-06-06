package br.com.ifter.service;

import br.com.ifter.controller.request.IncluirPostRequest;
import br.com.ifter.controller.response.ListarPostResponse;
import br.com.ifter.controller.response.PostResponse;
import br.com.ifter.model.CategoryPost;
import br.com.ifter.model.Post;
import br.com.ifter.repository.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ListarPostServiceTest {

    @InjectMocks
    private ListarPostService listarPostService;

    @Mock
    private PostRepository postRepository;

    @Test
    @DisplayName("Deve adicionar uma corrida com sucesso")
    void deveListarPostComSucesso() {

        Post post = new Post();

        post.setDescription("vini lindo");
        post.setCategory(CategoryPost.PUBLIC);
        post.setDateCreation(LocalDateTime.from(LocalDate.of(2002,04,04)));

        Post post2 = new Post();

        post2.setDescription("vini KOPASDKOPAS");
        post2.setCategory(CategoryPost.PRIV);
        post2.setDateCreation(LocalDateTime.from(LocalDate.of(2003,04,04)));


        List<Post> posts = null;
        posts.add(post);
        posts.add(post2);

        Mockito.when(postRepository.findAll()).thenReturn(posts);

        List<ListarPostResponse> responses = null;

        //Mockito.when(postRepository.contarLikesByPostId(post.getId())).thenReturn(post);

    }
}