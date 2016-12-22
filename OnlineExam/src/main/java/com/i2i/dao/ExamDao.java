package com.i2i.dao;

import java.util.List;

import com.i2i.exception.DataException;
import com.i2i.model.Exam;

/**
 * <p>
 *     ExamDao interface contains method declarations which are probably used by the Exam entity
 *     for efficient retrieval, storing objects, assign user to prefered question and also to
 *     increase a count in allocated question column in a table.
 * </p>
 * 
 * @author TechAssess
 *
 */
public interface ExamDao extends GenericDao<Exam, Long> {

    /**
     * <p>
     *     Method which accept instance of exam to store it in a
     *     database and also it returns an id of inserted exam.
     * </p>
     * 
     * @param exam
     *     Object contains details of Exam like exam name,Duration etc.
     * @return int 
     *     Id of exam which is added to the database.
     * @throws DataException
     *     Throws an exception if inputs are invalid or if any Hibernate
     *     Exception is raised during database connection.
     */
    public int insertExamDetails(Exam exam) throws DataException;

    /**
     * <p>
     *     Retrieve all Exams from Database in List format and send this list back
     *     to Service Class.
     * </p>
     * 
     * @return list 
     *     Contains list of all exams
     * @throws DataException
     *     Throws an exception if inputs are invalid or if any Hibernate
     *     Exception is raised during database connection.
     */
    public List<Exam> retrieveAllExamDetails() throws DataException;
    /**
     * <p>
     *     Allocate Questions to Exam by Retrieving objects of Question and Exam
     *     model classes and create the temporary set.finally perform allocation by
     *     calling setExams and setQuestions methods Question and Exam model
     *     classes.
     * </p>
     * 
     * @param examId
     *     Contains id of Exam to allocate
     * @param questionId
     *     Contains id of Question to allocate
     * @throws DataException
     *     Throws an exception if inputs are invalid or if any Hibernate
     *     Exception is raised during database connection.
     */
    public void assignQuestionsToExam(int examId, int questionId) throws DataException;
       
    /**
     * <p>
     *     Increase the AllocatedQuestionscount of Exam after allocation of Question
     *     is performed successfully by calling setNoOfAllocatedQuestions method of
     *     Exam model classes.
     * </p>
     * 
     * @param exam
     *     Objects contains details of exam.
     */
    public void increaseAllocatedQuestionsCount(Exam exam);

    /**
     * <p>
     *     Allocate User to Exam by Retrieving objects of User and Exam Model
     *     classes and create the temporary set and add user object into that
     *     set.finally perform allocation by Calling setUsers and setExams methods
     *     of User and Exam model classes.
     * </p>
     * 
     * @param examId
     *     Contains id of Exam.
     * @param userId
     *     Contains id of user.
     * @throws DataException
     *     Throws an exception if inputs are invalid or if any Hibernate
     *     Exception is raised during database connection.
     */
    public boolean assignUserToExam(int examId, Long userId) throws DataException;

    /**
     * <p>
     *     Retrieves the Exam Details of particular id from database and return this
     *     details to ExamService class
     * </p>
     * 
     * @param examId
     *     Contains id of Exam to retrieve.
     * @return exam 
     *     Object which contains details of exam.
     * @throws DataException
     *     Throws an exception if inputs are invalid or if any Hibernate
     *     Exception is raised during database connection.
     */
    public Exam retrieveExamById(int examId) throws DataException;
}
