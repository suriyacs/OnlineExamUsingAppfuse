package com.i2i.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import com.i2i.model.Choice;
import com.i2i.model.QuestionType;

//import com.i2i.model.Exam;

/**
 * <p>
 * Question pojo for creating instance of Question type and store list of
 * choices along with set of exams.
 * </p>
 * 
 * @author TechAssess
 * @created 2016-08-27
 */
@Entity
@Table(name = "Question")
public class Question extends BaseObject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "question_id")
    int questionId;
    @Column(name = "question")
    String questionName;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "type_id")
    QuestionType typeId;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "question_id")
    List<Choice> choices = new ArrayList<Choice>();

    /*@LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "questions")
    Set<Exam> exams = new HashSet<Exam>();*/

    public Question() {

    }

    public Question(String questionName) {
        this.questionName = questionName;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getQuestionId() {
        return this.questionId;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getQuestionName() {
        return this.questionName;
    }

    public QuestionType getTypeId() {
        return this.typeId;
    }

    public void setTypeId(QuestionType typeId) {
        this.typeId = typeId;
    }

    public void setChoices(List<Choice> choice) {
        this.choices = choice;
    }

    /*@LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(mappedBy = "questions")
    public void setExams(Set<Exam> exam) {
        this.exams.addAll(exam);
    }

    public Set<Exam> getExams() {
        return exams;
    }*/

    public List<Choice> getChoices() {
        return this.choices;
    }

    public void add(Choice choice) {
        this.choices.add(choice);
    }

    /**
     * Overridden equals method for object comparison. Compares based on hashCode.
     *
     * @param o Object to compare
     * @return true/false based on hashCode
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Question)) {
            return false;
        }

        final Question questionObject = (Question) o;

        return this.hashCode() == questionObject.hashCode();
    }
    
    /**
     * Overridden hashCode method - compares on address, city, province, country and postal code.
     *
     * @return hashCode
     */
    public int hashCode() {
        return 1;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("questionId", this.questionId)
                .append("questionName", this.questionName)
                .append("typeId", this.typeId).toString();
    }
}
