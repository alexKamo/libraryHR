package com.projectHR.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration {

    // add support for JDBC ... no more hardcoded users :-)

//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//
//       return new JdbcUserDetailsManager(dataSource);
//
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http.authorizeHttpRequests(configurer ->
//                        configurer
//                                .requestMatchers("/").hasAnyRole()
//                                .requestMatchers("/employee/**").hasRole("EMPLOYEE")
//                                .requestMatchers("/manager/**").hasRole("MANAGER")
//                                .anyRequest().authenticated()
//                )
//                .formLogin(form ->
//                        form
//                                .loginPage("/showMyLoginPage")
//                                .loginProcessingUrl("/authenticateTheUser")
//                                .permitAll()
//                )
//                .logout(logout -> logout.permitAll()
//                )
//                .exceptionHandling(configurer ->
//                        configurer.accessDeniedPage("/access-denied")
//                );
//
//        return http.build();
//    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails j = User.builder()
                .username("J")
                .password("{noop}t")
                .roles("USER")
                .build();

        UserDetails r = User.builder()
                .username("R")
                .password("{noop}t")
                .roles("EMPLOYEE")
                .build();

        UserDetails s = User.builder()
                .username("S")
                .password("{noop}t")
                .roles("MANAGER","EMPLOYEE","USER")
                .build();

        return new InMemoryUserDetailsManager(j,r,s);
    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/").hasAnyRole("USER","EMPLOYEE","MANAGER")
                                .requestMatchers("/employee/**").hasRole("EMPLOYEE")
                                .requestMatchers("/manager/**").hasRole("MANAGER")
                                .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form
                                .loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()
                )
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied")
                );

        return http.build();
    }

}
