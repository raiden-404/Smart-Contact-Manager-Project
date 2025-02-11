package com.contactmanager.helperClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.contactmanager.entities.User;

@Component
public interface JpaRepo extends JpaRepository<User, Integer> {

    // used for spring security to fetch user by their email
    @Query("select u from User u where u.email = :email")
    public User getUserByUsername(@Param("email") String email);

}
