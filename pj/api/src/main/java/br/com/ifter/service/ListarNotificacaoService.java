package br.com.ifter.service;


import br.com.ifter.controller.response.UsuarioResponse;
import br.com.ifter.mapper.ListarUsuarioMapper;
import br.com.ifter.model.Usuario;
import br.com.ifter.repository.UsuarioRepository;
import br.com.ifter.service.security.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.ifter.mapper.ListarUsuarioMapper.toResponse;

@Service
public class ListarNotificacaoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioAutenticadoService autenticadoService;

    public List<UsuarioResponse> listar(){
        Long id = autenticadoService.getId();
        Usuario usuario = usuarioRepository.findById(id).get();

        return toResponse(usuario.requestFriendly);
    }
}
