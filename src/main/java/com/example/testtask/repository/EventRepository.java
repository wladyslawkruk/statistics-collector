package com.example.testtask.repository;

import com.example.testtask.model.ClassifierEntity;
import com.example.testtask.model.EventEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {

    Page<EventEntity> findAll(Pageable pageable);
    Page<EventEntity> findEventEntitiesByClassifierEventType(String classifier, Pageable pageable);

}
