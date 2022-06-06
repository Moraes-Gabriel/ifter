package br.com.ifter.controller;

import br.com.ifter.controller.request.IncluirComentarioRequest;
import br.com.ifter.controller.request.IncluirPostRequest;
import br.com.ifter.controller.response.IncluirPostResponse;
import br.com.ifter.controller.response.ListarPostResponse;
import br.com.ifter.controller.response.PostResponse;
import br.com.ifter.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static br.com.ifter.mapper.ListarPostMapper.toResponse;

@CrossOrigin
@RestController
@RequestMapping("/post")
public class PostController {


    @Autowired
    private IncluirPostService incluirPostService;

    @Autowired
    private ListarPostByIdentifyService listarPostByIdentifyService;

    @Autowired
    private ListarPostService listarPostService;

    @Autowired
    private ListarPostDosUsuariosQueSegueService listarPostDosUsuariosQueSegueService;

    @Autowired
    private CurtirPostService curtirPostService;

    @Autowired
    private DescurtirPostService descutirPostService;

    @Autowired
    private IncluirComentarioService incluirComentarioService;

    @Autowired
    private BuscarPostPorIdService buscarPostPorIdService;

    @Autowired
    private ListarComentariosDoPostPorIdService listarComentariosDoPostPorIdService;


    @PostMapping("/incluir")
    @Secured("ROLE_USER")
    public IncluirPostResponse incluir(@Valid @RequestBody IncluirPostRequest request) {
        return incluirPostService.incluir(request);
    }

    @GetMapping("/listar/identify/{identify}")
    public List<ListarPostResponse> listarPostByIdentifyResponse
            (@PathVariable String identify) {
        return listarPostByIdentifyService.listar(identify);
    }

    @GetMapping("/buscar/{postId}")
    public PostResponse buscarPostPorId(@PathVariable Long postId) {
        return buscarPostPorIdService.buscar(postId);
    }

    @GetMapping("/listar/comentarios/{postId}")
    public List<ListarPostResponse> listar(@PathVariable Long postId) {
        return listarComentariosDoPostPorIdService.listar(postId);
    }

    @GetMapping("/listar/publico")
    public List<ListarPostResponse> listar() {
        return listarPostService.listar();
    }

    @GetMapping("/listar/feed")
    public List<ListarPostResponse> listarPostSeguindo() {
        return listarPostDosUsuariosQueSegueService.listar();
    }

    @PutMapping("curtir/{postId}")
    public void curtir(@PathVariable Long postId) {
        curtirPostService.curtir(postId);
    }

    @PutMapping("descurtir/{postId}")
    public void descurtir(@PathVariable Long postId) {
        descutirPostService.descurtir(postId);
    }

    @PutMapping("incluir/comentario/{postId}")
    public void incluirComentario(@PathVariable Long postId,
                                  @Valid @RequestBody IncluirComentarioRequest request) {
        incluirComentarioService.incluirComentario(postId, request);
    }
}
