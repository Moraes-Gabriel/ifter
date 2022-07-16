package br.com.ifter.service;

import br.com.ifter.controller.request.ModificarUsuarioRequest;
import br.com.ifter.mapper.ModificarUsuarioMapper;
import br.com.ifter.model.Usuario;
import br.com.ifter.repository.UsuarioRepository;
import br.com.ifter.service.security.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModificarUsuarioService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public void modificar(ModificarUsuarioRequest request) {

        Usuario usuario = usuarioAutenticadoService.get();

        usuario.setNickName(request.getNickName());
        usuario.setIdentify(request.getIdentify());
        usuario.setImage_perfil(request.getImage_perfil());

        usuarioRepository.save(usuario);
    }
}
