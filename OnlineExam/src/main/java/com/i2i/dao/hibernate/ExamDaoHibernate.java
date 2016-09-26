package com.i2i.dao.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.i2i.dao.ExamDao;
import com.i2i.exception.DataException;
import com.i2i.model.Exam;
import com.i2i.model.Question;
import com.i2i.util.FileUtil;
/*import dbconnection.DataBaseConnection;
import exception.DataException;
import model.Exam;
import model.Question;
import model.User;
import util.FileUtil;

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
    /*private DataBaseConnection connection = DataBaseConnection.getConnection();
    private SessionFactory factory = connection.createSessionFactory();*/
    
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
        int id = 0;
        
       
        try {
            id = (int)getSession().save(exam);
        } catch (HibernateException e) {
            FileUtil.logError("Exception occured in insertExamDetails method in ExamDao" + e);
            throw new DataException("Error occured while adding exam details");
        }
        return id;
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
    public List<Exam> retrieveAllExamDetails() throws DataException {         
        try {
            return getSession().createQuery("from Exam").list();
        } catch (HibernateException e) {
            FileUtil.logError("Exception occured in retrieveAllExamDetails method in ExamDao" + e);
            throw new DataException("Error occured while retrieving all exam details. Kindly try again");
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
            FileUtil.logError("Exception occured in assignQuestionsToExam method in ExamDao" + e);
            throw new DataException("Cannot able to assign questionId" + " " + questionId + " " + "to examId" + " " + examId);
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
   /* @SuppressWarnings("finally")
    public Exam assignUserToExam(int examId, int userId) throws DataException {
        Session session = factory.openSession();
        Exam exam = null;
        try {
            Set<User> userSet = new HashSet<User>();
            Set<Exam> examSet = new HashSet<Exam>();
            Transaction transaction = session.beginTransaction();
            exam = (Exam) session.get(Exam.class, examId);
            User user = (User) session.get(User.class, userId);
            userSet.add(user);
            exam.setUsers(userSet);
            examSet.add(exam);
            user.setExams(examSet);
            session.save(user);
            session.save(exam);
            transaction.commit();
        } catch (HibernateException e) {
            FileUtil.logError("Exception occured in assignUserToExam method in ExamDao" + e);
            throw new DataException(
                    "Error occured while allocation userId" + " " + userId + " " + "to examId" + " " + examId);
        } finally {
            session.close();
            return exam;
        }
    }*/

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
            FileUtil.logError("Exception occured in retrieveExamById method in ExamDao" + e);
            throw new DataException("Error occured while retreieving exam details for given examId" + " " + examId);
        } 
    }
}
