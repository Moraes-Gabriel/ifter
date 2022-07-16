package br.com.ifter.repository;

import br.com.ifter.controller.response.UsuarioResponse;
import br.com.ifter.model.Post;
import br.com.ifter.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);
    Usuario findByIdentify(String identify);
    @Query(
            value = "SELECT COUNT(u.followed_id) > 0 from user_relations u\n" +
                    "where u.followed_id = ?1 \n" +
                    "AND u.follower_id = ?2",
            nativeQuery = true
    )
    Boolean validarSeSaoAmigos(Long usuarioProcurado, Long usuarioLogado);

    @Query(
            value = "SELECT * FROM usuario u\n" +
                    "WHERE u.identify  LIKE %?1% OR\n" +
                    "u.email LIKE %?1%",
            nativeQuery = true
    )

    List<Usuario> findUsuarioByIdentifyStartingWithIgnoreCaseOrEmailStartingWithIgnoreCase(String email, String identify);
}
