package br.com.ifter.service;

import br.com.ifter.controller.response.UsuarioResponse;
import br.com.ifter.model.Usuario;
import br.com.ifter.repository.UsuarioRepository;
import br.com.ifter.service.buscar.BuscarPostService;
import br.com.ifter.service.validar.VerificarSeSaoAmigosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.ifter.mapper.ListarUsuarioMapper.toResponse;

@Service
public class ListarUsuarioPorPesquisaByIdentifyService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private VerificarSeSaoAmigosService verificarSeSaoAmigosService;

    public List<UsuarioResponse> buscar(String procurar) {

        List<Usuario> usuarios = usuarioRepository.
                findUsuarioByIdentifyStartingWithIgnoreCaseOrEmailStartingWithIgnoreCase(procurar, procurar);
        List<UsuarioResponse> response = toResponse(usuarios);

        response.forEach(user ->
            user.setAmigo(verificarSeSaoAmigosService.verificar(user))
                );

        return response;
    }
}
