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
public class UpdateShowtimeDto {

    private UUID id;

    private String theater;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

}
