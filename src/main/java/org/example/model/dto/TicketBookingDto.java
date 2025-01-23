package org.example.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.entity.Showtime;
import org.example.model.entity.User;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketBookingDto {

    private UUID id;

    private ShowtimeDto showtime;

    private Integer seatNumber;

}
