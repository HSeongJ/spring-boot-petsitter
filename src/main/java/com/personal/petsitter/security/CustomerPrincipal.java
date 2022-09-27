package com.personal.petsitter.security;

import com.personal.petsitter.entities.customer.CustomerEntity;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CustomerPrincipal implements UserDetails {

    private static final long serialVersionUID = -3938948583663245575L;

    private Long idx;

    private String id;

    private String name;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public CustomerPrincipal() {}

    public CustomerPrincipal(Long idx, String id, String name, String password, Collection<? extends GrantedAuthority> authorities) {
        this.idx = idx;
        this.id = id;
        this.name = name;
        this.password = password;

        if(authorities == null) {
            this.authorities = null;
        } else {
            this.authorities = new ArrayList<>(authorities);
        }
    }

    public static CustomerPrincipal create(CustomerEntity customer) {
        List<GrantedAuthority> authorities = customer.getRoleSet().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.name())).collect(Collectors.toList());
        return new CustomerPrincipal(customer.getIdx(), customer.getId(), customer.getName(), customer.getPassword(), authorities);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return id;
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
