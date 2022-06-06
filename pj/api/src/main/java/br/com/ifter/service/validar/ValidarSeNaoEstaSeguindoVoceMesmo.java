package br.com.ifter.service.validar;

import br.com.ifter.model.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Component
public class ValidarSeNaoEstaSeguindoVoceMesmo {

    public void validar(Usuario usuarioSeguidor, Usuario usuarioParaSeguir){
        if (usuarioParaSeguir.equals(usuarioSeguidor)){
            throw new ResponseStatusException(UNAUTHORIZED, "Você nao pode seguir voce mesmo!");
        }

    }
}
