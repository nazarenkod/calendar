package ua.beauty.calendar.service;





//это порт


import ua.beauty.calendar.domain.Master;

import java.util.List;
import java.util.Optional;

public interface MasterService {

    List<Master> findAll();
    Optional<Master> findById(Long id);

}
