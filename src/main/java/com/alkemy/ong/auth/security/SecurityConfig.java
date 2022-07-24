package com.alkemy.ong.auth.security;

import com.alkemy.ong.auth.filter.JwtRequestFilter;
import com.alkemy.ong.auth.service.UserDetailsCustomService;

import com.alkemy.ong.auth.utility.RoleEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsCustomService userDetailsCustomService;
    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsCustomService);
    }

    @Bean
    public PasswordEncoder PasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                // Auth
                .authorizeRequests().antMatchers(HttpMethod.POST, "/auth/login", "/auth/register").permitAll()

                .antMatchers(HttpMethod.GET, "/auth/me").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                // Users
                .antMatchers(HttpMethod.GET,"/users").hasAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.PATCH,"/users/**").hasAnyAuthority(RoleEnum.USER.getSimpleRoleName(), RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE,"/users/**").hasAnyAuthority(RoleEnum.USER.getSimpleRoleName(), RoleEnum.ADMIN.getSimpleRoleName())
                // Activity
                .antMatchers(HttpMethod.PUT, "/activities/**").hasAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/activities").hasAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.PUT, "/activities/**").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/activities").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                // Categories
                .antMatchers(HttpMethod.GET, "/categories", "/categories/**").hasAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.PUT, "/categories/**").hasAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/categories").hasAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE, "/categories/**").hasAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.GET, "/categories", "/categories/**").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.PUT, "/categories/**").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/categories").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE, "/categories/**").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                // Comments
                .antMatchers(HttpMethod.GET,"/comments").hasAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.GET,"/comments", "/posts/*/comments").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.PUT,"/comments/**").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.POST,"/comments").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE,"/comments/**").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                // Contacts
                .antMatchers(HttpMethod.GET, "/contacts").hasAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.GET, "/contacts").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/contacts").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                // Members
                .antMatchers(HttpMethod.GET, "/members").hasAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.PUT, "/members/**").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/members").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.GET, "/members").hasAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE, "/members/**").hasAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE, "/members/**").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                // News
                .antMatchers(HttpMethod.GET, "/news/**").hasAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.GET, "/news/**").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.PUT, "/news/**").hasAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.PUT, "/news/**").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/news").hasAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/news").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE, "/news/**").hasAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE, "/news/**").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                // Organization
                .antMatchers(HttpMethod.GET, "/organization/public").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/organization").hasAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                // Slides
                .antMatchers(HttpMethod.GET, "/slides", "slides/**").hasAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.GET, "/slides", "slides/**").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.PUT, "/slides/**").hasAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.PUT, "/slides/**").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/slides").hasAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE, "/slides/**").hasAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE, "/slides/**").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                // Testimonials
                .antMatchers(HttpMethod.POST, "/testimonials").hasAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/testimonials").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.PUT, "/testimonials/**").hasAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.PUT, "/testimonials/**").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE, "/testimonials/**").hasAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE, "/testimonials/**").hasAuthority(RoleEnum.USER.getSimpleRoleName())

                .anyRequest().authenticated()
                .and().exceptionHandling()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
}