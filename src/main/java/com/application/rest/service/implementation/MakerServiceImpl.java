package com.application.rest.service.implementation;

import com.application.rest.persistence.dao.MakerDAO;
import com.application.rest.persistence.entity.Maker;
import com.application.rest.service.MakerService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MakerServiceImpl implements MakerService {

    @Autowired
    private MakerDAO makerDao;
    
    @Override
    public List<Maker> findAll() {
        return makerDao.findAll();
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return makerDao.findById(id);
    }

    @Override
    public void save(Maker maker) {
        makerDao.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        makerDao.deleteById(id);
    }
}
