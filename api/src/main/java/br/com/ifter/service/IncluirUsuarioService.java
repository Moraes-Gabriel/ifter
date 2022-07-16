package br.com.ifter.service;

import br.com.ifter.controller.response.IncluirUsuarioResponse;
import br.com.ifter.mapper.IncluirUsuarioMapper;
import br.com.ifter.model.Permissao;
import br.com.ifter.model.Usuario;
import br.com.ifter.repository.UsuarioRepository;
import br.com.ifter.controller.request.IncluirUsuarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static br.com.ifter.mapper.IncluirUsuarioMapper.toEntity;

@Service
public class IncluirUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public IncluirUsuarioResponse incluir(IncluirUsuarioRequest request) {
        request.setSenha(passwordEncoder.encode(request.getSenha()));

        Permissao permissao = new Permissao();
        permissao.setNome("USER");


        Usuario usuario = toEntity(request);
        usuario.setPermissoes(new ArrayList<Permissao>());
        usuario.getPermissoes().add(permissao);
        usuarioRepository.save(usuario);

        return IncluirUsuarioMapper.toResponse(usuario);
    }
}
