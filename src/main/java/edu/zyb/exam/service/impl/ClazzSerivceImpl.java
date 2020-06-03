package edu.zyb.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zyb.exam.beans.BJ;
import edu.zyb.exam.dao.ClazzDao;
import edu.zyb.exam.service.ClazzService;
@Service("clazzService")
public class ClazzSerivceImpl implements ClazzService {
	
	@Autowired
	private ClazzDao clazzDao;
	public boolean addCla(BJ bj) {

		return clazzDao.addCla(bj);
	}

	public Integer findAllCount() {
		return clazzDao.findAllCount();
	}

	public List<BJ> getList(int i, int j) {
		return clazzDao.getList(i,j);
	}

	public boolean updateOneCla(BJ bj) {
		return clazzDao.updateOneCla(bj);
	}

	public BJ findOneCla(Integer bjid) {
		return clazzDao.findOneCla(bjid);
	}

	public boolean delCla(Integer bjid) {
		return clazzDao.delCla(bjid);
	}

	public List<BJ> findAllCla() {
		return clazzDao.findAllCla();
	}

}
