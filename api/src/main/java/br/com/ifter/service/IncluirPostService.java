package br.com.ifter.service;

import br.com.ifter.controller.request.IncluirPostRequest;
import br.com.ifter.controller.response.IncluirPostResponse;
import br.com.ifter.mapper.IncluirPostMapper;
import br.com.ifter.model.Post;
import br.com.ifter.model.Usuario;
import br.com.ifter.repository.PostRepository;
import br.com.ifter.service.security.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static br.com.ifter.mapper.IncluirPostMapper.toEntity;
import static br.com.ifter.mapper.IncluirPostMapper.toResponse;

@Service
public class IncluirPostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public IncluirPostResponse incluir(IncluirPostRequest request) {

        Usuario usuario = usuarioAutenticadoService.get();

        Post post = toEntity(request);
        post.setDateCreation(LocalDateTime.now());
        post.setUsuario(usuario);
        usuario.getPosts().add(post);
        postRepository.save(post);

        return toResponse(post);
    }
}
