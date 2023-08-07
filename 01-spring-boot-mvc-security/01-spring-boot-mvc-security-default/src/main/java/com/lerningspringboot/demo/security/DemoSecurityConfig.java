package com.lerningspringboot.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){

        UserDetails ali = User.builder()
                .username("alifathy")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();
        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE", "ADMIN","MANAGER")
                .build();

        return new InMemoryUserDetailsManager(ali,mary,susan);

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)  throws Exception{
        http.authorizeHttpRequests(
                autho -> autho
                        .requestMatchers("/")
                        .hasRole("EMPLOYEE")
                        .requestMatchers("/leaders/**")
                        .hasRole("MANAGER")
                        .requestMatchers("/systems/**")
                        .hasRole("ADMIN")
                        .anyRequest().authenticated())
                .exceptionHandling(
                        configure ->
                                configure
                                        .accessDeniedPage("/access-denied")
                )
                .formLogin(
                        form ->
                                form.loginPage("/showLoginForm")
                                        .loginProcessingUrl("/authenticateTheUser")
                                        .permitAll()
                )
                .logout(logout ->
                        logout.permitAll());
        return http.build();

    }
}
