package ua.beauty.calendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.beauty.calendar.dao.EventDao;
import ua.beauty.calendar.dao.MasterDao;
import ua.beauty.calendar.domain.Event;
import ua.beauty.calendar.domain.Master;

import java.util.List;
import java.util.Optional;


//это адаптер
@Service
@Transactional
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDao eventDao;

    @Override
    public List<Event> findAll() {


        return eventDao.findAll();
    }

    @Override
    public Optional<Event> findById(Long id) {

        return eventDao.findById(id);
    }

    @Override
    public long addEvent(Event event) {
        long id = eventDao.save(event).getId();
        return id;
    }


}
