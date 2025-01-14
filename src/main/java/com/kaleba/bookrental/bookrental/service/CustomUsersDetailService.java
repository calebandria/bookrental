package com.kaleba.bookrental.bookrental.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kaleba.bookrental.bookrental.model.Users;
import com.kaleba.bookrental.bookrental.repository.UsersRepository;

@Service
public class CustomUsersDetailService implements UserDetailsService {
    
    @Autowired
    private UsersRepository usersRepository ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user = usersRepository.findByUsername(username);
        if (user.isPresent()){
            var userObj = user.get();

            return User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .roles(getRoles(userObj))
                    .build();
        }
        else {
            throw new UsernameNotFoundException(username);
        }
    }

    private String[] getRoles(Users user){
        if(user.getAdherent().getRole().name() != null){
            return new String[]{"USER"};
        }
        return new String[]{user.getAdherent().getRole().name()};
    }
}
