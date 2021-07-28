
package com.dimtsk.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
     @Autowired
    private UserDetailsService userDetailsService;
    /*
    AUTH USER
    */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    /*
    AUTHORAZATION
    */
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf()
//                .disable();
        
        http
                .authorizeRequests()
//                .antMatchers("/app/").permitAll()
//                .and()
//                .authorizeRequests()
                .antMatchers("/app/list")
                .authenticated()
                .and()
                .httpBasic();
//        http
//                .authorizeRequests()
//                .antMatchers("/user/join").permitAll()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/user/**")
//                .authenticated()
//                .and()
//                .httpBasic();
                
                
    }
    
}
