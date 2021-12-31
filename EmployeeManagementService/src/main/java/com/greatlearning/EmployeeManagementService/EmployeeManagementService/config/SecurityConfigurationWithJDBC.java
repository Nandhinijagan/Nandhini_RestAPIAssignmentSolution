package com.greatlearning.EmployeeManagementService.EmployeeManagementService.config;


import javax.sql.DataSource;

import com.greatlearning.EmployeeManagementService.EmployeeManagementService.service.UserDetailsServiceImpl;
import jdk.nashorn.internal.ir.visitor.NodeOperatorVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfigurationWithJDBC extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    DataSource dataSource;

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(getPasswordEncoder());
        return authProvider;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/employees/{employeeId}").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/employees/save").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/employees/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.GET, "/employees/list","/employees/sort", "/employees/search").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/users").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.POST, "/roles/save", "/roles/list").hasAuthority("ADMIN")
                .and().httpBasic()
                .and().cors().and().csrf().disable().formLogin().disable();
        http.headers().frameOptions().disable();

    }

    //	If you don't want to encode the created password, you can write the below bean method, FYI: not recommended for Prod env

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/h2-console/**");

    }
}
