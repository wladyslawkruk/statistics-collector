package com.example.testtask.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "event")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "classifier_id",nullable=false)
    private ClassifierEntity classifier;

    @Column(name = "event_text",columnDefinition = "text")
    private String event;

    @Column(name = "timestamp",columnDefinition = "timestamp")
    private LocalDateTime timestamp;

    public EventEntity(ClassifierEntity classifier, String event, LocalDateTime timestamp) {
        this.classifier = classifier;
        this.event = event;
        this.timestamp = timestamp;
    }
}
