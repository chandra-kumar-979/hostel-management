package com.hms.HMSApplication.config;

import com.hms.HMSApplication.entity.BedUser;
import com.hms.HMSApplication.repo.BedUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private  BedUserRepository bedUserRepository; // Inject your UserRepository



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BedUser bedUser = bedUserRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        UserDetails user = User.builder()
                .username(bedUser.getUserName())
                .password(bedUser.getPassword())
                .roles(bedUser.getRoles().getRole())
                .build();

        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(bedUser.getRoles().getRole());
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(simpleGrantedAuthority);

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
