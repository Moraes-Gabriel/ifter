package br.com.ifter.service.validar;

import br.com.ifter.controller.response.ListarPostResponse;
import br.com.ifter.controller.response.UsuarioResponse;
import br.com.ifter.model.Post;
import br.com.ifter.model.Usuario;
import br.com.ifter.repository.PostRepository;
import br.com.ifter.repository.UsuarioRepository;
import br.com.ifter.service.security.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.ifter.mapper.ListarPostMapper.toResponse;

@Service
public class VerificarSeSaoAmigosService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

 public boolean verificar(UsuarioResponse usuario) {
       Long usuarioId = usuarioAutenticadoService.getId();


     Boolean verificado =usuarioRepository
             .validarSeSaoAmigos(usuario.getId(), usuarioId);

     if(verificado)  return true;
        return false;
    }
    public boolean verificar(String identity) {
        Long usuarioId = usuarioAutenticadoService.getId();
        Usuario usuario = usuarioRepository.findByIdentify(identity);

        Boolean verificado =usuarioRepository
                .validarSeSaoAmigos(usuario.getId(), usuarioId);

        if(verificado)  return true;
        return false;
    }
}
