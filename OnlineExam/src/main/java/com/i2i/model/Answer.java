package com.i2i.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>
 * Answer model is to used create an instance of answer type by using a
 * constructor or by using setter and getter methods.
 * </p>
 * 
 * @author TechAssess
 */
@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue
    @Column(name = "answer_id")
    private int answerId;

    @Column(name = "question_id")
    private int questionId;

    @Column(name = "answer")
    String userAnswer;

    public Answer() {
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }
}
