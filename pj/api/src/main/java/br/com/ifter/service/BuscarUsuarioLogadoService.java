package br.com.ifter.service;

import br.com.ifter.controller.response.UsuarioResponse;
import br.com.ifter.model.Usuario;
import br.com.ifter.service.security.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.ifter.mapper.UsuarioMapper.toResponse;

@Service
public class BuscarUsuarioLogadoService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public UsuarioResponse buscar(){
        Usuario usuario = usuarioAutenticadoService.get();
        return toResponse(usuario);
    }
}
