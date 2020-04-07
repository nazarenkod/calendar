package ua.beauty.calendar.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.beauty.calendar.domain.Event;

import java.util.List;

@Repository
public interface EventDao extends JpaRepository<Event,Long> {


    @Query("SELECT e FROM Event e WHERE e.master.name = :name and e.date = :date")
    List<Event> findEventsByMasterAndDate(
            @Param("name") String name,
            @Param("date") String date
    );
}
