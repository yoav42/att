package org.example.mapper;

import org.example.model.dto.MovieDto;
import org.example.model.entity.Movie;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface MovieMapper {

    MovieDto toDto(Movie movie);

    Movie toEntity(MovieDto movieDto);
}
