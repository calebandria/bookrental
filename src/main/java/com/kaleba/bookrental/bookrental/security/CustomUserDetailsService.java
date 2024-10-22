package com.kaleba.bookrental.bookrental.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;


import com.kaleba.bookrental.bookrental.model.Adherent;
import com.kaleba.bookrental.bookrental.repository.AdherentRepository;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    private AdherentRepository adherentRepository;
    public CustomUserDetailsService(AdherentRepository adherentRepository) {
        this.adherentRepository = adherentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Adherent user = adherentRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Username not found"));
        
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(getAuthorities(user))
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();

    }
    
    private List<GrantedAuthority> getAuthorities(Adherent adherentUser) {
        return adherentUser.getRoles().stream()
            .map(role -> new SimpleGrantedAuthority(role.getName()))
            .collect(Collectors.toList());
    }
    

}
