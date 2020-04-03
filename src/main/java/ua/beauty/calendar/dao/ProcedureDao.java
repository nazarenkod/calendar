package ua.beauty.calendar.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.beauty.calendar.domain.Procedure;

@Repository
public interface ProcedureDao extends JpaRepository<Procedure, Long> {
}
