package edu.zyb.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zyb.exam.beans.Student;
import edu.zyb.exam.dao.StudentDao;
import edu.zyb.exam.service.StudentService;
@Service("studentService")
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	public Student login(String username, String password) {
		return studentDao.login(username,password);
	}
	public boolean addStu(Student student) {
		return studentDao.addStu(student);
	}
	public Integer findAllCount() {
		return studentDao.findAllCount();
	}
	public List<Student> getList(int i, int j) {
		return studentDao.getList(i,j);
	}
	public Student findOneStu(Integer sid) {
		return studentDao.findOneStu(sid);
	}
	public boolean updateOneStu(Student student) {
		return studentDao.updateOneStu(student);
	}
	public boolean delStu(Integer sid) {
		return studentDao.delStu(sid);
	}

}
