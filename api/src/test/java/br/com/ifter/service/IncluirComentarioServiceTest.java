package br.com.ifter.service;

import br.com.ifter.controller.request.IncluirComentarioRequest;
import br.com.ifter.model.CategoryPost;
import br.com.ifter.model.Post;
import br.com.ifter.model.Usuario;
import br.com.ifter.repository.PostRepository;
import br.com.ifter.service.buscar.BuscarPostService;
import br.com.ifter.service.security.UsuarioAutenticadoService;
import br.com.ifter.service.util.PostFactory;
import br.com.ifter.service.util.UsuarioFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static br.com.ifter.mapper.IncluirComentarioMapper.toEntity;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class IncluirComentarioServiceTest {

    @InjectMocks
    private IncluirComentarioService service;

    @Mock
    private PostRepository postRepository;

    @Mock
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Mock
    private BuscarPostService buscarPostService;

    @Captor
    private ArgumentCaptor<Post> comentarioCaptor;

    @Test
    @DisplayName("Deve incluir um comentario com sucesso")
    void deveIncluirUmComentarioComSucesso() {

        Long postId = 1L;
        Usuario usuario = UsuarioFactory.get();

        Post postInclusao = PostFactory.get();

        Post comentario = PostFactory.getBuilder()
                .description("comentario")
                .category(CategoryPost.COMMENT)
                .posts(new ArrayList<Post>())
                .id(2L).build();

        IncluirComentarioRequest request = new IncluirComentarioRequest();
        request.setDescription("O andre e muito bonito");

        Mockito.when(usuarioAutenticadoService.get()).thenReturn(usuario);
        Mockito.when(buscarPostService.porId(postId)).thenReturn(postInclusao);

        service.incluirComentario(postId, request);

        //Mockito.verify(postInclusao).adicionarComentario(comentarioCaptor.capture());

        Mockito.verify(postRepository).save(postInclusao);

        assertEquals(comentario.getDescription(), comentarioCaptor.capture().getDescription());
        assertEquals(comentario.getCategory(), comentarioCaptor.capture().getDescription());
    }
}








