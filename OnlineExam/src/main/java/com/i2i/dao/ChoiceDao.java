package com.i2i.dao;

import com.i2i.exception.DataException;
import com.i2i.model.Choice;

/**
 * <p>
 *     ChoiceDao interface contains method declarations which are probably used by the choice entity
 *     for efficient retrieval, storing objects and assign question to prefered choice.
 * </p>
 * 
 * @author TechAssess
 */
public interface ChoiceDao extends GenericDao<Choice, Integer> {

    /**
     * <p>
     *     Method which accepts choice instance to store it in
     *     database and return the generated id of inserted choice.
     * </p>
     * 
     * @param choice
     *     Object which contains the details of choice like
     *     name,IsCorrect etc.
     * @return int 
     *     Contains id of Choice which is added to database;
     * @throws DataException
     *     Throws an exception if inputs are invalid or if any Hibernate
     *     Exception is raised during database connection.
     */
    public int insertChoice(Choice choice) throws DataException;

    /**
     * <p>
     *     Method which used to retrieve detail of an given choiceId.
     * </p>
     * 
     * @param choiceId
     *     Contains id Choice to retrieve
     * @return object 
     *     Object which contains detail of an given id
     * @throws DataException
     *     Throws an exception if inputs are invalid or if any Hibernate
     *     Exception is raised during database connection.
     */
    public Choice retrieveChoiceDetailById(int choiceId) throws DataException; 

    /**
     * <p>
     *     Method which accept choiceId and questionId to assign
     *     question of given questionId to choice of given choiceId.
     * </p>
     * 
     * @param choiceId
     *     Contains Id of choice to allocate question
     * @param questionId
     *     Contains Id of question to allocate
     * @throws DataException
     *     Throws an exception if inputs are invalid or if any Hibernate
     *     Exception is raised during database connection.
     */
    public void assignQuestion(int choiceId, int questionId) throws DataException; 
}
