package edu.zyb.exam.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import edu.zyb.exam.beans.AdminUser;
import edu.zyb.exam.dao.AdminDao;
@Repository("adminDao")
public class AdminDaoImpl implements AdminDao {
	@Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

	public AdminUser login(String username, String password) {
		@SuppressWarnings("unchecked")
		List<AdminUser> lists = sessionFactory.getCurrentSession().createQuery("from AdminUser where username=? and password=?").setString(0, username).setString(1, password).list();
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
}
