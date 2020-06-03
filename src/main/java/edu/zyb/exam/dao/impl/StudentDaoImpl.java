package edu.zyb.exam.dao.impl;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import edu.zyb.exam.beans.Student;
import edu.zyb.exam.dao.StudentDao;
@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {
	@Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

	public Student login(String username, String password) {
		@SuppressWarnings("unchecked")
		List<Student> lists = sessionFactory.getCurrentSession().createQuery("from Student where sid=? and password=?").setInteger(0,Integer.parseInt(username)).setString(1, password).list();
		if(lists!=null&&lists.size()==1)
			return lists.get(0);
		else
			return null;
	}
	public boolean addStu(Student student) {
		sessionFactory.getCurrentSession().save(student);
		return true;
	}
	public Integer findAllCount() {
		Object total = sessionFactory.getCurrentSession().createSQLQuery("select count(*) from student ").uniqueResult();
		return ((BigInteger) total).intValue();
		
	}
	public boolean delStu(Integer sid) {
		sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().createQuery("from Student where sid=?").setInteger(0, sid).list().get(0));
		return true;
	}
	public boolean updateOneStu(Student student) {
		sessionFactory.getCurrentSession().update(student);
		return true;
	}
	public Student findOneStu(Integer sid) {
		return (Student) sessionFactory.getCurrentSession().createQuery("from Student where sid=?").setInteger(0, sid).list().get(0);
	}
	@SuppressWarnings("unchecked")
	public List<Student> getList(int i, int j) {
		return sessionFactory.getCurrentSession().createQuery("from Student").setFirstResult(i).setMaxResults(j).list();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
