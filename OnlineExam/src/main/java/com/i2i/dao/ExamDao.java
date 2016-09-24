package com.i2i.dao;

import java.util.List;

import com.i2i.model.Exam;

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
public interface ExamDao extends GenericDao<Exam, Long> {

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
     int insertExamDetails(Exam exam);

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
     List<Exam> retrieveAllExamDetails();// throws DataException {
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
    public void assignQuestionsToExam(int examId, int questionId);
       
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
     void increaseAllocatedQuestionsCount(Exam exam);

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

     Exam retrieveExamById(int examId); //throws DataException
      
}
