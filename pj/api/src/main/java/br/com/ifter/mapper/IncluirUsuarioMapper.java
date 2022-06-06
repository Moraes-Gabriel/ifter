package br.com.ifter.mapper;

import br.com.ifter.controller.response.IncluirUsuarioResponse;
import br.com.ifter.model.Usuario;
import br.com.ifter.controller.request.IncluirUsuarioRequest;
import org.modelmapper.ModelMapper;

public class IncluirUsuarioMapper {

    public static Usuario toEntity(IncluirUsuarioRequest request) {
        return new ModelMapper().map(request, Usuario.class);
    }

    public static IncluirUsuarioResponse toResponse(Usuario entity) {
        return new ModelMapper().map(entity, IncluirUsuarioResponse.class);
    }

}
