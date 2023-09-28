package com.example.testtask.service;

import com.example.testtask.dto.EventDto;
import com.example.testtask.model.EventEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface EventService {

    EventEntity addEvent(EventDto eventDto);

    Page<EventEntity> getEvents(String classifier, Pageable pageable);



}
