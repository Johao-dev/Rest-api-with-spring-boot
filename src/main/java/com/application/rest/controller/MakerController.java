package com.application.rest.controller;

import com.application.rest.controller.dto.MakerDTO;
import com.application.rest.persistence.entity.Maker;
import com.application.rest.service.MakerService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/makers")
public class MakerController {

    @Autowired
    private MakerService makerService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Maker> makerOptional = makerService.findById(id);

        if (makerOptional.isPresent()) {
            Maker maker = makerOptional.get();

            MakerDTO makerDTO = MakerDTO.builder()
                    .id(maker.getId())
                    .name(maker.getName())
                    .products(maker.getProducts())
                    .build();

            return ResponseEntity.ok(makerDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<MakerDTO> makersDTO = makerService.findAll()
                .stream()
                .map(maker -> MakerDTO.builder()
                        .id(maker.getId())
                        .name(maker.getName())
                        .products(maker.getProducts())
                        .build())
                .toList();

        return ResponseEntity.ok(makersDTO);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody MakerDTO makerDTO)
            throws URISyntaxException {

        if (makerDTO.getName().isBlank())
            return ResponseEntity.badRequest().build();

        makerService.save(Maker.builder()
                .name(makerDTO.getName())
                .build());

        return ResponseEntity.created(new URI("/api/makers")).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMaker(
            @PathVariable Long id,
            @RequestBody MakerDTO makerDTO) {

        Optional<Maker> makerOptional = makerService.findById(id);

        if (makerOptional.isPresent()) {
            Maker maker = makerOptional.get();
            maker.setName(makerDTO.getName());
            makerService.save(maker);
            return ResponseEntity.ok("Registro actualizado");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {

        if (id != null) {
            makerService.deleteById(id);
            return ResponseEntity.ok("registro eliminado");
        }

        return ResponseEntity.badRequest().build();
    }
}
