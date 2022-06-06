package br.com.ifter.service;

import br.com.ifter.controller.response.ListarPostResponse;
import br.com.ifter.model.Post;
import br.com.ifter.repository.PostRepository;
import br.com.ifter.service.security.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.ifter.mapper.ListarPostMapper.toResponse;

@Service
public class ListarPostDosUsuariosQueSegueService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AdicionarLikesEmPostResponseService likarPost;

    public List<ListarPostResponse> listar() {
        Long usuarioId = usuarioAutenticadoService.getId();

        List<Post> posts =
                postRepository.listarPostsDosUsuariosQueSegueESaoAmigos(usuarioId);

        List<ListarPostResponse> response = toResponse(posts);

        likarPost.likar(response);

        return response;
    }
}
