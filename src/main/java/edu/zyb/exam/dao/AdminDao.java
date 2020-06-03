package edu.zyb.exam.dao;

import edu.zyb.exam.beans.AdminUser;

public interface AdminDao {

	public AdminUser login(String username, String password);

}
