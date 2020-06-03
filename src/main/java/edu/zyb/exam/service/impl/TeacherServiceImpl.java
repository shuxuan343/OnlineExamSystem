package edu.zyb.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zyb.exam.beans.TeacherUser;
import edu.zyb.exam.dao.TeacherDao;
import edu.zyb.exam.service.TeacherService;
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	private TeacherDao teacherDao;
	public TeacherUser login(String username, String password) {
		return teacherDao.login(username,password);
	}
	public List<TeacherUser> findAllTea() {
		return teacherDao.findAllTea();
	}
	public boolean addTea(TeacherUser teacherUser) {
		return teacherDao.addTea(teacherUser);
	}
	public boolean updateOneTea(TeacherUser teacherUser) {
		
		return teacherDao.updateOneTea(teacherUser);
	}
	
	public Integer findAllCount() {
		return teacherDao.findAllCount();
	}
	public List<TeacherUser> getList(int i, int j) {
		return teacherDao.getList(i,j);
	}
	public boolean delTea(Integer tid) {
		return teacherDao.delTea(tid);
	}
	public TeacherUser findOneTea(Integer tid) {
		return teacherDao.findOneTea(tid);
	}

}
