package br.com.ifter.service;

import br.com.ifter.model.Usuario;
import br.com.ifter.repository.UsuarioRepository;
import br.com.ifter.service.security.UsuarioAutenticadoService;
import br.com.ifter.service.validar.ValidarSeNaoEstaSeguindoVoceMesmo;
import br.com.ifter.service.validar.ValidarSeVoceJaNaoSegueEsseUsuario;
import br.com.ifter.service.validar.ValidarSeVoceJaSegueUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeguirDeseguirUsuarioService {

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

    @Autowired
    private AceitarSolicitacaoService aceitarSolicitacaoService;

    public void fazer(String identifyUsuario) {

        Usuario usuarioRealizar = usuarioAutenticadoService.get();
        Usuario usuarioSerSeguidoOuDeseguido = usuarioRepository.findByIdentify(identifyUsuario);

        validarSeNaoEstaSeguindoVoceMesmo.validar(usuarioRealizar, usuarioSerSeguidoOuDeseguido);

        if(usuarioSerSeguidoOuDeseguido.followers.contains(usuarioRealizar)){
            deseguir(usuarioRealizar,usuarioSerSeguidoOuDeseguido);
        }else {
            seguir(usuarioRealizar, usuarioSerSeguidoOuDeseguido);
        }

    }

    private void deseguir(Usuario usuarioQueVaiDeseguir, Usuario usuarioRemovido) {

        verValidarSeVoceJaSegueUsuario.validar(usuarioQueVaiDeseguir, usuarioRemovido);

        usuarioQueVaiDeseguir.removeFollower(usuarioRemovido);
        if(usuarioQueVaiDeseguir.getRequestedFriendly().contains(usuarioRemovido)){
            usuarioRemovido.removeRequest(usuarioQueVaiDeseguir);
        }else{
            usuarioQueVaiDeseguir.removeRequest(usuarioRemovido);
        }

        if(usuarioQueVaiDeseguir.getFriends().contains(usuarioRemovido) ||
                usuarioRemovido.getFriends().contains(usuarioQueVaiDeseguir)){
            usuarioQueVaiDeseguir.removeFriends(usuarioRemovido);
        }
        usuarioRepository.save(usuarioQueVaiDeseguir);
    }

    private void seguir(Usuario usuarioSeguidor, Usuario usuarioSeguido) {

        validarSeVoceJaNaoSegueEsseUsuario.validar(usuarioSeguidor, usuarioSeguido);

        if(usuarioSeguidor.getRequestFriendly().contains(usuarioSeguido)){
            aceitarSolicitacaoService.aceitar(usuarioSeguido.getIdentify());
        }else{
        usuarioSeguido.addFollower(usuarioSeguidor);
        usuarioSeguido.addRequest(usuarioSeguidor);
        }

        usuarioRepository.save(usuarioSeguidor);
    }
}
