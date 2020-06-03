package edu.zyb.exam.dao;

import java.util.List;

import edu.zyb.exam.beans.TeacherUser;

public interface TeacherDao {

	public TeacherUser login(String username, String password);

	public List<TeacherUser> findAllTea();

	public boolean addTea(TeacherUser teacherUser);

	public boolean updateOneTea(TeacherUser teacherUser);

	public Integer findAllCount();

	public TeacherUser findOneTea(Integer tid);

	public boolean delTea(Integer tid);

	public List<TeacherUser> getList(int i, int j);

}
