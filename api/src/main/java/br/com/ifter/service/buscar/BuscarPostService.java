package br.com.ifter.service.buscar;

import br.com.ifter.model.Post;
import br.com.ifter.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class BuscarPostService {

    @Autowired
    private PostRepository repository;

    public Post porId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Post não encontrado"));
    }
}
