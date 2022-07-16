package br.com.ifter.service;

import br.com.ifter.controller.response.PostResponse;
import br.com.ifter.model.Post;
import br.com.ifter.service.buscar.BuscarPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.ifter.mapper.PostMapper.toResponse;

@Service
public class BuscarPostPorIdService {


    @Autowired
    private BuscarPostService buscarPostService;

    @Autowired
    private AdicionarLikesEmPostResponseService adicionarLikes;

    public PostResponse buscar(Long postId){
       Post post = buscarPostService.porId(postId);

        PostResponse response = toResponse(post);
        adicionarLikes.likar(response);

        return response;
    }
}
