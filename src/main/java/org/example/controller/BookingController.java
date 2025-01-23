package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.dto.BookingRequestDto;
import org.example.model.dto.MovieDto;
import org.example.model.dto.TicketBookingDto;
import org.example.model.entity.TicketBooking;
import org.example.model.entity.User;
import org.example.service.MovieService;
import org.example.service.TicketBookingService;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final TicketBookingService ticketBookingService;
    private final UserService userService;

    @PostMapping
    public void bookTicket(@RequestBody BookingRequestDto requestDto) {
        User user = userService.getAuthenticatedUser();
        ticketBookingService.bookTicket(requestDto, user);
    }

    @GetMapping
    public List<TicketBookingDto> getBookings() {
        return ticketBookingService.getBookings();
    }

}
