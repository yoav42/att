package org.example.repository;


import org.example.model.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface ShowtimeRepository extends JpaRepository<Showtime, UUID> {

    @Query("SELECT s FROM Showtime s WHERE s.theater = :theater AND " +
            "((:startTime BETWEEN s.startTime AND s.endTime) OR " +
            "(:endTime BETWEEN s.startTime AND s.endTime) OR " +
            "(s.startTime BETWEEN :startTime AND :endTime) OR " +
            "(s.endTime BETWEEN :startTime AND :endTime))")
    List<Showtime> findOverlappingShowtimes(@Param("theater") String theater,
                                            @Param("startTime") LocalDateTime startTime,
                                            @Param("endTime") LocalDateTime endTime);

}
