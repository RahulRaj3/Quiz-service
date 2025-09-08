package com.rahul.quiz_service.controller;

import com.rahul.quiz_service.model.Question;
import com.rahul.quiz_service.model.Quiz;
import com.rahul.quiz_service.model.QuizResponse;
import com.rahul.quiz_service.model.Quizdto;
import com.rahul.quiz_service.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/create")
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quizdto quizdto) {

       Quiz quiz = quizService.createQuiz(quizdto.getCategory(),quizdto.getNumQ(), quizdto.getQuizTitle());
        return ResponseEntity.ok(quiz);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<Question>> getQuizQuestions(@PathVariable Integer id) {
         List<Question> question = quizService.getQuizQuestions(id);
        return ResponseEntity.ok(question);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<QuizResponse> quizResponse) {
        return ResponseEntity.ok(quizService.getScore(id, quizResponse));
    }
}
