package com.example.testtask.service;

import com.example.testtask.dto.EventDto;
import com.example.testtask.model.ClassifierEntity;
import com.example.testtask.model.EventEntity;
import com.example.testtask.repository.ClassifierRepository;
import com.example.testtask.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final ClassifierRepository classifierRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, ClassifierRepository classifierRepository) {
        this.eventRepository = eventRepository;
        this.classifierRepository = classifierRepository;
    }

    @Override
    public EventEntity addEvent(EventDto eventDto) {
        Optional<ClassifierEntity> classifierEntityOptional = classifierRepository
                .getClassifierEntityByEventType(eventDto.getClassifier());
        System.out.println(classifierEntityOptional.isPresent());
        if(classifierEntityOptional.isPresent()){
            System.out.println("not null");
            ClassifierEntity classifier = classifierEntityOptional.get();
            EventEntity eventEntity = new EventEntity(
                    classifier,
                    eventDto.getText(),
                    LocalDateTime.now()
            );
            return eventRepository.save(eventEntity);
        }
        else{
            ClassifierEntity newEntity = new ClassifierEntity(eventDto.getClassifier());
            System.out.println(newEntity==null);

            classifierRepository.save(newEntity);
            EventEntity eventEntity = new EventEntity(
                    newEntity,
                    eventDto.getText(),
                    LocalDateTime.now()
            );
            return eventRepository.save(eventEntity);
        }

    }

    @Override
    public Page<EventEntity> getEvents(String classifier, Pageable pageable) {
        if(classifier==null){
            return eventRepository.findAll(pageable);
        }
        return eventRepository.findEventEntitiesByClassifierEventType(classifier, pageable);
    }
}
