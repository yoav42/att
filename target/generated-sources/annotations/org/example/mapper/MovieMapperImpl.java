package org.example.mapper;

import javax.annotation.processing.Generated;
import org.example.model.dto.MovieDto;
import org.example.model.entity.Movie;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-17T23:43:36+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Homebrew)"
)
@Component
public class MovieMapperImpl implements MovieMapper {

    @Override
    public MovieDto toDto(Movie movie) {
        if ( movie == null ) {
            return null;
        }

        MovieDto.MovieDtoBuilder movieDto = MovieDto.builder();

        movieDto.id( movie.getId() );
        movieDto.title( movie.getTitle() );
        movieDto.genre( movie.getGenre() );
        movieDto.duration( movie.getDuration() );
        movieDto.rating( movie.getRating() );
        movieDto.releaseYear( movie.getReleaseYear() );

        return movieDto.build();
    }

    @Override
    public Movie toEntity(MovieDto movieDto) {
        if ( movieDto == null ) {
            return null;
        }

        Movie.MovieBuilder movie = Movie.builder();

        movie.id( movieDto.getId() );
        movie.title( movieDto.getTitle() );
        movie.genre( movieDto.getGenre() );
        movie.duration( movieDto.getDuration() );
        movie.rating( movieDto.getRating() );
        movie.releaseYear( movieDto.getReleaseYear() );

        return movie.build();
    }
}
