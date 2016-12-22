package com.i2i.service;

import com.i2i.exception.DataException;
import com.i2i.model.Exam;
import com.i2i.model.Result;
import com.i2i.model.User;

/**
 * <p>
 * Class which calculate the result of exam written by the user and pass the
 * mark along with user name and the exam name to storeResult method in data
 * access object.
 * </p>
 * 
 * @author user
 *
 */
public interface ResultManager extends GenericManager<Result, Integer> {

    /**
     * <p>
     * Method which calculates the result by comparing the question present in
     * question page and question in the database. Once the question is equal it
     * fetch the answers from the choice database and it checked with the user
     * selected answer if the answer were equal the mark gets incremented.
     * Atlast when all the answers were evaluated it pass the resultant mark,
     * examName, userName to storeResult method in data access object.
     * </p>
     * 
     * @param exam
     *     It contains the instance of user written exam.
     * @param examId
     *     Contains id of the exam which the user selected.
     * @param user
     *     Contains instance of user who selected the exam.
     * @return mark Contains calculated mark taken by the user.
     * @throws DataException
     *     Throws an exception to controller which gets generated at the
     *     time of database connection.
     */
    int calculateResult(Exam exam, int examId, User user) throws DataException;
}
