package com.i2i.dao;

import java.util.List;

import com.i2i.model.Choice;

/**
 * <p>
 *     This class provide interface between database and Service class. insert
 *     Choice Details from Service class into database and also perform retrieve
 *     Choice information from database.
 * </p>
 * 
 * @author TechAssess
 */
public interface ChoiceDao extends GenericDao<Choice, Integer> {

    /**
     * <p>
     *     Gets Choice model Object from Service class which contains details of
     *     Choice and create the session then begin the transaction persist the
     *     Choice object and close the session. returns id after insertion of chioce
     *     into database.
     * </p>
     * 
     * @param choice
     *     Choice object which contains the details of choice like
     *     name,IsCorrect etc.
     * @return choiceId 
     *     Contains id Choice which is added to database;
     * @throws DataException
     *     Throws an exception if inputs are invalid or if any Hibernate
     *     Exception is raised during database connection.
     */
    public int insertChoice(Choice choice);

    /**
     * <p>
     *     Retrieves the Choice Details of particular id from database and return
     *     this details to ChoiceService class
     * </p>
     * 
     * @param choiceId
     *     Contains id Choice to retrieve
     * @return choice 
     *     Object contains details of choice of particular id
     * @throws DataException
     *     Throws an exception if inputs are invalid or if any Hibernate
     *     Exception is raised during database connection.
     */
    public Choice retrieveChoiceDetailById(int choiceId); 

    /**
     * <p>
     *     Allocate Question to Choice by retrieving objects of Choice and Question
     *     by id and pass the question object into setQuestion Method of Choice
     *     model class.
     * </p>
     * 
     * @param choiceId
     *     Id of choice to allocate question
     * @param questionId
     *     Id question to allocate
     * @throws DataException
     *     Throws an exception if inputs are invalid or if any Hibernate
     *     Exception is raised during database connection.
     */
    public void assignQuestion(int choiceId, int questionId); 
}
