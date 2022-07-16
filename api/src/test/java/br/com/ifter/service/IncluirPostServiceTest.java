package br.com.ifter.service;

import br.com.ifter.controller.request.IncluirPostRequest;
import br.com.ifter.repository.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class IncluirPostServiceTest {


    @InjectMocks
    private IncluirPostService incluirPostService;

    @Mock
    private PostRepository postRepository;

    @Test
    @DisplayName("Deve adicionar uma corrida com sucesso")
    void deveIncluirUmPostComSucesso() {

        IncluirPostRequest request = new IncluirPostRequest();

        //Mockito.verify(toEnti)

    }


}