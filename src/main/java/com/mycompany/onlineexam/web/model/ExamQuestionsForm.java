package com.mycompany.onlineexam.web.model;

import com.mycompany.onlineexam.domain.Answer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: Pirooz
 * Date : 4/27/2022
 * Time : 11:25 AM
 */
public class ExamQuestionsForm {
    private String  questionCode ;
    private String questionTitle ;
    private Set<Answer> answers ;

    public ExamQuestionsForm(String questionCode, String questionTitle, Set<Answer> answers) {
        this.questionCode = questionCode;
        this.questionTitle = questionTitle;
        this.answers = answers;
    }

    public String getQuestionCode() {
        return questionCode;
    }

    public void setQuestionCode(String questionCode) {
        this.questionCode = questionCode;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }
}
