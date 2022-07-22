package com.asperolas.asperolas.service;

import com.asperolas.asperolas.dto.JoiaDto;
import com.asperolas.asperolas.model.JoiaEntity;
import com.asperolas.asperolas.repository.JoiaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JoiaService implements JoiaServiceInterface{

    private final JoiaRepository repository;

    public JoiaService(JoiaRepository repository) {
        this.repository = repository;
    }

    @Override
    public JoiaEntity save(JoiaDto joiaDto) {
        return repository.save(JoiaEntity.builder()
                .material(joiaDto.getMaterial())
                .peso(joiaDto.getPeso())
                .quilates(joiaDto.getQuilates())
                .build());
    }

    @Override
    public List<JoiaEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public JoiaEntity update(JoiaDto joiaDto, Long id) {
        JoiaEntity joiaEntity = repository.getReferenceById(id);
        joiaEntity.setMaterial(joiaDto.getMaterial());
        joiaEntity.setPeso(joiaEntity.getPeso());
        joiaEntity.setQuilates(joiaEntity.getQuilates());

        return repository.save(joiaEntity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<JoiaEntity> findById(Long id) {
        return repository.findById(id);
    }
}
