package org.example.controller.admin;

import lombok.RequiredArgsConstructor;
import org.example.model.dto.MovieDto;
import org.example.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "admin/movies")
@RequiredArgsConstructor
public class AdminMovieController {

    private final MovieService movieService;

    @PostMapping
    public MovieDto upsertMovie(@RequestBody MovieDto movieDto) {
        return movieService.upsertMovie(movieDto);
    }

    @DeleteMapping("{id}")
    public void deleteMovie(@PathVariable UUID id) {
        movieService.deleteMovie(id);
    }
    
}
