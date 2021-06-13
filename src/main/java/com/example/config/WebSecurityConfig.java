package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity


public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    protected PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("test").password("test").roles("USER")
                .and()
                .withUser("admin").password("admin").roles("admin");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/index", "/personList") // mamy dostęp do ROLE_USER tylko do tych wymienionych endpointów
                .hasAnyAuthority("ROLE_USER")// definiujemy role dla powyższych dostępów
                .antMatchers("/technology", "/tasks")// mamy dostęp tylko do tych 2 endpointów
                .hasAnyAuthority("ROLE_ADMIN") // definiujemy role dla dostepów
                .and().csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .formLogin()
                .loginPage("/login") // autoryzacja
                .usernameParameter("username") //login
                .passwordParameter("password") //hasło
                .loginProcessingUrl("/login")
                .failureForwardUrl("/login?error") // error
                .and()
                .logout()
                .logoutSuccessUrl("/login")


        ;

    }


}
