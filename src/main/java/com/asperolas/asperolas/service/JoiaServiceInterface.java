package com.asperolas.asperolas.service;

import com.asperolas.asperolas.dto.JoiaDto;
import com.asperolas.asperolas.model.JoiaEntity;

import java.util.List;
import java.util.Optional;

public interface JoiaServiceInterface {
    JoiaEntity save(JoiaDto joiaDto);
    List<JoiaEntity> findAll();
    JoiaEntity update(JoiaDto joiaDto, Long id);
    void delete(Long id);
    Optional<JoiaEntity> findById(Long id);
}
