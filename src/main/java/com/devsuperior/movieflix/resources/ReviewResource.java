package com.devsuperior.movieflix.resources;

import com.devsuperior.movieflix.entities.DTO.ReviewDTO;
import com.devsuperior.movieflix.entities.DTO.ReviewDTOWithUserAndMovie;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewResource {

    @Autowired
    ReviewService reviewService;


    @PostMapping
    public ResponseEntity<ReviewDTOWithUserAndMovie> insertProduct(@Valid @RequestBody ReviewDTO dto) {
        ReviewDTOWithUserAndMovie reviewDTOWithUserAndMovie = reviewService.insert(dto);


        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(reviewDTOWithUserAndMovie);

    }


}
