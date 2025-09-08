package com.rahul.quiz_service.model;

import lombok.Data;

@Data
public class Quizdto {
    private String quizTitle;
    private Integer numQ;
    private String category;
}
