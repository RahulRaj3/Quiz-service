package com.rahul.quiz_service.config;

import com.rahul.quiz_service.model.Question;
import com.rahul.quiz_service.model.QuizResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(name = "question-service", url = "http://localhost:8080")
public interface QuizClient {
    @GetMapping("question/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category,
                                                             @RequestParam Integer numQ);


    @PostMapping("question/getQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(@RequestBody List<Integer> questionIds) ;

    @PostMapping("question/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<QuizResponse> quizResponse);

}
