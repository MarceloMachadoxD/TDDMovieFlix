package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.Repositories.MovieRepository;
import com.devsuperior.movieflix.entities.DTO.MovieDTO;
import com.devsuperior.movieflix.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public MovieDTO findMovieWithGenre(Long id){
       Movie obj = movieRepository.findMovieWithGenre(id);
        return new MovieDTO(obj, obj.getGenre());
    }


}
