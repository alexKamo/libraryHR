package com.projectHR.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

public class DemoSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails alexander = User.builder()
                .username("alexander")
                .password("{noop}test1")
                .roles("EMPLOYEE")
                .build();

        UserDetails jessica = User.builder()
                .username("jessica")
                .password("{noop}test12")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails dave = User.builder()
                .username("dave")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(alexander,jessica,dave);
    }
    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer -> configurer
                                .requestMatchers(HttpMethod.GET, "/").hasAnyRole("USER", "EMPLOYEE")
                                .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.GET, "/api/books").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")//);
//        http.httpBasic(Customizer.withDefaults());
                                //disable Cross Site Request Forgery (CSRF)
                                .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/showMyLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll()
                );
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
