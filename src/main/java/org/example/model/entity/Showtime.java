package org.example.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "showtime")
public class Showtime {

    private static final int DEFAULT_MAX_SEATS = 50;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(name = "id", length = 36, updatable = false, nullable = false)
    @JsonIgnore
    private UUID id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    private String theater;

    private Integer maximumSeats = DEFAULT_MAX_SEATS;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

}
