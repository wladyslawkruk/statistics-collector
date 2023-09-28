package com.example.testtask.controller;

import com.example.testtask.dto.EventDto;
import com.example.testtask.model.EventEntity;
import com.example.testtask.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/add")
    public ResponseEntity<EventEntity> addEvent(@RequestBody EventDto eventDto) {
        EventEntity savedEvent = eventService.addEvent(eventDto);
        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }


    @GetMapping("/get")
    public ResponseEntity<Page<EventEntity>> getEvents(
            @RequestParam(required = false) String classifier,
            Pageable pageable){
        Page<EventEntity> events = eventService.getEvents(classifier, pageable);
        return ResponseEntity.ok(events);
    }




}
