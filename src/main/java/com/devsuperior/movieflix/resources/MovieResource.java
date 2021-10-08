package com.devsuperior.movieflix.resources;

import com.devsuperior.movieflix.entities.DTO.MovieDTO;
import com.devsuperior.movieflix.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {

    @Autowired
    private MovieService movieService;


    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> findById(@PathVariable Long id){
        MovieDTO movieDTO = movieService.findMovieWithGenre(id);
        return ResponseEntity.ok().body(movieDTO);
    }

    @GetMapping
    public ResponseEntity<Page<MovieDTO>> findAll(
            @RequestParam(value = "genreId", defaultValue = "0") Long genreId,
            Pageable pageable){
        Page<MovieDTO> list = movieService.findAllPaged(genreId, pageable);
        list.getSort();
        return ResponseEntity.ok().body(list);
    }
}
