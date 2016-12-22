package com.i2i.dao;

import java.util.List;

import com.i2i.exception.DataException;
import com.i2i.model.Question;

/**
 * <p>
 *     QuestionDao interface contains method declarations which are probably used by the Question entity
 *     for efficient retrieval, storing objects, assign question type to prefered question.
 * </p>
 * 
 * @author TechAssess
 *
 */
public interface QuestionDao extends GenericDao<Question, Integer> {

    /**
     * <p>
     *     Gets Question model Object from Service class which contains details of
     *     Question and create the session then begin the transaction persist the
     *     exam object and close the session returns id after insertion of Question
     *     into database.
     * </p>
     * 
     * @param question
     *     Object which contains the details of Question.
     * @return questioId
     *     Id of question which is added to the database.
     * @throws DataException
     *     Throws an exception if inputs are invalid or if any Hibernate
     *     Exception is raised during database connection.
     */
    public int insertQuestion(Question question) throws DataException;

    /**
     * <p>
     *     Allocate QuestionType to Question by Retrieving objects of Question and
     *     QuestionType Model classes and finally perform allocation by Calling
     *     setTypeId method of Question Model Class.
     * </p>
     * 
     * @param typeId
     *     Contains id of QuestionType.
     * @param questionId
     *     Contains id of Question.
     * @throws DataException
     *     Throws an exception if inputs are invalid or if any Hibernate
     *     Exception is raised during database connection.
     */
    public void assignQuestionType(int typeId, int questionId) throws DataException;

    /**
     * <p>
     *     Retrieves the Question Details of particular id from database and return
     *     this details to QuestionService class
     * </p>
     * 
     * @param questionId
     *     Contains id of question to retrieve.
     * @return Question 
     *     Contains details of question in object type.
     * @throws DataException
     *     Throws an exception if inputs are invalid or if any Hibernate
     *     Exception is raised during database connection.
     */
    public Question retrieveQuestionDetailById(int questionId) throws DataException;

    /**
     * <p>
     *     Retrieve all Questions Details from Database in List format and send this
     *     list back to Service Class.
     * </p>
     * 
     * @return allQuestions 
     *     Contains instance of all question in the form of list.
     * @throws DataException
     *     Throws an exception if inputs are invalid or if any Hibernate
     *     Exception is raised during database connection.
     */
    public List<Question> retrieveAllQuestions() throws DataException;
}
