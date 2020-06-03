package edu.zyb.exam.dao.impl;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import edu.zyb.exam.beans.BJ;
import edu.zyb.exam.dao.ClazzDao;
@Repository("clazzDao")
public class ClazzDaoImpl implements ClazzDao{
	@Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<BJ> findAllCla() {
		return sessionFactory.getCurrentSession().createQuery( "from BJ ").list();
	}

	public boolean delCla(Integer bjid) {
		BJ bj = (BJ) sessionFactory.getCurrentSession().createQuery("from BJ where bjid=?").setInteger(0, bjid).list().get(0);
		/*if(bj.getStudents()!=null&&bj.getStudents().size()>0)
			return false;*/
		sessionFactory.getCurrentSession().delete(bj);
		return true;
	}

	public BJ findOneCla(Integer bjid) {
		
		return (BJ) sessionFactory.getCurrentSession().createQuery("from BJ where bjid=?").setInteger(0, bjid).list().get(0);
	}

	public boolean updateOneCla(BJ bj) {
		sessionFactory.getCurrentSession().update(bj);
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<BJ> getList(int i, int j) {
		return sessionFactory.getCurrentSession().createQuery("from BJ").setFirstResult(i).setMaxResults(j).list();
	}

	public Integer findAllCount() {
		Object total = sessionFactory.getCurrentSession().createSQLQuery("select count(*) from bj ").uniqueResult();
		return ((BigInteger) total).intValue();
	}

	public boolean addCla(BJ bj) {
		sessionFactory.getCurrentSession().save(bj);
		return true;
	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
