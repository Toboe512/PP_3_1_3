package ru.toboe512.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailService extends UserDetailsService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
