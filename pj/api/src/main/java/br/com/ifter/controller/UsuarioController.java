package br.com.ifter.controller;

import br.com.ifter.controller.request.ModificarUsuarioRequest;
import br.com.ifter.controller.response.IncluirUsuarioResponse;
import br.com.ifter.controller.response.UsuarioResponse;
import br.com.ifter.service.*;
import br.com.ifter.controller.request.IncluirUsuarioRequest;
import br.com.ifter.service.validar.VerificarSeSaoAmigosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioController {


    @Autowired
    private IncluirUsuarioService incluirUsuarioService;

    @Autowired
    private SeguirDeseguirUsuarioService seguirDeseguirUsuarioService;

    @Autowired
    private ListarUsuarioPorPesquisaByIdentifyService listarUsuarioPorPesquisaByIdentifyService;

    @Autowired
    private VerificarSeSaoAmigosService verificarSeSaoAmigosService;

    @Autowired
    private BuscarUsuarioByIdentifyService buscarUsuarioByIdentifyService;

    @Autowired
    private ListarNotificacaoService listarNotificacaoService;
    @Autowired
    private listarUsuariosPageService listarUsuariosPageService;

    @Autowired
    private AceitarSolicitacaoService aceitarSolicitacaoService;

    @Autowired
    private RecusarSolicitacaoService recusarSolicitacaoService;

    @Autowired
    private BuscarUsuarioLogadoService buscarUsuarioLogadoService;

    @Autowired
    private ModificarUsuarioService modificarUsuarioservice;

    @PostMapping()
    public IncluirUsuarioResponse incluir (@Valid @RequestBody IncluirUsuarioRequest request) {
        return incluirUsuarioService.incluir(request);
    }

    @GetMapping()
    @Secured("ROLE_USER")
    public UsuarioResponse buscarUsuarioLogado(){
        return buscarUsuarioLogadoService.buscar();
    }

    @GetMapping("verificar/amigos/identify/{identity}")
    @Secured("ROLE_USER")
    public Boolean verificarSeSaoAmigos(@PathVariable String identity){
        return verificarSeSaoAmigosService.verificar(identity);
    }

    @GetMapping("pesquisar/{pesquisar}")
    @Secured("ROLE_USER")
        public List<UsuarioResponse> listarUsuarioPorPesquisaByIdentify(@PathVariable String pesquisar){
        return listarUsuarioPorPesquisaByIdentifyService.buscar(pesquisar);
    }

    @GetMapping("pesquisar/identify/{identify}")
    @Secured("ROLE_USER")
    public UsuarioResponse buscarUsuarioByIdentify(@PathVariable String identify){
        return buscarUsuarioByIdentifyService.buscar(identify);
    }

    @PutMapping("/seguir/{identifyUsuario}")
    @Secured("ROLE_USER")
    public void seguir(@PathVariable String identifyUsuario) {
        seguirDeseguirUsuarioService.fazer(identifyUsuario);
    }

    @PutMapping("/deseguir/{identifyUsuario}")
    @Secured("ROLE_USER")
    public void deseguir(@PathVariable String identifyUsuario) {
        seguirDeseguirUsuarioService.fazer(identifyUsuario);
    }

    @PutMapping("/aceitar/solicitacao/{identify}")
    @Secured("ROLE_USER")
    public void aceitarSolicitacao(@PathVariable String identify) {
        aceitarSolicitacaoService.aceitar(identify);
    }

    @PutMapping("/recusar/solicitacao/{identify}")
    @Secured("ROLE_USER")
    public void recusarSolicitacao(@PathVariable String identify) {
        recusarSolicitacaoService.recusar(identify);
    }

    @GetMapping("notificacao")
    public List<UsuarioResponse> listarNotificacao() {
        return listarNotificacaoService.listar();
    }

    @PutMapping("/modificar")
    @Secured("ROLE_USER")
    public void modificarUsuario(@Valid @RequestBody ModificarUsuarioRequest request) {
         modificarUsuarioservice.modificar(request);
    }

    @GetMapping("/todos")
    public List<UsuarioResponse> listarNotificacao(Pageable page) {
        return listarUsuariosPageService.listar(page);
    }
}

