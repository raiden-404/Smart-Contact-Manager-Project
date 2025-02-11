package com.contactmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//MyConfig class - declare bean for Spring Security and http chaining security
@Configuration
public class MyConfig {

    private final UserDetailsService userDetailsService;

    // ✅ Constructor Injection (Avoids Circular Dependency)
    public MyConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    // BCryptPasswordEncoder used to encode password into hash function
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // DaoAuthenticationProvier class used in SpringSecurity for Authentication
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        // take UserDetailService instent for fetching user details
        provider.setUserDetailsService(userDetailsService);
        // use PasswordEncoder to verify the authentication
        provider.setPasswordEncoder(passwordEncoder());
        // spring securtiy can use this provider for authentication
        return provider;
    }

    // method authenticationManager takes an AuthenticationConfiguration object
    // AuthenticationConfiguration is part of Spring security provides configuration
    // for authentication
    // Define it as a bean make spring container mantain its object and use it for
    // authentication
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        // .getAuthenticationManager method provid AuthenticationManager
        return authConfig.getAuthenticationManager();
    }

    /**
     * *
     * The method securityFilterChain takes an HttpSecurity object as a parameter.
     * This object is part of Spring Security and is used to configure web-based
     * security for specific HTTP requests.
     **/
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/user/**").hasRole("USER")
                        .requestMatchers("/**").permitAll())
                .formLogin(form -> form
                        .loginPage("/login") // Custom login page url
                        .loginProcessingUrl("/login_process") // The URL spring security will handle authentication
                        .defaultSuccessUrl("/user/index", true) // Redirect after successfull login
                        .failureUrl("/login?error=true") // Redirect on failure
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout") // Logout endpoint url defined by spring securtiy
                        .logoutSuccessUrl("/login?logout=true") // redirect after successfull logout
                // we can also add some extra function for handle logout behaviour
                );

        return http.build();
    }
}