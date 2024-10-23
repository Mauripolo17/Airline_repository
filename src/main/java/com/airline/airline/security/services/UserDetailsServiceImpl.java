package com.airline.airline.security.services;

import com.airline.airline.entities.Usuario;
import com.airline.airline.repositories.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    private UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Username not found"));
        return UserDetailsImpl.build(user);
    }
}
