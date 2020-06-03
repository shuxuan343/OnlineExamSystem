package edu.zyb.exam.service;

import java.util.List;

import edu.zyb.exam.beans.TeacherUser;

public interface TeacherService {

	public TeacherUser login(String username, String password);

	public List<TeacherUser> findAllTea();

	public boolean addTea(TeacherUser teacherUser);

	public boolean updateOneTea(TeacherUser teacherUser);

	public Integer findAllCount();

	public List<TeacherUser> getList(int i, int j);

	public boolean delTea(Integer sid);

	public TeacherUser findOneTea(Integer tid);

}
