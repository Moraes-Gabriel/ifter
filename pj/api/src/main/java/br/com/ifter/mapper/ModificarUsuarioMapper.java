package br.com.ifter.mapper;

import br.com.ifter.controller.request.IncluirUsuarioRequest;
import br.com.ifter.controller.request.ModificarUsuarioRequest;
import br.com.ifter.controller.response.IncluirUsuarioResponse;
import br.com.ifter.model.Usuario;
import org.modelmapper.ModelMapper;

public class ModificarUsuarioMapper {

    public static Usuario toEntity(ModificarUsuarioRequest request) {
        return new ModelMapper().map(request, Usuario.class);
    }


}
