package br.com.ifter.service;

import br.com.ifter.controller.request.IncluirComentarioRequest;
import br.com.ifter.controller.response.IncluirComentarioResponse;
import br.com.ifter.model.CategoryPost;
import br.com.ifter.model.Post;
import br.com.ifter.model.Usuario;
import br.com.ifter.repository.PostRepository;
import br.com.ifter.service.buscar.BuscarPostService;
import br.com.ifter.service.security.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static br.com.ifter.mapper.IncluirComentarioMapper.toEntity;
import static br.com.ifter.mapper.IncluirComentarioMapper.toResponse;


@Service
public class IncluirComentarioService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private BuscarPostService buscarPostService;

    public IncluirComentarioResponse incluirComentario(Long postId, IncluirComentarioRequest request) {

        Usuario usuario = usuarioAutenticadoService.get();
        Post postInclusao = buscarPostService.porId(postId);

        Post comentario = toEntity(request);

        comentario.setUsuario(usuario);
        comentario.setCategory(CategoryPost.COMMENT);
        comentario.setDateCreation(LocalDateTime.now());
        
        postInclusao.adicionarComentario(comentario);
        postRepository.save(postInclusao);

         return toResponse(comentario);
    }
}
