package com.i2i.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.security.core.GrantedAuthority;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * <p>
 * Pojo which creates instance of Choice type either by using constructor or by
 * setters and getters.
 * </p>
 */
@Entity
@Table(name = "Choice")
public class Choice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "choice_id")
    int choiceId;
    @Column(name = "choice_name")
    String choiceName;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "question_id")
    Question questionId;
    @Column(name = "is_correct")
    int isCorrect;

    public Choice() {

    }

    public Choice(String answer, int isCorrect) {
        this.choiceName = answer;
        this.isCorrect = isCorrect;
    }

    public void setChoiceId(int choiceId) {
        this.choiceId = choiceId;
    }

    public int getChoiceId() {
        return this.choiceId;
    }

    public void setChoiceName(String choiceName) {
        this.choiceName = choiceName;
    }

    public String getChoiceName() {
        return this.choiceName;
    }

    public void setQuestionId(Question questionId) {
        this.questionId = questionId;
    }

    public Question getQuestionId() {
        return this.questionId;
    }

    public void setIsCorrect(int isCorrect) {
        this.isCorrect = isCorrect;
    }

    public int getIsCorrect() {
        return isCorrect;
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
        if (!(o instanceof Choice)) {
            return false;
        }

        final Choice choiceObject = (Choice) o;

        return this.hashCode() == choiceObject.hashCode();
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
                .append("choiceId", this.choiceId)
                .append("choiceName", this.choiceName)
                .append("questionId", this.questionId)
                .append("isCorrect", this.isCorrect).toString();
    }
}
