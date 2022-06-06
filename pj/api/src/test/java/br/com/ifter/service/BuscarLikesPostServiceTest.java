package br.com.ifter.service;

import br.com.ifter.controller.response.ListarPostResponse;
import br.com.ifter.repository.PostRepository;
import br.com.ifter.service.security.UsuarioAutenticadoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

    @ExtendWith(MockitoExtension.class)
    class BuscarLikesPostServiceTest {

        @Mock
        private PostRepository postRepository;

        @Mock
        private UsuarioAutenticadoService usuarioAutenticadoService;

        @Test
        @DisplayName("Deve buscar likes do post com sucesso")
        void deveBuscarLikesDoPostComSucesso() {

            int verificado = 2;


            ListarPostResponse response = new ListarPostResponse();
         }
}