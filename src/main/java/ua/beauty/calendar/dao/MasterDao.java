package ua.beauty.calendar.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.beauty.calendar.domain.Master;

@Repository
public interface MasterDao extends JpaRepository<Master,Long> {


}
