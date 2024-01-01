package com.example.springboottut.EmpApp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {


// hard coded users
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//
//        UserDetails user1 = User.builder().username("user1").password("{noop}user1").roles("EMPLOYEE").build();
//        UserDetails user2 = User.builder().username("user2").password("{noop}user2").roles("EMPLOYEE","MANAGER").build();
//        UserDetails user3 = User.builder().username("user3").password("{noop}user3").roles("EMPLOYEE","MANAGER","ADMIN").build();
//
//        return  new InMemoryUserDetailsManager(user1,user2,user3);
//
//
//
//    }

    //security user from db
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }



    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws  Exception{
        http.authorizeHttpRequests(

                configure->configure
                        .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")


        );

        //basic auth
        http.httpBasic(Customizer.withDefaults());
//        disable csrf
        http.csrf(AbstractHttpConfigurer::disable);

        return  http.build();

    }
}
