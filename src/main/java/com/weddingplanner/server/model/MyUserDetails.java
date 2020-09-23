package com.weddingplanner.server.model;

import  org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {

    private String email;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public MyUserDetails(SystemUser user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.active = true;
        this.authorities = AuthorityUtils.createAuthorityList(user.getUserRole());
        System.out.println("Reached");
    }
    public MyUserDetails() {
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
