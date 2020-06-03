package edu.zyb.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zyb.exam.beans.AdminUser;
import edu.zyb.exam.dao.AdminDao;
import edu.zyb.exam.service.AdminService;
@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;
	public AdminUser login(String username, String password) {
		return adminDao.login(username,password);
	}

}
