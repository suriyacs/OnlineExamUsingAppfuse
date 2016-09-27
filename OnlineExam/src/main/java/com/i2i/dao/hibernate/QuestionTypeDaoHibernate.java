package com.i2i.dao.hibernate;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

import com.i2i.dao.QuestionTypeDao;
import com.i2i.exception.DataException;
import com.i2i.model.Question;
import com.i2i.model.QuestionType;
import com.i2i.util.FileUtil;

/**
 * <p>
 *     This class provide interface between database and Service class. insert
 *     QuestionType Details from Service class into database and also perform
 *     retrieve QuestionType information from database and allocate Question
 *     operations.
 * </p>
 *
 * @author TechAssess
 */
@Repository
public class QuestionTypeDaoHibernate extends GenericDaoHibernate<QuestionType, Integer> implements QuestionTypeDao {
    
    /**
     * Constructor to create a Generics-based version using QuestionType as the entity
     */
    public QuestionTypeDaoHibernate() {
        super(QuestionType.class);
    }

    /**
     * <p>
     *     Retrieves the QuestionType Details of particular id from database and
     *     return this details to QuestionTypeService class
     * </p>
     * 
     * @param typeId
     *     Contains id of QuestionType to retrieve.
     * @return QuestionType 
     *     Contains instance of question type.
     * @throws DataException
     *     Throws an exception if inputs are invalid or if any Hibernate
     *     Exception is raised during database connection.
     */
    public QuestionType retrieveTypeDetailById(int typeId) throws DataException {
        QuestionType questionType = null;
        try {
            questionType = (QuestionType) getSession().get(QuestionType.class, typeId);
        } catch (HibernateException e) {
            FileUtil.logError("Exception occured in retrieveTypeDetailById method in QuestionTypeDao" + e);
            throw new DataException("Cannot able retrieve details for given typeId" + " " + typeId);
        } 
        return questionType;
    }

    /**
     * <p>
     *     Allocate Question to QuestionType by Calling setQuestion and method of
     *     QuestionType model class.
     * </p>
     * 
     * @param questionType
     *     Object which contains the details of particular QuestionType.
     * @param question
     *     Object which contains the details of particular Question.
     * @throws DataException
     *     Throws an exception if inputs are invalid or if any Hibernate
     *     Exception is raised during database connection.
     */
    public void allocateQuestionToQuestionType(QuestionType questionType, Question question) throws DataException {
        try {
            Set<Question> questionSet = new HashSet<Question>();
            questionSet.add(question);
            questionType.setQuestion(questionSet);
            getSession().save(questionType);
            getSession().save(question);
        } catch (HibernateException e) {
            FileUtil.logError("Exception occured in allocateQuestionToQuestionType method in QuestionTypeDao" + e);
            throw new DataException("Cannot able to allocate questionId" + " " + question.getQuestionId()
                  + "to questionType" + " " + questionType.getTypeId());
        } 
    }
}
