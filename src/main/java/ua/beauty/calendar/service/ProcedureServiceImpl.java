package ua.beauty.calendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.beauty.calendar.dao.ProcedureDao;
import ua.beauty.calendar.domain.Procedure;

import java.util.List;
import java.util.Optional;


//это адаптер
@Service
@Transactional
public class ProcedureServiceImpl implements ProcedureService {

    @Autowired
    private ProcedureDao procedureDao;

    @Override
    public List<Procedure> findAll() {
        return procedureDao.findAll();
    }

    @Override
    public Optional<Procedure> findById(Long id) {
        return procedureDao.findById(id);
    }

    @Override
    public Procedure save(Procedure procedure) {
        return procedureDao.save(procedure);
    }


}
