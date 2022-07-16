package br.com.ifter.service;

import br.com.ifter.controller.response.UsuarioResponse;
import br.com.ifter.repository.PostRepository;
import br.com.ifter.repository.UsuarioRepository;
import br.com.ifter.service.security.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarLikesPostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public boolean buscar(Long postId) {

        int verificado = postRepository.countByPosts(postId);

        if(verificado >= 1)  return true;
        return false;
    }
}
