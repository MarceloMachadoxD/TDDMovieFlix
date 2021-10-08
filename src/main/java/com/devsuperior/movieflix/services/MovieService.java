package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.Repositories.MovieRepository;
import com.devsuperior.movieflix.entities.DTO.MovieDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public MovieDTO findMovieWithGenre(Long id) {
            Optional<Movie> obj = movieRepository.findMovieWithGenre(id);
            Movie movie = obj.orElseThrow(() -> new ResourceNotFoundException("Movie not found with id " + id));
            return new MovieDTO(movie, movie.getGenre());
    }

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAllPaged(Pageable pageable) {
            Page<Movie> list = movieRepository.find(pageable);
            return list.map(x -> new MovieDTO(x, x.getGenre()) );
        }
    }
