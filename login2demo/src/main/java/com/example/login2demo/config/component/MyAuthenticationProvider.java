package com.example.login2demo.config.component;

import com.example.login2demo.entities.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component("provider")
public class MyAuthenticationProvider implements AuthenticationProvider {
    /**
     *  to get user information
     */
    @Autowired
    private UserDetailsService userDetailService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // TODO Auto-generated method stub
        String userName = authentication.getName();
        String password = (String) authentication.getPrincipal();

        // if the user exists and the password is correct
        SysUser userInfo = (SysUser) userDetailService.loadUserByUsername(userName);
        if (userInfo == null) {
            throw new BadCredentialsException("the name of this user is not existed");
        }
        if (!userInfo.getPassword().equals(password)) {
            throw new BadCredentialsException("password not correct");
        }

        Collection<? extends GrantedAuthority> authorities = userInfo.getAuthorities();
        // Build a token that returns the user's login success
        return new UsernamePasswordAuthenticationToken(userInfo, password, authorities);
    }
    @Override
    public boolean supports(Class<?> authentication) {
        // TODO Auto-generated method stub
        return true;
    }
}
