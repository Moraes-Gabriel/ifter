package br.com.ifter.service;

import br.com.ifter.model.Usuario;
import br.com.ifter.repository.UsuarioRepository;
import br.com.ifter.service.security.UsuarioAutenticadoService;
import br.com.ifter.service.validar.ValidarSeNaoEstaSeguindoVoceMesmo;
import br.com.ifter.service.validar.ValidarSeVoceJaNaoSegueEsseUsuario;
import br.com.ifter.service.validar.ValidarSeVoceJaSegueUsuario;
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
class AceitarSolicitacaoServiceTest {

     @InjectMocks
     private AceitarSolicitacaoService aceitarSolicitacaoService;

     @Mock
     private UsuarioRepository usuarioRepository;

     @Mock
     private UsuarioAutenticadoService usuarioAutenticadoService;

     @Mock
     private ValidarSeNaoEstaSeguindoVoceMesmo validarSeNaoEstaSeguindoVoceMesmo;

     @Mock
     private ValidarSeVoceJaNaoSegueEsseUsuario validarSeVoceJaNaoSegueEsseUsuario;

     @Mock
     private ValidarSeVoceJaSegueUsuario verValidarSeVoceJaSegueUsuario;

     @Mock
     private Usuario usuario;

     @Test
     @DisplayName("Deve aceitar solicitacao de amizade com sucesso")
     void deveAceitarSolicitacaoDeAmizadeComSucesso() {


         Usuario usuario = new Usuario();

         usuario.setIdentify(" andre lindo");
         usuario.setNickName("ANDRE");

         Usuario usuarioAutenticado = new Usuario();

         usuario.setIdentify(" MORAES MAIS LINDO");
         usuario.setNickName("Moraes");

         Mockito.when(usuarioRepository.findByIdentify("Andre Lindo")).thenReturn(usuario);

         Mockito.when(usuarioAutenticadoService.get()).thenReturn(usuarioAutenticado);

         //Mockito.verify(usuario).acceptRequest(usuarioAutenticado);
         //Mockito.verify(usuario).removeRequest(usuarioAutenticado);

         Mockito.verify(usuarioRepository).save(usuario);
         Mockito.verify(usuarioRepository).save(usuarioAutenticado);
     }
 }