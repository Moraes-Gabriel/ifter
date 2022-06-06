package br.com.ifter.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
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
public class Usuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String identify;

    @Column(nullable = false)
    private String nickName;
    @Column(nullable = false,unique = true)
    private String email;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;

    @Column(nullable = false)
    private String senha;

    private String image_perfil;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Post> posts;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<Permissao> permissoes;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_RELATIONS",
            joinColumns = @JoinColumn(name = "FOLLOWED_ID"),
            inverseJoinColumns = @JoinColumn(name = "FOLLOWER_ID"))
    public List<Usuario> followers;

    @ManyToMany(mappedBy = "followers")
    private List<Usuario> following ;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_FRIENDLY",
            joinColumns = @JoinColumn(name = "friendSolicited_ID"),
            inverseJoinColumns = @JoinColumn(name = "friendAccept_ID"))
    public List<Usuario> friend;

    @ManyToMany(mappedBy = "friend")
    private List<Usuario> friends ;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_REQUEST",
            joinColumns = @JoinColumn(name = "FOLLOWED_ID"),
            inverseJoinColumns = @JoinColumn(name = "FOLLOWER_ID"))
    public List<Usuario> requestFriendly;

    @ManyToMany(mappedBy = "requestFriendly")
    private List<Usuario> requestedFriendly ;

    public void addFollower(Usuario follower) {
        followers.add(follower);
        follower.following.add(this);
    }
    public void removeFollower(Usuario userRemove) {
        following.remove(userRemove);
        userRemove.followers.remove(this);

    }
    public void addRequest(Usuario follower) {
        requestFriendly.add(follower);
        follower.requestedFriendly.add(this);
    }
    public void removeRequest(Usuario follower) {
        requestFriendly.remove(follower);
        follower.requestedFriendly.remove(this);
    }
    public void removeFriends(Usuario userRemove) {
        friends.remove(userRemove);
        userRemove.getFriends().remove(this);
        friend.remove(userRemove);
        userRemove.friend.remove(this);
    }
    public void acceptRequest(Usuario followed) {
        following.add(followed);
        friends.add(followed);
        friend.add(followed);

        followed.friends.add(followed);
        followed.followers.add(this);
        followed.friend.add(this);
    }
    public void declineRequest(Usuario followed) {
        requestFriendly.remove(followed);
        followed.requestedFriendly.remove(this);
    }
}
