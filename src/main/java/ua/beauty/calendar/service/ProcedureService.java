package ua.beauty.calendar.service;


//это порт


import ua.beauty.calendar.domain.Procedure;

import java.util.List;
import java.util.Optional;

public interface ProcedureService {

    List<Procedure> findAll();

    Optional<Procedure> findById(Long id);

    Procedure save(Procedure procedure);

}
