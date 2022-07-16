package br.com.ifter.service;

import br.com.ifter.controller.response.UsuarioResponse;
import br.com.ifter.mapper.UsuarioMapper;
import br.com.ifter.model.Usuario;
import br.com.ifter.service.security.UsuarioAutenticadoService;
import br.com.ifter.service.util.UsuarioFactory;
import br.com.ifter.service.util.UsuarioResponseFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BuscarUsuarioLogadoServiceTest {

    @Mock
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @InjectMocks
    private BuscarUsuarioLogadoService service;


    @Test
    @DisplayName("Deve buscar usuario logado com sucesso")
    void deveBuscarUsuarioLogadoComSucesso() {
    Usuario usuario =  UsuarioFactory.get();
        UsuarioResponse response = UsuarioResponseFactory.get();
    Mockito.when(usuarioAutenticadoService.get()).thenReturn(usuario);

    service.buscar();

    Mockito.verify(UsuarioMapper.toResponse(usuario));

    }
}