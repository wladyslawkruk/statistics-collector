package com.example.testtask.dto;

import com.example.testtask.model.ClassifierEntity;
import com.example.testtask.model.EventEntity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class EventDto {

    private String classifier;

    private String text;

}
