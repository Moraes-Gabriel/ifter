package br.com.ifter.service;

import br.com.ifter.model.Post;
import br.com.ifter.model.Usuario;
import br.com.ifter.repository.PostRepository;
import br.com.ifter.service.buscar.BuscarPostService;
import br.com.ifter.service.security.UsuarioAutenticadoService;
import br.com.ifter.service.validar.ValidarSeUsuarioJaCurtiuOPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Service
public class CurtirPostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private ValidarSeUsuarioJaCurtiuOPostService validarSeUsuarioJaCurtiuOPostService;

    @Autowired
    private BuscarPostService buscarPostService;

    public void curtir(Long postId) {
        Usuario usuarioLogado = usuarioAutenticadoService.get();
        Post post = buscarPostService.porId(postId);

        if (post.getLikedUsers().contains(usuarioLogado)){
            post.removerCurtida(usuarioLogado);
        }else {
            post.adicionarCurtida(usuarioLogado);
        }
        postRepository.save(post);
    }
}
