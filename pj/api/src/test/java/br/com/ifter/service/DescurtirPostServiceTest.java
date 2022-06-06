package br.com.ifter.service;

import br.com.ifter.model.Post;
import br.com.ifter.model.Usuario;
import br.com.ifter.repository.PostRepository;
import br.com.ifter.service.buscar.BuscarPostService;
import br.com.ifter.service.security.UsuarioAutenticadoService;
import br.com.ifter.service.util.PostFactory;
import br.com.ifter.service.util.UsuarioFactory;
import br.com.ifter.service.validar.ValidarSeUsuarioJaCurtiuOPostService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DescurtirPostServiceTest {


    @InjectMocks
    private DescurtirPostService service;

    @Mock
    private PostRepository postRepository;

    @Mock
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Mock
    private ValidarSeUsuarioJaCurtiuOPostService validarSeUsuarioJaCurtiuOPostService;

    @Mock
    private BuscarPostService buscarPostService;

    @Test
    @DisplayName("Deve descurtir um post com sucesso")
    void deveDescurtirUmPostComSucesso() {

        Long postId = 1L;

        Usuario usuario = UsuarioFactory.get();
        Post post = PostFactory.get();

        Mockito.when(usuarioAutenticadoService.get()).thenReturn(usuario);
        Mockito.when(buscarPostService.porId(postId)).thenReturn(post);

        service.descurtir(postId);

        Mockito.verify(post).removerCurtida(usuario);
        Mockito.verify(postRepository).save(post);
    }
}
