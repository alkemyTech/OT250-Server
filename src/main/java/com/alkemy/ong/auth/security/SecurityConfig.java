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

    private static final String[] publicEndpoint = {
            "/swagger-resources/**",
            "/swagger-ui/**", "/v2/api-docs",
            "/v3/api-docs",
            "/api/docs",
            "/api/docs/**",
            "/api/docs/swagger-ui",
            "/swagger-ui.html",
            "/**/swagger-ui/**",
            "/swagger-ui"
    };

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                // Auth
                .authorizeRequests().antMatchers(HttpMethod.POST, "/auth/login", "/auth/register").permitAll()

                .antMatchers(HttpMethod.GET, "/auth/me").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                // Users
                .antMatchers(HttpMethod.GET,"/users").hasAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.PATCH,"/users/me").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE,"/users/me").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.PATCH,"/users/**").hasAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE,"/users/**").hasAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                // Activity
                .antMatchers(HttpMethod.PUT, "/activities/**").hasAnyAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/activities").hasAnyAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.GET, "/activities").hasAnyAuthority(RoleEnum.ADMIN.getSimpleRoleName(), RoleEnum.USER.getSimpleRoleName())
                // Categories
                .antMatchers(HttpMethod.GET, "/categories", "/categories/**").hasAnyAuthority(RoleEnum.ADMIN.getSimpleRoleName(), RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.PUT, "/categories/**").hasAnyAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/categories").hasAnyAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE, "/categories/**").hasAnyAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                // Comments
                .antMatchers(HttpMethod.GET,"/comments").hasAnyAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.GET,"/posts/*/comments").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.PUT,"/comments/**").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.POST,"/comments").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE,"/comments/**").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                // Contacts
                .antMatchers(HttpMethod.GET, "/contacts").hasAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/contacts").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                // Members
                .antMatchers(HttpMethod.GET, "/members").hasAnyAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.PUT, "/members/**").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/members").hasAuthority(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE, "/members/**").hasAnyAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                // News
                .antMatchers(HttpMethod.GET, "/news/**").hasAnyAuthority(RoleEnum.ADMIN.getSimpleRoleName(), RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.PUT, "/news/**").hasAnyAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/news").hasAnyAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE, "/news/**").hasAnyAuthority(RoleEnum.ADMIN.getSimpleRoleName())

                // Organization
                .antMatchers(HttpMethod.GET, "/organization/public").permitAll()//hasAuthority(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/organization").hasAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                // Slides
                .antMatchers(HttpMethod.GET, "/slides", "slides/**").hasAnyAuthority(RoleEnum.ADMIN.getSimpleRoleName(), RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.PUT, "/slides/**").hasAnyAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/slides").hasAnyAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE, "/slides/**").hasAnyAuthority(RoleEnum.ADMIN.getSimpleRoleName())
                // Testimonials

                .antMatchers(HttpMethod.POST, "/testimonials").hasAnyAuthority(RoleEnum.ADMIN.getSimpleRoleName(), RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.PUT, "/testimonials/**").hasAnyAuthority(RoleEnum.ADMIN.getSimpleRoleName(), RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE, "/testimonials/**").hasAnyAuthority(RoleEnum.ADMIN.getSimpleRoleName(), RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.GET, "/testimonials/**").hasAnyAuthority(RoleEnum.ADMIN.getSimpleRoleName(), RoleEnum.USER.getSimpleRoleName())
                //Swagger
                .antMatchers(publicEndpoint).permitAll()


                .anyRequest().authenticated()
                .and().exceptionHandling()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);


        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
}