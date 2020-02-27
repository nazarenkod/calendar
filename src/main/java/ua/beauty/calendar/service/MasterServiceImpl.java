package ua.beauty.calendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.beauty.calendar.dao.MasterDao;
import ua.beauty.calendar.domain.Master;

import java.util.List;
import java.util.Optional;


//это адаптер
@Service
@Transactional
public class MasterServiceImpl implements MasterService {

    @Autowired
    private  MasterDao masterDao;

    @Override
    public List<Master> findAll() {
        return masterDao.findAll();
    }

    @Override
    public Optional<Master> findById(Long id) {
        return masterDao.findById(id);
    }

    @Override
    public Master save(Master master) {
        return masterDao.save(master);
    }


}
