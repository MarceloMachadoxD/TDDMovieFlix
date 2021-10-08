package com.devsuperior.movieflix.Repositories;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository <Movie, Long> {

    @Query("SELECT obj, obj.genre FROM Movie obj WHERE obj.Id = :id")
    Optional<Movie> findMovieWithGenre(Long id);

    @Query("SELECT DISTINCT obj FROM Movie obj " +
            " JOIN obj.genre genre " +
            "WHERE obj.genre.Id = :genreId  " +
            "ORDER BY obj.title")
    Page<Movie> find(Long genreId, Pageable pageable);

}