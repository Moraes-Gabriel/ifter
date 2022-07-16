package br.com.ifter.service.validar;

import br.com.ifter.model.Post;
import br.com.ifter.model.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Component
public class ValidarSeUsuarioJaCurtiuOPostService {

    public void validar(Usuario usuario, Post post){
        if (post.getLikedUsers().contains(usuario)){
            throw new ResponseStatusException(UNAUTHORIZED, "Voce ja curtiu esse post!");
        }

    }
}
