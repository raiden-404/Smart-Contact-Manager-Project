package com.contactmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.contactmanager.entities.User;
import com.contactmanager.helperClass.JpaRepo;

@Service
// Check that given Username exist in database or not
public class UserDetailServiceImpl implements UserDetailsService {
    // Use jpa Repository to match username from database
    @Autowired
    JpaRepo jpaRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = jpaRepo.getUserByUsername(username);
        // if user name not exists in database then simply thorw exception and close the
        // process
        if (user == null) {
            throw new UsernameNotFoundException("Invalid Username");
        }
        // when username exists in database then use CustomUserDetail class to return
        // its username and password and role to further operations
        CustomUserDetail customUserDetail = new CustomUserDetail(user);
        return customUserDetail;
    }

}
