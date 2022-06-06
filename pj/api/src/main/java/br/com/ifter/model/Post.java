package br.com.ifter.model;


import lombok.*;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@NoArgsConstructor
@AllArgsConstructor
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Entity
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    private LocalDateTime dateCreation;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryPost category;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "POST_RELATIONS",
            joinColumns = @JoinColumn(name = "POSTED_ID"),
            inverseJoinColumns = @JoinColumn(name = "POSTER_ID"))
    public List<Post> posts;

    @ManyToMany(cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST
    })
    @JoinTable(
            name = "post_user_like",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<Usuario> likedUsers;

    public void adicionarCurtida(Usuario usuario) {
        likedUsers.add(usuario);
    }

    public void removerCurtida(Usuario usuario) {
        likedUsers.remove(usuario);
    }
    public void adicionarComentario(Post post) {
        posts.add(post);
    }

    public void removerComentario(Post post) {
        posts.remove(post);
    }
}
