package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.mapper.MovieMapper;
import org.example.model.dto.MovieDto;
import org.example.model.entity.Movie;
import org.example.repository.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public List<MovieDto> getAllMovies() {
        return movieRepository.findAll()
                .stream()
                .map(movieMapper::toDto)
                .toList();
    }

    @Transactional
    public MovieDto upsertMovie(MovieDto movieDto) {
        Movie movie = movieMapper.toEntity(movieDto);
        movieRepository.save(movie);
        return movieMapper.toDto(movie);
    }

    @Transactional
    public void deleteMovie(UUID movieId) {
        movieRepository.deleteById(movieId);
    }


    public Movie getById(UUID id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
    }

    public MovieDto getDtoById(UUID id) {
        return movieMapper.toDto(getById(id));
    }
}
