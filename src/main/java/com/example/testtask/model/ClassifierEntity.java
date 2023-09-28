package com.example.testtask.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "classifier")
@NoArgsConstructor
public class ClassifierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classifier_id")
    private Long id;

    @Column(name = "event_type")
    private String eventType;

    public ClassifierEntity(String eventType) {
        this.eventType = eventType;
    }
}
