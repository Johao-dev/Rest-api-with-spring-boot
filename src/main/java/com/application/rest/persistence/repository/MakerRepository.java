package com.application.rest.persistence.repository;

import com.application.rest.persistence.entity.Maker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakerRepository extends CrudRepository<Maker, Long> {

}
