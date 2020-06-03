package edu.zyb.exam.dao.impl;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import edu.zyb.exam.beans.Question;
import edu.zyb.exam.dao.QuestionDao;
@Repository("questionDao")
public class QuestionDaoImpl implements QuestionDao {
	
	@Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
	
	public Integer findAllCount(Integer queTyp) {
		Object total=null;
		if(queTyp==null)
			total = sessionFactory.getCurrentSession().createSQLQuery("select count(*) from question ").uniqueResult();
		else
			total = sessionFactory.getCurrentSession().createSQLQuery("select count(*) from question where qtid=?").setInteger(0, queTyp).uniqueResult();
		return ((BigInteger) total).intValue();
	}

	@SuppressWarnings("unchecked")
	public List<Question> getList(int page, int count,Integer queTyp) {
		List<Question> list = null;
		if(queTyp==null)
			list = sessionFactory.getCurrentSession().createQuery( "from Question ").setFirstResult(page).setMaxResults(count).list();
		else
			list = sessionFactory.getCurrentSession().createQuery( "from Question where qtid=?").setInteger(0, queTyp).setFirstResult(page).setMaxResults(count).list();
		return list;
	}
	

	public boolean delQue(Integer qid) {
		sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().createQuery("from Question where qid=?").setInteger(0, qid).list().get(0));
		return true;
	}

	public boolean addQue(Question question) {
		sessionFactory.getCurrentSession().save(question);
		return true;
	}

	public Question findOneQue(Integer integer) {
		return (Question) sessionFactory.getCurrentSession().createQuery("from Question where qid=?").setInteger(0, integer).list().get(0);
	}

	public boolean updateOneQue(Question question) {
		sessionFactory.getCurrentSession().update(question);
		return true;
	}

	
	public int queryJudge(String key, String value) {
		Object object = sessionFactory.getCurrentSession().createSQLQuery("SELECT qt.score from question q RIGHT JOIN questiontype qt on qt.qtid = q.qtid where q.qid=? and q.qanswer=?").setInteger(0, Integer.parseInt(key)).setString(1, value).uniqueResult();
		if(object==null)
			return 0;
		else
			return (Integer) object;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
