package org.example.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {

    private UUID id;

    private String title;

    private String genre;

    private Integer duration;

    private Integer rating;

    private Integer releaseYear;

}
