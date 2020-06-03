package edu.zyb.exam.dao.impl;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import edu.zyb.exam.beans.TeacherUser;
import edu.zyb.exam.dao.TeacherDao;
@Repository("teacherDao")
public class TeacherDaoImpl implements TeacherDao {
	@Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

	public TeacherUser login(String username, String password) {
		@SuppressWarnings("unchecked")
		List<TeacherUser> lists = sessionFactory.getCurrentSession().createQuery("from TeacherUser where tid=? and password=?").setString(0, username).setString(1, password).list();
		if(lists!=null&&lists.size()==1)
			return lists.get(0);
		else
			return null;
	}
	public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	@SuppressWarnings("unchecked")
	public List<TeacherUser> findAllTea() {
		return sessionFactory.getCurrentSession().createQuery("from TeacherUser").list();
	}
	
	public boolean addTea(TeacherUser teacherUser) {
		sessionFactory.getCurrentSession().save(teacherUser);
		return true;
	}
	public boolean updateOneTea(TeacherUser teacherUser) {
		sessionFactory.getCurrentSession().update(teacherUser);
		return true;
	}
	public Integer findAllCount() {
		Object total = sessionFactory.getCurrentSession().createSQLQuery("select count(*) from teacheruser ").uniqueResult();
		return ((BigInteger) total).intValue();
	}
	public TeacherUser findOneTea(Integer tid) {
		return (TeacherUser) sessionFactory.getCurrentSession().createQuery("from TeacherUser where tid=?").setInteger(0, tid).list().get(0);
	}
	
	public boolean delTea(Integer tid) {
		TeacherUser teacherUser = new TeacherUser();
		teacherUser.setTid(tid);
		sessionFactory.getCurrentSession().delete(teacherUser);
		return false;
	}
	@SuppressWarnings("unchecked")
	public List<TeacherUser> getList(int i, int j) {
		return sessionFactory.getCurrentSession().createQuery("from TeacherUser ").setFirstResult(i).setMaxResults(j).list();
	}
}
