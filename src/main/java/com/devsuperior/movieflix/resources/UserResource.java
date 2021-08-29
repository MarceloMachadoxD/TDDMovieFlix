package com.devsuperior.movieflix.resources;

import com.devsuperior.movieflix.entities.DTO.UserDTO;
import com.devsuperior.movieflix.services.AuthService;
import com.devsuperior.movieflix.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {


    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findByID(@PathVariable Long id){
        UserDTO userDTO = userService.findById(id);
        return ResponseEntity.ok().body(userDTO);
    }


    @GetMapping("/profile")
    public ResponseEntity<UserDTO> authenticatedUserProfile(){
        UserDTO userDTO = userService.authenticatedUserProfile();
        return ResponseEntity.ok().body(userDTO);
    }
}
