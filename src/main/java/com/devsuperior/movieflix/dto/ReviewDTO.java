package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Review;

import javax.validation.constraints.NotBlank;

public class ReviewDTO {

    private Long id;

    @NotBlank
    private String text;

    private Long movieId;
    private Long userId;


    public ReviewDTO() {
    }

    public ReviewDTO(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public ReviewDTO(Review entity) {

        this.id = entity.getId();
        this.text = entity.getText();
        this.movieId = entity.getMovie().getId();
        this.userId = entity.getUser().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
