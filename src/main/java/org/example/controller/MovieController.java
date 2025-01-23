package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.dto.MovieDto;
import org.example.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public List<MovieDto> getMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("{id}")
    public MovieDto getMovieById(@PathVariable UUID id) {
        return movieService.getDtoById(id);
    }

}
