package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.Repositories.MovieRepository;
import com.devsuperior.movieflix.Repositories.ReviewRepository;
import com.devsuperior.movieflix.Repositories.UserRepository;
import com.devsuperior.movieflix.entities.DTO.MovieDTO;
import com.devsuperior.movieflix.entities.DTO.ReviewDTO;
import com.devsuperior.movieflix.entities.DTO.ReviewDTOWithUserAndMovie;
import com.devsuperior.movieflix.entities.DTO.UserDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthService authService;

    public ReviewDTOWithUserAndMovie insert(ReviewDTO dto) {
        Review review = new Review();

        review.setText(dto.getText());
        Optional<Movie> optionalMovie = movieRepository.findMovieWithGenre(dto.getMovieId());
        Movie movie = optionalMovie.get();
        review.setMovie(movie);

        User user = userRepository.findByEmail(authService.autenticated().getEmail());
        UserDTO userDTO = new UserDTO(user);
        review.setUser(user);

        reviewRepository.save(review);

        ReviewDTOWithUserAndMovie reviewDTOWithUserAndMovie = new ReviewDTOWithUserAndMovie(review);

        return reviewDTOWithUserAndMovie;

    }
}
