package br.com.ifter.service;

import br.com.ifter.controller.response.ListarPostResponse;
import br.com.ifter.model.Post;
import br.com.ifter.model.Usuario;
import br.com.ifter.repository.PostRepository;
import br.com.ifter.repository.UsuarioRepository;
import br.com.ifter.service.security.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.ifter.mapper.ListarPostMapper.toResponse;

@Service
public class ListarPostByIdentifyService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AdicionarLikesEmPostResponseService likarPost;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public List<ListarPostResponse> listar(String identify) {
        Usuario usuario = usuarioRepository.findByIdentify(identify);
        Long usuarioLogadoId = usuarioAutenticadoService.getId();
        List<Post> posts = postRepository.listarPostsDoPerfil(usuario.getId() ,usuarioLogadoId);

        List<ListarPostResponse> response = toResponse(posts);
        likarPost.likar(response);

        return response;
    }

}
