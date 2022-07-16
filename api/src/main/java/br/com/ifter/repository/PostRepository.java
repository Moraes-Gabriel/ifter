package br.com.ifter.repository;

import br.com.ifter.model.Post;
import br.com.ifter.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(
            value = "SELECT p.* From post p \n" +
                    "where p.usuario_id = ?1 \n" +
                    "and p.category != 'COMMENT' \n" +
                    "UNION ALL \n" +
                    "SELECT p.* FROM post p INNER JOIN user_friendly f \n" +
                    "ON f.friend_solicited_id = p.usuario_id \n" +
                    "WHERE f.friend_accept_id = ?1 \n" +
                    "AND p.category = 'PRIV' \n" +
                    "AND p.category != 'COMMENT'\n" +
                    "UNION ALL \n" +
                    "SELECT p.* FROM post p INNER JOIN user_relations u \n" +
                    "ON u.followed_id =  p.usuario_id \n" +
                    "AND p.category = 'PUBLIC' \n" +
                    "WHERE u.follower_id = ?1 \n" +
                    "ORDER BY date_creation DESC \n",
            nativeQuery = true
    )
    List<Post> listarPostsDosUsuariosQueSegueESaoAmigos(Long usuarioId);

    @Query(
            value = "SELECT p.* FROM post P \n" +
                    "INNER JOIN user_friendly f \n" +
                    "ON f.friend_accept_id = p.usuario_id \n" +
                    "WHERE f.friend_solicited_id = ?2 \n" +
                    "AND p.usuario_id = ?1 \n" +
                    "AND p.category = 'PRIV' \n" +
                    "UNION ALL \n" +
                    "SELECT p.* FROM post p \n" +
                    "WHERE p.usuario_id = ?1 \n" +
                    "AND p.category = 'PUBLIC' \n" +
                    "OR p.usuario_id = ?1 \n" +
                    "AND p.usuario_id = ?2 \n" +
                    "AND p.category != 'COMMENT' \n" +
                    "ORDER BY date_creation DESC  ",
            nativeQuery = true
    )
    List<Post> listarPostsDoPerfil(Long usuarioRequisitado, Long usuarioLogado);



    @Query(
            value = " SELECT COUNT(post_id) \n" +
                    " FROM post_user_like p \n" +
                    " WHERE p.post_id = ?1",
            nativeQuery = true
    )
    int contarLikesByPostId(Long postId);

    int countByPosts(Long postId);

    @Query(
            value = "SELECT * FROM post p \n" +
                    "INNER JOIN post_relations pr\n" +
                    "on pr.poster_id = p.id\n" +
                    "where pr.posted_id = ?1\n" +
                    "ORDER by p.date_creation DESC",
            nativeQuery = true
    )
    List<Post> listarComentariosPorPostId(Long postId);



}
