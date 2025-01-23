package org.example.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowtimeDto {

    private UUID id;

    private MovieDto movie;

    private String theater;

    private Integer maximumSeats;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

}
