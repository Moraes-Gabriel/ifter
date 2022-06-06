package br.com.ifter.service;

import br.com.ifter.model.Usuario;
import br.com.ifter.repository.UsuarioRepository;
import br.com.ifter.service.security.UsuarioAutenticadoService;
import br.com.ifter.service.validar.ValidarSeNaoEstaSeguindoVoceMesmo;
import br.com.ifter.service.validar.ValidarSeVoceJaNaoSegueEsseUsuario;
import br.com.ifter.service.validar.ValidarSeVoceJaSegueUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Service
public class RecusarSolicitacaoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;


    public void recusar(String identify) {

        Usuario usuarioSeguido = usuarioRepository.findByIdentify(identify);
        Usuario usuarioSeguidor = usuarioAutenticadoService.get();

        if (usuarioSeguido.requestFriendly.contains(usuarioSeguidor)){
            throw new ResponseStatusException(UNAUTHORIZED, "Você nao contem um pedido de amizade desse usuario!");
        }

        usuarioSeguido.declineRequest(usuarioSeguidor);
        usuarioSeguido.removeRequest(usuarioSeguidor);

        usuarioRepository.save(usuarioSeguidor);
        usuarioRepository.save(usuarioSeguido);
    }
}
