package com.rahul.quiz_service.service;

import com.rahul.quiz_service.config.QuizClient;
import com.rahul.quiz_service.dao.QuizRepository;
import com.rahul.quiz_service.exceptions.QuestionNotFoundException;
import com.rahul.quiz_service.model.Question;
import com.rahul.quiz_service.model.Quiz;
import com.rahul.quiz_service.model.QuizResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuizClient quizClient;

    @Transactional
    public Quiz createQuiz(String category, Integer numQ, String quizTitle) {
        Quiz quiz = new Quiz();
        try{
            List<Integer> quizIds = quizClient.getQuestionsForQuiz(category,numQ).getBody();
            quiz.setQuizTitle(quizTitle);
            quiz.setQuestionIds(quizIds);
            return quizRepository.save(quiz);
        }catch (Exception e){
            throw new QuestionNotFoundException(e.getMessage());
        }
    }

    public List<Question> getQuizQuestions(Integer id) {
        try{
            Quiz quiz = quizRepository.findById(id).get();
            return quizClient.getAllQuestions(quiz.getQuestionIds()).getBody();
        }catch (Exception e){
            throw new QuestionNotFoundException(e.getMessage());
        }
    }

    public Integer getScore(Integer id, List<QuizResponse> quizResponse) {
        Integer score = 0;
        try{
            score = quizClient.getScore(quizResponse).getBody();
        }catch (Exception e){
            throw new QuestionNotFoundException(e.getMessage());
        }
        return score;
    }
}
