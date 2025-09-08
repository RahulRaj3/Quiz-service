package com.rahul.quiz_service.model;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

}