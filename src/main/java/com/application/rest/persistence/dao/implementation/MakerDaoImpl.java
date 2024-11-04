package com.application.rest.persistence.dao.implementation;

import com.application.rest.persistence.dao.MakerDAO;
import com.application.rest.persistence.entity.Maker;
import com.application.rest.persistence.repository.MakerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MakerDaoImpl implements MakerDAO {

    @Autowired
    private MakerRepository makerRepo;
    
    @Override
    public List<Maker> findAll() {
        return (List<Maker>) makerRepo.findAll();
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return makerRepo.findById(id);
    }

    @Override
    public void save(Maker maker) {
        makerRepo.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        makerRepo.deleteById(id);
    }
}
