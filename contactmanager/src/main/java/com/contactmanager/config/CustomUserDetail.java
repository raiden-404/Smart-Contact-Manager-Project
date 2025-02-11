package com.contactmanager.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.contactmanager.entities.User;

//used to return the id, password and list of roles assigned to the user
public class CustomUserDetail implements UserDetails {

    private User user;

    // constructor for this class
    public CustomUserDetail(User user) {
        this.user = user;
    }

    // return list of roles
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getRole());
        return List.of(simpleGrantedAuthority);
    }

    // return password
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    // return username which is email here
    @Override
    public String getUsername() {
        return user.getEmail();
    }

}
