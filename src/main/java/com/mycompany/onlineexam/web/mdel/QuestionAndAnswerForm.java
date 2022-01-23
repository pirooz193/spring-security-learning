package com.mycompany.onlineexam.web.mdel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class QuestionAndAnswerForm {
    @JsonProperty("questionCode")
    private String questionCode;
    @JsonProperty("answer")
    private String answer;

    public QuestionAndAnswerForm() {
    }

    public QuestionAndAnswerForm(String questionCode, String answer) {
        this.questionCode = questionCode;
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionAndAnswerForm that = (QuestionAndAnswerForm) o;
        return questionCode.equals(that.questionCode) && answer.equals(that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionCode, answer);
    }

    @Override
    public String toString() {
        return "QuestionAndAnswerForm{" +
                "questionCode='" + questionCode + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    public String getQuestionCode() {
        return questionCode;
    }

    public void setQuestionCode(String questionCode) {
        this.questionCode = questionCode;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
