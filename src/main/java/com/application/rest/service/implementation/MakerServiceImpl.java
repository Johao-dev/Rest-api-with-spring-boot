package com.application.rest.service.implementation;

import com.application.rest.persistence.entity.Maker;
import com.application.rest.persistence.repository.MakerRepository;
import com.application.rest.service.MakerService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor // @NonNull / final fields are valid
@Service
public class MakerServiceImpl implements MakerService {

    // @NonNull
    // private MakerRepository makerRepository;

    private final MakerRepository makerRepository;

    @Override
    public List<Maker> findAll() {
        return (List<Maker>) makerRepository.findAll();
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return makerRepository.findById(id);
    }

    @Override
    public void save(Maker maker) {
        makerRepository.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        makerRepository.deleteById(id);
    }
}
