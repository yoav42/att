package org.example.mapper;

import javax.annotation.processing.Generated;
import org.example.model.dto.TicketBookingDto;
import org.example.model.entity.TicketBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-17T23:43:36+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Homebrew)"
)
@Component
public class BookingMapperImpl implements BookingMapper {

    @Autowired
    private ShowtimeMapper showtimeMapper;

    @Override
    public TicketBookingDto toDto(TicketBooking Showtime) {
        if ( Showtime == null ) {
            return null;
        }

        TicketBookingDto.TicketBookingDtoBuilder ticketBookingDto = TicketBookingDto.builder();

        ticketBookingDto.id( Showtime.getId() );
        ticketBookingDto.showtime( showtimeMapper.toDto( Showtime.getShowtime() ) );
        ticketBookingDto.seatNumber( Showtime.getSeatNumber() );

        return ticketBookingDto.build();
    }

    @Override
    public TicketBooking toEntity(TicketBookingDto ShowtimeDto) {
        if ( ShowtimeDto == null ) {
            return null;
        }

        TicketBooking.TicketBookingBuilder ticketBooking = TicketBooking.builder();

        return ticketBooking.build();
    }
}
