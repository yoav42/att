package org.example.repository;

import org.example.model.entity.TicketBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketBookingRepository extends JpaRepository<TicketBooking, UUID> {

    boolean existsByShowtimeIdAndSeatNumber(UUID showtimeId, Integer seatNumber);

}
