package com.airline.airline.security.services;

import com.airline.airline.entities.Cliente;
import com.airline.airline.repositories.ClienteRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private ClienteRepository clienteRepository;

    public UserDetailsServiceImpl(ClienteRepository userRepository) {
        this.clienteRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cliente user = clienteRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Username not found"));
        return UserDetailsImpl.build(user);
    }
}
