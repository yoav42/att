package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.Synchronized;
import org.example.mapper.BookingMapper;
import org.example.model.dto.BookingRequestDto;
import org.example.model.dto.TicketBookingDto;
import org.example.model.entity.Showtime;
import org.example.model.entity.TicketBooking;
import org.example.model.entity.User;
import org.example.repository.TicketBookingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketBookingService {

    private final ShowtimeService showtimeService;
    private final TicketBookingRepository ticketBookingRepository;
    private final BookingMapper bookingMapper;

    @Transactional
    @Synchronized
    public void bookTicket(BookingRequestDto request, User user) {
        Showtime showtime = showtimeService.getById(request.getShowtimeId());
        validateBookingRequest(request, showtime);

        ticketBookingRepository.save(TicketBooking.builder()
                .showtime(showtime)
                .seatNumber(request.getSeatNumber())
                .user(user)
                .build());
    }

    public List<TicketBookingDto> getBookings() {
        return ticketBookingRepository.findAll().stream()
                .map(bookingMapper::toDto)
                .toList();
    }

    private void validateBookingRequest(BookingRequestDto request, Showtime showtime) {
        if (ticketBookingRepository.existsByShowtimeIdAndSeatNumber(request.getShowtimeId(), request.getSeatNumber())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Seat is already taken");
        }

        if(request.getSeatNumber() > showtime.getMaximumSeats() - 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Seat number is invalid");
        }
    }

}
