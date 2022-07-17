package com.alkemy.ong.auth.security;

import com.alkemy.ong.auth.filter.JwtRequestFilter;
import com.alkemy.ong.auth.service.UserDetailsCustomService;
import com.alkemy.ong.utils.RoleEnum;
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

                .antMatchers(HttpMethod.GET, "/auth/me").hasRole(RoleEnum.USER.getSimpleRoleName())
                // Users
                .antMatchers(HttpMethod.GET,"/users").hasRole(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.GET,"/users").hasRole(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.PATCH,"/users/**").permitAll()
                .antMatchers(HttpMethod.DELETE,"/users/**").hasRole(RoleEnum.USER.getSimpleRoleName())
                // Activity
                .antMatchers(HttpMethod.PUT, "/activities/**").hasRole(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/activities").hasRole(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.PUT, "/activities/**").hasRole(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/activities").hasRole(RoleEnum.USER.getSimpleRoleName())
                // Categories
                .antMatchers(HttpMethod.GET, "/categories", "/categories/**").hasRole(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.PUT, "/categories/**").hasRole(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/categories").hasRole(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE, "/categories/**").hasRole(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.GET, "/categories", "/categories/**").hasRole(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.PUT, "/categories/**").hasRole(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/categories").hasRole(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE, "/categories/**").hasRole(RoleEnum.USER.getSimpleRoleName())
                // Comments
                .antMatchers(HttpMethod.GET,"/comments").hasRole(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.GET,"/comments", "/posts/*/comments").hasRole(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.PUT,"/comments/**").hasRole(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.POST,"/comments").hasRole(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE,"/comments/**").hasRole(RoleEnum.USER.getSimpleRoleName())
                // Contacts
                .antMatchers(HttpMethod.GET, "/contacts").hasRole(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.GET, "/contacts").hasRole(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/contacts").hasRole(RoleEnum.USER.getSimpleRoleName())
                // Members
                .antMatchers(HttpMethod.GET, "/members").hasRole(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.PUT, "/members/**").hasRole(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/members").hasRole(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.GET, "/members").hasRole(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE, "/members/**").hasRole(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE, "/members/**").hasRole(RoleEnum.USER.getSimpleRoleName())
                // News
                .antMatchers(HttpMethod.GET, "/news/**").hasRole(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.GET, "/news/**").hasRole(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.PUT, "/news/**").hasRole(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.PUT, "/news/**").hasRole(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/news").hasRole(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/news").hasRole(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE, "/news/**").hasRole(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE, "/news/**").hasRole(RoleEnum.USER.getSimpleRoleName())
                // Organization
                .antMatchers(HttpMethod.GET, "/organization/public").hasRole(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/organization").hasRole(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/organization").hasRole(RoleEnum.USER.getSimpleRoleName())
                // Slides
                .antMatchers(HttpMethod.GET, "/slides", "slides/**").hasRole(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.GET, "/slides", "slides/**").hasRole(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.PUT, "/slides/**").hasRole(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.PUT, "/slides/**").hasRole(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/slides").hasRole(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/slides").hasRole(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE, "/slides/**").hasRole(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE, "/slides/**").hasRole(RoleEnum.USER.getSimpleRoleName())
                // Testimonials
                .antMatchers(HttpMethod.POST, "/testimonials").hasRole(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.POST, "/testimonials").hasRole(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.PUT, "/testimonials/**").hasRole(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.PUT, "/testimonials/**").hasRole(RoleEnum.USER.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE, "/testimonials/**").hasRole(RoleEnum.ADMIN.getSimpleRoleName())
                .antMatchers(HttpMethod.DELETE, "/testimonials/**").hasRole(RoleEnum.USER.getSimpleRoleName())

                .anyRequest().authenticated()
                .and().exceptionHandling()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
}