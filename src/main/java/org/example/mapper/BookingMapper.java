package org.example.mapper;

import org.example.model.dto.TicketBookingDto;
import org.example.model.entity.TicketBooking;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, uses = {ShowtimeMapper.class})
public interface BookingMapper {

    TicketBookingDto toDto(TicketBooking Showtime);

    TicketBooking toEntity(TicketBookingDto ShowtimeDto);

}
