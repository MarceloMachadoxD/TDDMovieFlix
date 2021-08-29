package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.Repositories.UserRepository;
import com.devsuperior.movieflix.entities.DTO.UserDTO;
import com.devsuperior.movieflix.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
/*
        authService.validateSelfOrAdmin(id);
*/
            Optional<User> obj = userRepository.findById(id);
            User user = obj.orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
            return new UserDTO(user);

    }



}
