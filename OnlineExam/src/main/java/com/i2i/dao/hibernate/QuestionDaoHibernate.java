package com.i2i.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import com.i2i.dao.QuestionDao;
import com.i2i.exception.DataException;
import com.i2i.model.Question;
import com.i2i.model.QuestionType;
import com.i2i.util.FileUtil;
/**
 * <p>
 *     This class provide interface between database and Service class. insert
 *     Questions Details from Service class into database and also perform retrieve
 *     Question information from database and assign questiontype operations.
 * </p>
 * 
 * @author TechAssess
 *
 */
@Repository
public class QuestionDaoHibernate extends GenericDaoHibernate<Question, Integer> implements QuestionDao {
    
    /**
     * Constructor to create a Generics-based version using Question as the entity
     */
    public QuestionDaoHibernate() {
        super(Question.class);
    }
    
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
    public int insertQuestion(Question question) throws DataException {
        try {
            return (int) getSession().save(question);
        } catch (HibernateException e) {
            throw new DataException("Cannot able to add Question. Kindly try again." + "," + e);
        } 
    }

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
    public void assignQuestionType(int typeId, int questionId) throws DataException {
        try {
           Question question = (Question) getSession().get(Question.class, questionId);
           QuestionType questionType = (QuestionType) getSession().get(QuestionType.class, typeId);
           question.setTypeId(questionType);
        } catch (HibernateException e) {
            throw new DataException(
                   "Error occured while assigning typeId" + " " + typeId + " " + "to questionId" 
                       + " " + questionId + "," + e);
        } 
    }

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
    public Question retrieveQuestionDetailById(int questionId) throws DataException {
        try {
            return (Question) getSession().get(Question.class, questionId);
        } catch (HibernateException e) {
            throw new DataException("Error occured while retrieving details for given questionId"
                + " " + questionId + "," + e);
        } 
    }

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
    @SuppressWarnings("unchecked")
    public List<Question> retrieveAllQuestions() throws DataException {
        try {
            return getSession().createQuery("from Question").list();
        } catch (HibernateException e) {
            throw new DataException("Error occured while retrieving details for all questions." 
                + "," + e);
        } 
    }
}
