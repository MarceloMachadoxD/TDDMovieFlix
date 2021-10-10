package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.Repositories.UserRepository;
import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {

        authService.validateSelfOrAdmin(id);

            Optional<User> obj = userRepository.findById(id);
            User user = obj.orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
            return new UserDTO(user);

    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(s);
        if (user == null) {
            logger.error("user not found " + s);
            throw new UsernameNotFoundException("Email não encontrado");
        }
        logger.info("User found " + s);
        return user;
    }

    @Transactional(readOnly = true)
    public UserDTO authenticatedUserProfile() {

        User user = authService.autenticated();

        return new UserDTO(user);

    }




}
