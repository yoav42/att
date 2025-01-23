package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.dto.ShowtimeDto;
import org.example.service.ShowtimeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/showtimes")
@RequiredArgsConstructor
public class ShowtimeController {

    private final ShowtimeService showtimeService;

    @GetMapping
    public List<ShowtimeDto> getShowtimes() {
        return showtimeService.getAllShowtimes();
    }

    @GetMapping("{id}")
    public ShowtimeDto getShowtimeById(@PathVariable UUID id) {
        return showtimeService.getDtoById(id);
    }

}
