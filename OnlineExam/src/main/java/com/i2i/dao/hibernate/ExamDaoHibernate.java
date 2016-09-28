package com.i2i.dao.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import com.i2i.dao.ExamDao;
import com.i2i.exception.DataException;
import com.i2i.model.Exam;
import com.i2i.model.Question;
import com.i2i.model.User;
import com.i2i.util.FileUtil;

/**
 * <p>
 *     This class provide interface between database and Service class. insert Exam
 *     Details from Service class into database and also perform retrieve Exam
 *     information from database and allocate Question operations.
 * </p>
 * 
 * @author TechAssess
 *
 */
@Repository
public class ExamDaoHibernate extends GenericDaoHibernate<Exam, Long> implements ExamDao {

    /**
     * Constructor to create a Generics-based version using Exam as the entity
     */    
    public ExamDaoHibernate() {
        super(Exam.class);
    }
    
    /**
     * <p>
     *     Gets Exam model Object from Service class which contains details of Exam
     *     and create the session then begin the transaction persist the exam object
     *     and close the session returns id after insertion of exam into database.
     * </p>
     * 
     * @param exam
     *     Object contains details of Exam like exam name,Duration etc.
     * @return id 
     *     Id of exam which is added to the database.
     * @throws DataException
     *     Throws an exception if inputs are invalid or if any Hibernate
     *     Exception is raised during database connection.
     */
    public int insertExamDetails(Exam exam) throws DataException {
        try {
            return (int)getSession().save(exam);
        } catch (HibernateException e) {
            throw new DataException("Error occured while adding exam details." + "," + e);
        }
    }

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
    @SuppressWarnings("unchecked")
    public List<Exam> retrieveAllExamDetails() throws DataException {         
        try {
            return getSession().createQuery("from Exam").list();
        } catch (HibernateException e) {
            throw new DataException("Error occured while retrieving all exam details. Kindly try again."
                + "," + e);
        } 
    }

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
     public void assignQuestionsToExam(int examId, int questionId) throws DataException {
         try {
            Question question = (Question) getSession().get(Question.class, questionId);
            Exam exam = (Exam) getSession().get(Exam.class, examId);
            if (question != null) {
                Set<Exam> examSet = new HashSet<Exam>();
                exam.setQuestions(question);
                examSet.add(exam);
                question.setExams(examSet);
                increaseAllocatedQuestionsCount(exam);
                getSession().save(exam);
                getSession().save(question);
            }
        } catch (HibernateException e) {
            throw new DataException("Cannot able to assign questionId" + " " + questionId 
                + " " + "to examId" + " " + examId + "," + e);
        } 
    }

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
    public void increaseAllocatedQuestionsCount(Exam exam) {
        if (exam.getNoOfAllocatedQuestions() != null) {
            int count = Integer.parseInt(exam.getNoOfAllocatedQuestions());
            count++;
            exam.setNoOfAllocatedQuestions(count + "");
        } else {
            exam.setNoOfAllocatedQuestions("1");
        }
    }

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
    public boolean assignUserToExam(int examId, Long userId) throws DataException {
        try {
            Set<User> userSet = new HashSet<User>();
            Set<Exam> examSet = new HashSet<Exam>();
            Exam exam = (Exam) getSession().get(Exam.class, examId);
            User user = (User) getSession().get(User.class, userId);
            userSet.add(user);
            examSet.add(exam);
            user.setExams(examSet);
            return true;
        } catch (HibernateException e) {
            throw new DataException("Error occured while allocation userId" + " " + userId + " " 
                + "to examId" + " " + examId + "," + e);
        }
    }   

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
    public Exam retrieveExamById(int examId) throws DataException {
        try {
            return (Exam) getSession().get(Exam.class, examId);
        } catch (HibernateException e) {
            throw new DataException("Error occured while retreieving exam details for given examId" 
                + " " + examId + "," + e);
        } 
    }
}
