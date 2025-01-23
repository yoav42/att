package org.example.mapper;

import org.example.model.dto.CreateShowtimeDto;
import org.example.model.dto.ShowtimeDto;
import org.example.model.entity.Movie;
import org.example.model.entity.Showtime;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, uses = {MovieMapper.class})
public interface ShowtimeMapper {

    ShowtimeDto toDto(Showtime Showtime);

    Showtime toEntity(ShowtimeDto ShowtimeDto);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "movie", source = "movie")
    })
    Showtime toEntity(CreateShowtimeDto createShowtimeDto, Movie movie);
}
