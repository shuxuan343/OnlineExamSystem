package edu.zyb.exam.dao;

import java.util.List;

import edu.zyb.exam.beans.Student;

public interface StudentDao {

	public Student login(String username, String password);

	public boolean addStu(Student student);

	public Integer findAllCount();

	public boolean delStu(Integer sid);

	public boolean updateOneStu(Student student);

	public Student findOneStu(Integer sid);

	public List<Student> getList(int i, int j);

}
