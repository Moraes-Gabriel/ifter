package br.com.ifter.service;

import br.com.ifter.controller.response.UsuarioResponse;
import br.com.ifter.model.Usuario;
import br.com.ifter.repository.UsuarioRepository;
import br.com.ifter.service.util.UsuarioFactory;
import br.com.ifter.service.util.UsuarioResponseFactory;
import br.com.ifter.service.validar.VerificarSeSaoAmigosService;
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
class BuscarUsuarioByIdentifyServiceTest {

    @InjectMocks
    private BuscarUsuarioByIdentifyService buscarUsuarioByIdentifyService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private VerificarSeSaoAmigosService verificarSeSaoAmigosService;


    @Test
    @DisplayName("Deve buscar usuario by identify com sucesso")
    void deveBuscarUsuarioByIdentifyComSucesso() {

        String identify  = "moraes24";
        Usuario usuario = UsuarioFactory.get();
        UsuarioResponse response = UsuarioResponseFactory.get();

        Mockito.when(usuarioRepository.findByIdentify
                (identify)).thenReturn(usuario);

        Mockito.verify(response).setAmigo(verificarSeSaoAmigosService.verificar(response));
        }
}