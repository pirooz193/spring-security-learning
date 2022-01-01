package com.mycompany.onlineexam.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import java.time.LocalDateTime;
import java.util.Set;

public class ExamDTO {
    @JsonIgnore
    private Long id;
    @JsonProperty("exam_title")
    @NotNull
    private String examTitle;
    @JsonProperty(value = "exam_score")
    private Float examScore;
    @JsonProperty("start_date_time")
    private LocalDateTime startDateTime;
    @JsonProperty("end_date_time")
    private LocalDateTime endDateTime;
    @JsonProperty("questions")
    private Set<QuestionDTO> questionDTOS;

    @Override
    public String toString() {
        return "ExamDTO{" +
                "id=" + id +
                ", examTitle='" + examTitle + '\'' +
                ", examScore=" + examScore +
                ", startDateTime=" + startDateTime +
                ", endDateTime=" + endDateTime +
                ", questionDTOS=" + questionDTOS +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExamTitle() {
        return examTitle;
    }

    public void setExamTitle(String examTitle) {
        this.examTitle = examTitle;
    }

    public Set<QuestionDTO> getQuestionDTOS() {
        return questionDTOS;
    }

    public void setQuestionDTOS(Set<QuestionDTO> questionDTOS) {
        this.questionDTOS = questionDTOS;
    }

    public Float getExamScore() {
        return examScore;
    }

    public void setExamScore(Float examScore) {
        this.examScore = examScore;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }
}
