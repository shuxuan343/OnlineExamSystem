package edu.zyb.exam.service;

import java.util.List;

import edu.zyb.exam.beans.Student;

public interface StudentService {

	public Student login(String username, String password);

	public boolean addStu(Student student);

	public Integer findAllCount();

	public List<Student> getList(int i, int j);

	public Student findOneStu(Integer sid);

	public boolean updateOneStu(Student student);

	public boolean delStu(Integer sid);
	
}
