package com.example.Taskin.Model.dto;

public class AnswerQuestionDTO {

    protected Integer answerID;
    protected Integer questionID;

    public Integer getAnswerID() {
        return answerID;
    }

    public void setAnswerID(Integer answerID) {
        this.answerID = answerID;
    }

    public Integer getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Integer questionID) {
        this.questionID = questionID;
    }
}
