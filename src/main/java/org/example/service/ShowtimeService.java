package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.mapper.ShowtimeMapper;
import org.example.model.dto.CreateShowtimeDto;
import org.example.model.dto.ShowtimeDto;
import org.example.model.dto.UpdateShowtimeDto;
import org.example.model.entity.Movie;
import org.example.model.entity.Showtime;
import org.example.repository.ShowtimeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShowtimeService {

    private final ShowtimeRepository showtimeRepository;
    private final ShowtimeMapper showtimeMapper;
    private final MovieService movieService;

    public List<ShowtimeDto> getAllShowtimes() {
        return showtimeRepository.findAll()
                .stream()
                .map(showtimeMapper::toDto)
                .toList();
    }

    @Transactional
    public ShowtimeDto createShowtime(CreateShowtimeDto createShowtimeDto) {
        Movie movie = movieService.getById(createShowtimeDto.getMovieId());
        LocalDateTime startTime = createShowtimeDto.getStartTime();
        LocalDateTime endTime = createShowtimeDto.getEndTime();

        List<Showtime> overlappingShowtimes = showtimeRepository.findOverlappingShowtimes(createShowtimeDto.getTheater(), startTime, endTime);
        if (!overlappingShowtimes.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Showtime overlaps with an existing showtime");
        }

        Showtime showtime = showtimeMapper.toEntity(createShowtimeDto, movie);
        showtimeRepository.save(showtime);
        return showtimeMapper.toDto(showtime);
    }

    @Transactional
    public ShowtimeDto updateShowtime(UpdateShowtimeDto showtimeDto) {
        Showtime showtime = getById(showtimeDto.getId());
        showtime.setTheater(showtimeDto.getTheater());
        showtime.setStartTime(showtimeDto.getStartTime());
        showtime.setEndTime(showtimeDto.getEndTime());
        return showtimeMapper.toDto(showtimeRepository.save(showtime));
    }

    @Transactional
    public void deleteShowtime(UUID ShowtimeId) {
        showtimeRepository.deleteById(ShowtimeId);
    }


    public Showtime getById(UUID id) {
        return showtimeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Showtime not found"));
    }

    public ShowtimeDto getDtoById(UUID id) {
        return showtimeMapper.toDto(getById(id));
    }
}
