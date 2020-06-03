package edu.zyb.exam.dao.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import edu.zyb.exam.beans.Question;
import edu.zyb.exam.beans.Relationpq;
import edu.zyb.exam.beans.TestControl;
import edu.zyb.exam.beans.TestNote;
import edu.zyb.exam.beans.TestPaper;
import edu.zyb.exam.dao.TestnoteDao;
import edu.zyb.exam.dao.TestpaperDao;
@Repository("testnoteDao")
public class TestnoteDaoImpl implements TestnoteDao{

	@Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Object> queryTestonteStus(int page, int limit,Integer tcid) {
		List<Object> objects = sessionFactory.getCurrentSession().createSQLQuery("SELECT s.sid,s.name,b.bjname,tn.score "
				+ "from student s LEFT JOIN bj b ON b.bjid=s.bjid LEFT JOIN testnote tn"
				+ " on tn.sid=s.sid left JOIN testcontrol tc on tc.tcid=tn.tcid "
				+ "WHERE tn.tcid=? ORDER BY s.bjid asc,tn.score desc ").setInteger(0,tcid).setFirstResult(page).setMaxResults(limit).list();
		return objects;
	}
	
	public Integer findCountTestonteStus(Integer tcid) {
		Object total = sessionFactory.getCurrentSession().createSQLQuery("SELECT count(s.sid) from student s LEFT JOIN bj b "
				+ "ON b.bjid=s.bjid LEFT JOIN testnote tn on tn.sid=s.sid left JOIN testcontrol tc on tc.tcid=tn.tcid "
				+ "WHERE tn.tcid=?").setInteger(0, tcid).uniqueResult();
		return ((BigInteger) total).intValue();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> queryTestonteStu(int page, int limit,Integer sid) {
		return sessionFactory.getCurrentSession().createSQLQuery("SELECT s.sid,s.name,tc.tdate,qp.qpname,tn.score,tn.tscore from student s  "
				+ "LEFT JOIN testnote tn on tn.sid=s.sid left JOIN testcontrol tc on tc.tcid=tn.tcid "
				+ "left JOIN questionpaper qp on qp.qpid=tc.qpid WHERE s.sid=? "
				+ "ORDER BY tn.tcid desc").setInteger(0, sid).setFirstResult(page).setMaxResults(limit).list();
	}
	public Integer findCountTestonteStu(Integer sid) {
		Object total = sessionFactory.getCurrentSession().createSQLQuery("SELECT count(s.sid) from student s  "
				+ "LEFT JOIN testnote tn on tn.sid=s.sid left JOIN testcontrol tc on tc.tcid=tn.tcid "
				+ "left JOIN questionpaper qp on qp.qpid=tc.qpid WHERE s.sid=? "
				+ "ORDER BY tn.tcid desc").setInteger(0, sid).uniqueResult();
		return ((BigInteger) total).intValue();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
