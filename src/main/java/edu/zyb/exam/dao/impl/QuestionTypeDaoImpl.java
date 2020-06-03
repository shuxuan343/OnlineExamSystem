package edu.zyb.exam.dao.impl;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import edu.zyb.exam.beans.Question;
import edu.zyb.exam.beans.QuestionType;
import edu.zyb.exam.dao.QuestionDao;
import edu.zyb.exam.dao.QuestionTypeDao;
@Repository("questionTypeDao")
public class QuestionTypeDaoImpl implements QuestionTypeDao {
	
	@Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
	
	public Integer findAllCount() {
		Object total = sessionFactory.getCurrentSession().createSQLQuery("select count(*) from questiontype ").uniqueResult();
		return ((BigInteger) total).intValue();
	}
	
	public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	

	public List<QuestionType> findAllQueTy() {
		@SuppressWarnings("unchecked")
		List<QuestionType> list = sessionFactory.getCurrentSession().createQuery( "from QuestionType ").list();
		return list;
	}

	public QuestionType getById(Integer qtid) {
		return (QuestionType) sessionFactory.getCurrentSession().createQuery( "from QuestionType where qtid=?").setInteger(0, qtid).list().get(0);
	}

}
