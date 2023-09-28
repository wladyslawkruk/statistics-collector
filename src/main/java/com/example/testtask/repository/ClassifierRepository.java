package com.example.testtask.repository;

import com.example.testtask.dto.EventDto;
import com.example.testtask.model.ClassifierEntity;
import com.example.testtask.model.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClassifierRepository extends JpaRepository<ClassifierEntity, Long> {


    Optional<ClassifierEntity> getClassifierEntityByEventType(String type);

}
