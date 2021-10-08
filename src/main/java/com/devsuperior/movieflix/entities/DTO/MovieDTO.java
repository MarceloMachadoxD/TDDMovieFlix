package com.devsuperior.movieflix.entities.DTO;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

public class MovieDTO {

    private Long id;
    private String title;
    private String subTitle;
    private Integer year;
    private String imgUrl;
    private String synopsis;

    private GenreDTO genre;

    public MovieDTO() {
    }

    public MovieDTO(Long id, String title, String subTitle, Integer year, String imgUrl, String synopsis, GenreDTO genre) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.year = year;
        this.imgUrl = imgUrl;
        this.synopsis = synopsis;
        this.genre = genre;
    }

    public MovieDTO(Movie entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.subTitle = entity.getSubTitle();
        this.year = entity.getYear();
        this.imgUrl = entity.getImgUrl();
        this.synopsis = entity.getSynopsis();
        this.genre = new GenreDTO(entity.getGenre());

    }

    public MovieDTO(Movie entity, Genre genre) {
        this(entity);
        this.genre = new GenreDTO(genre);
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public GenreDTO getGenre() {
        return genre;
    }

    public void setGenre(GenreDTO genre) {
        this.genre = genre;
    }
}
