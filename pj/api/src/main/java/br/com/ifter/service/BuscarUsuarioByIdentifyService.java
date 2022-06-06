package br.com.ifter.service;

import br.com.ifter.controller.response.UsuarioResponse;
import br.com.ifter.model.Usuario;
import br.com.ifter.repository.UsuarioRepository;
import br.com.ifter.service.validar.VerificarSeSaoAmigosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.ifter.mapper.UsuarioMapper.toResponse;

@Service
public class BuscarUsuarioByIdentifyService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private VerificarSeSaoAmigosService verificarSeSaoAmigosService;

    public UsuarioResponse buscar(String identify) {

        Usuario usuario = usuarioRepository.findByIdentify(identify);
        UsuarioResponse response = toResponse(usuario);

        response.setAmigo(verificarSeSaoAmigosService.verificar(response));
        return response;
    }
}
