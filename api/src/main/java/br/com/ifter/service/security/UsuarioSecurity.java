package br.com.ifter.service.security;

import br.com.ifter.model.Usuario;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioSecurity implements UserDetails {

    private Long id;
    private String email;
    private String senha;
    private String identify;
    private String nickName;
    private List<SimpleGrantedAuthority> permissoes;

    public UsuarioSecurity(Usuario usuario) {
        this.id = usuario.getId();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.identify = usuario.getIdentify();
        this.nickName = usuario.getNickName();
        this.permissoes = convertePermissoes(usuario);
    }

    private List<SimpleGrantedAuthority> convertePermissoes(Usuario usuario) {
        return usuario.getPermissoes().stream()
                .map(permissao -> new SimpleGrantedAuthority("ROLE_" + permissao.getNome()))
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    @Override
    public List<SimpleGrantedAuthority> getAuthorities() {
        return this.permissoes;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
