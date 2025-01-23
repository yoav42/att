package org.example.controller.admin;

import lombok.RequiredArgsConstructor;
import org.example.model.dto.CreateShowtimeDto;
import org.example.model.dto.ShowtimeDto;
import org.example.model.dto.UpdateShowtimeDto;
import org.example.service.ShowtimeService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "admin/showtimes")
@RequiredArgsConstructor
public class AdminShowtimeController {

    private final ShowtimeService showtimeService;

    @PostMapping
    public ShowtimeDto createShowtime(@RequestBody CreateShowtimeDto showtimeDto) {
        return showtimeService.createShowtime(showtimeDto);
    }

    @PutMapping
    public ShowtimeDto updateShowtime(@RequestBody UpdateShowtimeDto showtimeDto) {
        return showtimeService.updateShowtime(showtimeDto);
    }

    @DeleteMapping("{id}")
    public void deleteShowtime(@PathVariable UUID id) {
        showtimeService.deleteShowtime(id);
    }
    
}
