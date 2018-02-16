package com.sysco.ordermanager.service;

import com.sysco.ordermanager.domain.model.UserData;
import com.sysco.ordermanager.domain.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import static java.util.Collections.emptyList;
@Service
public class UserDetailsServiceImp implements UserDetailsService{
    private UserRepository userRepository;

    public UserDetailsServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserData userData = userRepository.findByName(name);
        if(userData == null){
            throw new UsernameNotFoundException(name);
        }
        return new User(userData.getId().toString(),userData.getPassword(),emptyList());
    }

}
