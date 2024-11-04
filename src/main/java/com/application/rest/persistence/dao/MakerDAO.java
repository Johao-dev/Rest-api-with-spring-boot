package com.application.rest.persistence.dao;

import com.application.rest.persistence.entity.Maker;
import java.util.List;
import java.util.Optional;

public interface MakerDAO {
    
    List<Maker> findAll();
    
    Optional<Maker> findById(Long id);
    
    void save(Maker maker);
    
    void deleteById(Long id);
}
