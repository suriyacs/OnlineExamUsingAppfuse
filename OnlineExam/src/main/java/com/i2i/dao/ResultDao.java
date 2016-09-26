package com.i2i.dao;

import java.util.List;
import com.i2i.exception.DataException;

import com.i2i.model.Result;

/**
 * <p>
 *     This class provide interface between database and Service class. used to
 *     store the result after user completed the exam.
 * </p>
 * 
 * @author TechAssess
 *
 */
public interface ResultDao extends GenericDao<Result, Integer> {

    /**
     * <p>
     *     This method get Result Object and Store this object into database
     * </p>
     * 
     * @param result
     *     Object contains an instance of result.
     * @throws DataException
     *     Throws an exception if inputs are invalid or if any Hibernate
     *     Exception is raised during database connection.
     */
    public void storeResult(Result result) throws DataException;
}
