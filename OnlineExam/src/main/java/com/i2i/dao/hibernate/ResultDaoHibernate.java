package com.i2i.dao.hibernate;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import com.i2i.dao.ResultDao;
import com.i2i.exception.DataException;
import com.i2i.model.Result;
import com.i2i.util.FileUtil;

/**
 * <p>
 *     This class provide interface between database and Service class. used to
 *     store the result after user completed the exam.
 * </p>
 * 
 * @author TechAssess
 *
 */
@Repository
public class ResultDaoHibernate extends GenericDaoHibernate<Result, Integer> implements ResultDao {

     /**
     * Constructor to create a Generics-based version using Result as the entity
     */
    public ResultDaoHibernate() {
        super(Result.class);
    }
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
    public void storeResult(Result result) throws DataException {
        try {
            getSession().save(result);
        } catch (HibernateException e) {
            FileUtil.logError("Exception occured in storeResult method in ResultDao" + e);
            throw new DataException("Cannot able to store calculated result.");
        }
    }
}
