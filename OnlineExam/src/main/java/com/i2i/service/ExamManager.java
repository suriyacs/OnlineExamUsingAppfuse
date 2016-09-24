package com.i2i.service;

import java.util.List;

import com.i2i.model.Exam;
/*import exception.DataException;
import model.Exam;
import model.User;

/**
 * <p>
 * Service which accepts request from controller to perform operations like
 * insert exam details, retrieve exam details, allocate questions to exam, check
 * the given exam is present and finally allocate users to exam. It resolve the
 * request by forwarding the incoming request to their corresponding methods in
 * Exam Data Access Object.
 * </p>
 * 
 * @author TechAssess
 *
 */
public interface ExamManager extends GenericManager<Exam, Long> {
    //ExamDao examDao = new ExamDao();

    /**
     * <p>
     * Method which pass the given exam details to insert exam details method
     * present in data access object to insert into database.
     * </p>
     * 
     * @param exam
     *     Consist instance of exam to be forwarded to Data Access
     *     Object.
     * @return int Returns id of the given exam when the instance of exam is
     *         inserted successfully.
     * @throws DataException
     *     Throws an exception to controller which gets generated at the
     *     time of database connection.
     */
     int addExamDetails(Exam exam); //throws DataException {
     
    /**
     * 
     * <p>
     * Method which send request to Data Access Object for allocating Questions
     * to an Exam.
     * </p>
     * 
     * @param examId
     *     Contains id of exam for which the question needs to be
     *     allocated.
     * @param questionId
     *     Contains id of question needs to be traced for allocating to
     *     the exam.
     * @throws DataException
     *     Throws an exception to controller which gets generated at the
     *     time of database connection.
     */
    /*public void allocateQuestionsToExam(int examId, int fromQuestionId, int toQuestionId) throws DataException {
        Exam exam = getExamById(examId);
        if (null != exam.getNoOfAllocatedQuestions()) {
            if (Integer.parseInt(exam.getNoOfAllocatedQuestions()) == exam.getNoOfTotalQuestions()) {
                throw new DataException(
                        "This Exam already allocated with enough questions..!Try again with different Id..!!");
            }
        }
        for (int questionId = fromQuestionId; questionId <= toQuestionId; questionId++) {
            examDao.assignQuestionsToExam(examId, questionId);
        }
    }*/

    /**
     * <p>
     * Method which send request to DataAccessObject for retrieving details of
     * entire exam in the form of List.
     * </p>
     * 
     * @return list<Exam> Return entire exam details in the form of list.
     * @throws DataException
     *      Throws an exception to controller which gets generated at the
     *      time of database connection.
     */
     List<Exam> getAllExamDetails(); //throws DataException {
     public void allocateQuestionsToExam(int examId, int fromQuestionId, int toQuestionId);
    /**
     * <p>
     * Method which send request to DataAccessObject to check if the given exam
     * id exist.
     * </p>
     * 
     * @param examId
     *     Consist of exam id which needs to be check if the given id
     *     exists.
     * @throws DataException
     *     Throws an exception to controller which gets generated at the
     *     time of database connection.
     */
     void checkIfExamExist(int examId);
        
    /**
     * Method which send request to Exam DataAccessObject for allocating user to
     * exam.
     * 
     * @param examId
     *     Consist of examId to which the user has to be allocated.
     * @param userId
     *     Consist of userId who have selected the exam.
     * @throws DataException
     *     Throws an exception to controller which gets generated at the
     *     time of database connection.
     */
    /*public void addUserToExam(String examId, int userId) throws DataException {
        examDao.assignUserToExam(Integer.parseInt(examId), userId);
    }*/

    /**
     * Method which accept the request and retrieve the exam details of given
     * exam id by passing the examId to DataAccessObject.
     * 
     * @param examId
     *     Consist of id for retrieving the exam details of given id.
     * @return object Returns exam object of given exam id.
     * @throws DataException
     *     Throws an exception to controller which gets generated at the
     *     time of database connection.
     */
     Exam getExamById(int examId); //throws DataException {
     //boolean checkIfUserAlreadyAttendedThisTest(String testId, User user);
}
