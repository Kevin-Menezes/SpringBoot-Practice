package com.jwt.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        // Basic static login
        // We do this to put static username and password...when we don't want to use DB
        if(userName.equals("Kevin")){
            return new User("Kevin","Kevin777",new ArrayList<>());
        }
        else {
            throw new UsernameNotFoundException("User not there!");
        }
    }
}
