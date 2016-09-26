package com.i2i.service.impl;

import java.util.List;

import com.i2i.dao.ChoiceDao;
import com.i2i.exception.DataException;
import com.i2i.model.Choice;
import com.i2i.service.ChoiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * ChoiceService gets request from controller and process the given data by
 * forwarding the request to Data Access Object of Choice.
 * </p>
 * 
 * @author TechAssess
 *
 */
@Service("choiceManager")
public class ChoiceManagerImpl extends GenericManagerImpl<Choice, Integer> implements ChoiceManager {
    ChoiceDao choiceDao;

    @Autowired
    public ChoiceManagerImpl(ChoiceDao choiceDao) {
        super(choiceDao);
        this.choiceDao = choiceDao;
    }
    
    /**
     * <p>
     * Method which gets choice details from controller and pass this details
     * back to insertChoice method of choiceDao class.
     * </p>
     * 
     * @param answer
     *     Contains given answer for the question.
     * @param correctAnswer
     *     Contains integer value to indicate that the given answer is
     *     correct or not.
     * @return int Comprise the choiceId generated at the time of insertion.
     * @throws DataException
     *     Throws an exception to controller which gets generated at the
     *     time of database connection.
     */
    public int addChoice(String answer, int correctAnswer) throws DataException {
        return choiceDao.insertChoice(new Choice(answer, correctAnswer));
    }

    /**
     * <p>
     * Method which gets details of particular choice by passing id of that
     * choice into retrieveChoiceDetailsById method of ChoiceDao class.
     * </p>
     * 
     * @param choiceId
     *     Consist of ChoiceId for retrieving the choice details of given
     *     id.
     * @return object Comprise instance of Choice type of given choice Id.
     * @throws DataException
     *     Throws an exception to controller which gets generated at the
     *     time of database connection.
     */
    public Choice getChoiceDetailsById(int choiceId) throws DataException {
        return choiceDao.retrieveChoiceDetailById(choiceId);
    }

    /**
     * <p>
     * Method which allocateQuestion to particular choice by passing id of both
     * question and choice into assignQuestion method of ChoiceDao class
     * </p>
     * 
     * @param choiceId
     *     Consist id of choice to allocate.
     * @param questionId
     *     Consist id of question to allocate.
     * @throws DataException
     *     Throws an exception to controller which gets generated at the
     *     time of database connection.
     */
    public void allocateQuestion(int choiceId, int questionId) throws DataException {
        choiceDao.assignQuestion(choiceId, questionId);
    }
}
