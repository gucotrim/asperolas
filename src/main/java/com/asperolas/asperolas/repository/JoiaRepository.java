package com.asperolas.asperolas.repository;

import com.asperolas.asperolas.model.JoiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JoiaRepository extends JpaRepository<JoiaEntity, Long> {
}
