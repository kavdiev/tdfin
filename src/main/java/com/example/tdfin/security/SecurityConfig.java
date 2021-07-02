package com.example.tdfin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username as principal ,password from app_user where username=?")
                .authoritiesByUsernameQuery(
                        "select app_user_username as principal , roles_role_name as role from app_user_roles "
                                + "where app_user_username=?")
                .passwordEncoder(bCryptPasswordEncoder).rolePrefix("ROLE_");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.formLogin().disable();
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/login/**","register/**", "/h2/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/**").hasRole("ADMIN");
        http.authorizeRequests().anyRequest().authenticated();

    }


}
