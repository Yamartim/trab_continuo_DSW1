package br.ufscar.dc.dsw.security;

import java.util.Arrays;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import br.ufscar.dc.dsw.domain.User;
 
@SuppressWarnings("serial")
public class UsuarioDetails implements UserDetails {
 
    private User usuario;
     
    public UsuarioDetails(User usuario) {
        this.usuario = usuario;
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRole());
        return Arrays.asList(authority);
    }
 
    @Override
    public String getPassword() {
        return usuario.getPassword();
    }
 
    @Override
    public String getUsername() {
        return usuario.getUsername();
    }
    
    public long getId() {
        return usuario.getId();
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
    
    public User getUsuario() {
    	return usuario;
    }
}
