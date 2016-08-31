package com.mdmytriaha.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;

@Configuration
@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilter(requestHeaderAuthenticationFilter()).antMatcher("/api/**").authorizeRequests().anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(preAuthenticatedAuthenticationProvider());
    }

    @Bean
    public RequestHeaderAuthenticationFilter requestHeaderAuthenticationFilter() throws Exception {
        RequestHeaderAuthenticationFilter requestHeaderAuthenticationFilter = new RequestHeaderAuthenticationFilter();
        requestHeaderAuthenticationFilter.setPrincipalRequestHeader("token");
        requestHeaderAuthenticationFilter.setAuthenticationManager(authenticationManager());
        requestHeaderAuthenticationFilter.setExceptionIfHeaderMissing(false);
        return requestHeaderAuthenticationFilter;
    }

    @Bean
    public PreAuthenticatedAuthenticationProvider preAuthenticatedAuthenticationProvider() {
        PreAuthenticatedAuthenticationProvider preAuthenticatedAuthenticationProvider = new PreAuthenticatedAuthenticationProvider();
        preAuthenticatedAuthenticationProvider.setPreAuthenticatedUserDetailsService(new UserDetailsByNameServiceWrapper<PreAuthenticatedAuthenticationToken>(userDetailsService()));
        return preAuthenticatedAuthenticationProvider;
    }
}
