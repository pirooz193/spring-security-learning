package com.mycompany.onlineexam.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import java.util.Set;

public class QuestionDTO {
    @JsonIgnore
    private Long id;
    @JsonProperty("question_title")
    private String questionTitle;
    @JsonProperty(value = "question_score")
    @NotNull
    private Float score;
    @JsonProperty("correct_answer")
    private AnswerDTO correctAnswerDTO;
    @JsonProperty("answers")
    private Set<AnswerDTO> answerDTOS;


    @Override
    public String toString() {
        return "QuestionDTO{" +
                "id=" + id +
                ", questionTitle='" + questionTitle + '\'' +
                ", score=" + score +
                ", correctAnswerDTO=" + correctAnswerDTO +
                ", answerDTOS=" + answerDTOS +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public AnswerDTO getCorrectAnswerDTO() {
        return correctAnswerDTO;
    }

    public void setCorrectAnswerDTO(AnswerDTO correctAnswerDTO) {
        this.correctAnswerDTO = correctAnswerDTO;
    }

    public Set<AnswerDTO> getAnswerDTOS() {
        return answerDTOS;
    }

    public void setAnswerDTOS(Set<AnswerDTO> answerDTOS) {
        this.answerDTOS = answerDTOS;
    }

    public Float getScore() {
        return score;
    }
    public void setScore(Float score) {
        this.score = score;
    }
}
