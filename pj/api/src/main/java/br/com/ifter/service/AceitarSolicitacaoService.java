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
public class AceitarSolicitacaoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private ValidarSeNaoEstaSeguindoVoceMesmo validarSeNaoEstaSeguindoVoceMesmo;

    @Autowired
    private ValidarSeVoceJaNaoSegueEsseUsuario validarSeVoceJaNaoSegueEsseUsuario;

    @Autowired
    private ValidarSeVoceJaSegueUsuario verValidarSeVoceJaSegueUsuario;

    public void aceitar(String identify) {

        Usuario usuarioFezPedido = usuarioRepository.findByIdentify(identify);
        Usuario usuarioAceitar = usuarioAutenticadoService.get();

         if (!usuarioAceitar.requestFriendly.contains(usuarioFezPedido)){
            throw new ResponseStatusException(UNAUTHORIZED, "Você nao contem um pedido de amizade desse usuario!");
        }

        usuarioAceitar.acceptRequest(usuarioFezPedido);
        usuarioAceitar.removeRequest(usuarioFezPedido);

        usuarioRepository.save(usuarioFezPedido);
        usuarioRepository.save(usuarioAceitar);
    }
}
