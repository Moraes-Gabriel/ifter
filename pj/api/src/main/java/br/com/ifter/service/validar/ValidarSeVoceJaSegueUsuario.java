package br.com.ifter.service.validar;

import br.com.ifter.model.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Component
public class ValidarSeVoceJaSegueUsuario {

    public void validar(Usuario usuarioSeguindo, Usuario usuarioParaSeguir){
        if (!usuarioSeguindo.getFollowing().contains(usuarioParaSeguir)){
            throw new ResponseStatusException(UNAUTHORIZED, "Você nao segue esse usuario, por isso nao pode parar de seguir!");
        }

    }
}
