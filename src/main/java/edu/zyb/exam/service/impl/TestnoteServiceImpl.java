package edu.zyb.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zyb.exam.beans.Question;
import edu.zyb.exam.dao.TestnoteDao;
import edu.zyb.exam.service.TestnoteService;
@Service("testnoteService")
public class TestnoteServiceImpl implements TestnoteService{
	@Autowired
	private TestnoteDao testnoteDao;

	public List<Object> queryTestonteStus(int i, int j, Integer tcid) {
		return testnoteDao.queryTestonteStus(i,j,tcid);
	}

	public Integer findCountTestonteStus(Integer tcid) {
		return testnoteDao.findCountTestonteStus(tcid);
	}

	public List<Object> queryTestonteStu(int i, int j, Integer qid) {
		return testnoteDao.queryTestonteStu(i,j,qid);
	}

	public Integer findCountTestonteStu(Integer qid) {
		return testnoteDao.findCountTestonteStu(qid);
	}
	
}
