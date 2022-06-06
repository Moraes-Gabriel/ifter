package br.com.ifter.service;

import br.com.ifter.controller.response.UsuarioResponse;
import br.com.ifter.mapper.UsuarioMapper;
import br.com.ifter.model.Usuario;
import br.com.ifter.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.ifter.mapper.UsuarioMapper.toResponse;

@Service
public class listarUsuariosPageService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<UsuarioResponse> listar(Pageable page) {
        Page<Usuario> pageUsuarios = usuarioRepository.findAll(page);
        return UsuarioMapper.toResponse(pageUsuarios.getContent());
    }
}
