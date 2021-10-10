package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.Repositories.GenreRepository;
import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.entities.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private AuthService authService;


    @Transactional(readOnly = true)
    public List<GenreDTO> findAll() {
       List<Genre> list = genreRepository.findAll();
       List<GenreDTO> listDTO =  list.stream().map(x -> new GenreDTO(x)).collect(Collectors.toList());
       return listDTO;
    }



}
