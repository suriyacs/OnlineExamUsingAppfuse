package com.i2i.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.dao.ExamDao;
import com.i2i.model.Exam;
import com.i2i.model.User;
import com.i2i.service.ExamManager;
import com.i2i.exception.DataException;
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
@Service("examManager")
public class ExamManagerImpl extends GenericManagerImpl<Exam, Long> implements ExamManager {
    ExamDao examDao;
    
    @Autowired
    public ExamManagerImpl(ExamDao examDao) {
        super(examDao);
        this.examDao = examDao;
    }

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
    public int addExamDetails(Exam exam) throws DataException {
        try {
            return (examDao.insertExamDetails(exam));
        } catch (DataException e) {
            throw new DataException(e.getMessage().toString());
        }
    }

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
    public void allocateQuestionsToExam(int examId, int fromQuestionId, int toQuestionId) throws DataException {
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
    }

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
    public List<Exam> getAllExamDetails() throws DataException {
        List<Exam> allExams = examDao.retrieveAllExamDetails();
        if (null == allExams) {
            throw new DataException("There is no Exams in Database.Please insert some Exams first..!!");
        }
        return (allExams);
    }

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
    public void checkIfExamExist(int examId) throws DataException {
        if (null == getExamById(examId)) {
            throw new DataException("Exam with this Id Does not Exist..!!Try Again..!!");
        }
    }

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
    public void addUserToExam(String examId, Long userId) throws DataException {
        if (!(examDao.assignUserToExam(Integer.parseInt(examId), userId))) {
        	throw new DataException("Sorry!!Can't Shedule This Exam to you.Try Again.!!");
        }
    }

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
    public Exam getExamById(int examId) throws DataException {
        return examDao.retrieveExamById(examId);
    }

    public boolean checkIfUserAlreadyAttendedThisTest(String testId, User user) {
        if (null != user.getExams()) {
            for (Exam exam : user.getExams()) {
                if (exam.getExamId() == Integer.parseInt(testId)) {
                    return true;
                }
            }
        }
        return false;
    }
}
