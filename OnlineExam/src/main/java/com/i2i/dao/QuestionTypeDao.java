package com.i2i.dao;

import java.util.List;

import com.i2i.model.QuestionType;
import com.i2i.exception.DataException;
import com.i2i.model.Question;

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
public interface QuestionTypeDao extends GenericDao<QuestionType, Integer> {

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
    public QuestionType retrieveTypeDetailById(int typeId)throws DataException;

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
    public void allocateQuestionToQuestionType(QuestionType questionType, Question question)throws DataException;
}
