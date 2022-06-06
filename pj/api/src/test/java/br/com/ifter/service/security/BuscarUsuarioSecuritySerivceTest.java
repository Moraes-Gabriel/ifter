package br.com.ifter.service.security;

import br.com.ifter.repository.UsuarioRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BuscarUsuarioSecuritySerivceTest {

    @InjectMocks
    private BuscarUsuarioSecuritySerivce buscarUsuarioSecuritySerivce;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Test
    @DisplayName("Deve adicionar uma corrida com sucesso")
    void buscar() {

    }
}