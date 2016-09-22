package com.i2i.service.impl;

import java.util.List;

import com.i2i.dao.QuestionTypeDao;
import com.i2i.model.QuestionType;
import com.i2i.model.Question;
import com.i2i.service.QuestionTypeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <P>
 * Service which accepts request from controller to perform operations like
 * insert question type and retrieve question type and it resolve the request by
 * forwarding the incoming request to their corresponding methods in Question
 * Data Access Object.
 * </P>
 * 
 * @author TechAssess
 *
 */
@Service("questionTypeManager")
public class QuestionTypeManagerImpl extends GenericManagerImpl<QuestionType, Integer>
    implements QuestionTypeManager {
    QuestionTypeDao questionTypeDao;

    @Autowired
    public QuestionTypeManagerImpl(QuestionTypeDao questionTypeDao) {
        super(questionTypeDao);
        this.questionTypeDao = questionTypeDao;
    }

    /**
     * <p>
     * Method which pass the typeId to retrieveTypeDetailById method present in
     * QuestionType DataAccessObject for retrieving details of given type Id.
     * </p>
     * 
     * @param typeId
     *     Consist of type id for retrieving the details.
     * @return object Returns QuestionType object of given typeId.
     * @throws DataException
     *     Throws an exception to controller which gets generated at the
     *     time of database connection.
     */
    public QuestionType getTypeDetailById(int typeId) { //throws DataException {
        return questionTypeDao.retrieveTypeDetailById(typeId);
    }

    /**
     * <p>
     * Method which pass questionType object and question object to
     * allocateQuestionToQuestionType method present in data access object for
     * allocating question to questiontype.
     * </p>
     * 
     * @param questionType
     *     Consist of questionType in which the question is created.
     * @param question
     *     It consist of question object to which the question type needs
     *     to be allocated.
     * @throws DataException
     *     Throws an exception to controller which gets generated at the
     *     time of database connection.
     */
    public void addQuestion(QuestionType questionType, Question question) { //throws DataException {
        questionTypeDao.allocateQuestionToQuestionType(questionType, question);
    }
}
