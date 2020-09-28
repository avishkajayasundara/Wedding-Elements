package com.weddingplanner.server.services;

import com.weddingplanner.server.model.MyUserDetails;
import com.weddingplanner.server.model.SystemUser;
import com.weddingplanner.server.services.crudoperations.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    SystemUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<SystemUser> user = userRepository.findByEmail(email);
        user.orElseThrow(()-> new UsernameNotFoundException("Username Not Found"));
        return user.map(MyUserDetails::new).get();
    }
}
