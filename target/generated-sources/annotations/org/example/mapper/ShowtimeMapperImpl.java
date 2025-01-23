package org.example.mapper;

import javax.annotation.processing.Generated;
import org.example.model.dto.CreateShowtimeDto;
import org.example.model.dto.ShowtimeDto;
import org.example.model.entity.Movie;
import org.example.model.entity.Showtime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-17T23:43:36+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Homebrew)"
)
@Component
public class ShowtimeMapperImpl implements ShowtimeMapper {

    @Autowired
    private MovieMapper movieMapper;

    @Override
    public ShowtimeDto toDto(Showtime Showtime) {
        if ( Showtime == null ) {
            return null;
        }

        ShowtimeDto.ShowtimeDtoBuilder showtimeDto = ShowtimeDto.builder();

        showtimeDto.id( Showtime.getId() );
        showtimeDto.movie( movieMapper.toDto( Showtime.getMovie() ) );
        showtimeDto.theater( Showtime.getTheater() );
        showtimeDto.maximumSeats( Showtime.getMaximumSeats() );
        showtimeDto.startTime( Showtime.getStartTime() );
        showtimeDto.endTime( Showtime.getEndTime() );

        return showtimeDto.build();
    }

    @Override
    public Showtime toEntity(ShowtimeDto ShowtimeDto) {
        if ( ShowtimeDto == null ) {
            return null;
        }

        Showtime.ShowtimeBuilder showtime = Showtime.builder();

        showtime.id( ShowtimeDto.getId() );
        showtime.movie( movieMapper.toEntity( ShowtimeDto.getMovie() ) );
        showtime.theater( ShowtimeDto.getTheater() );
        showtime.maximumSeats( ShowtimeDto.getMaximumSeats() );
        showtime.startTime( ShowtimeDto.getStartTime() );
        showtime.endTime( ShowtimeDto.getEndTime() );

        return showtime.build();
    }

    @Override
    public Showtime toEntity(CreateShowtimeDto createShowtimeDto, Movie movie) {
        if ( createShowtimeDto == null && movie == null ) {
            return null;
        }

        Showtime.ShowtimeBuilder showtime = Showtime.builder();

        if ( createShowtimeDto != null ) {
            showtime.theater( createShowtimeDto.getTheater() );
            showtime.startTime( createShowtimeDto.getStartTime() );
            showtime.endTime( createShowtimeDto.getEndTime() );
        }
        showtime.movie( movie );

        return showtime.build();
    }
}
