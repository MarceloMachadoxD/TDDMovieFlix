package com.devsuperior.movieflix.Repositories;

import com.devsuperior.movieflix.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository <Movie, Long> {

    @Query("SELECT obj, obj.genre FROM Movie obj WHERE obj.Id = :id")
    Movie findMovieWithGenre(Long id);

}
