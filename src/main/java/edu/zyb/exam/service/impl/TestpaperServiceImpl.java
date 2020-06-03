package edu.zyb.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zyb.exam.beans.Question;
import edu.zyb.exam.beans.Relationpq;
import edu.zyb.exam.beans.TestControl;
import edu.zyb.exam.beans.TestNote;
import edu.zyb.exam.beans.TestPaper;
import edu.zyb.exam.dao.TestpaperDao;
import edu.zyb.exam.service.TestpaperService;
@Service("testpaperService")
public class TestpaperServiceImpl implements TestpaperService {
	@Autowired
	private TestpaperDao testpaperDao;
	public void saveOrUpdate(TestPaper testPaper) {
		testpaperDao.saveOrUpdate(testPaper);
	}
	public void saveRel(Relationpq relationpq) {
		testpaperDao.saveRel(relationpq);
	}
	public List<Question> getQueListByQty(Integer qpid,Integer qtp) {
		return testpaperDao.getQueListByQty(qpid,qtp);
	}
	public void delRelQue(Integer qpid, Integer qid) {
		testpaperDao.delRelQue(qpid,qid);
	}
	public Integer findAllCount() {
		
		return testpaperDao.findAllCount();
	}
	public List<TestPaper> getList(int page, int limit) {
		return testpaperDao.getList(page,limit);
	}
	public void delTpp(Integer qpid) {
		testpaperDao.delTpp(qpid);
	}
	public TestPaper findOneTpp(Integer qpid) {
		return testpaperDao.findOneTpp(qpid);
	}
	public void addTsc(TestControl control) {
		testpaperDao.addTsc(control);
	}
	public Integer findAllCountTsc(String tsctime) {
		return testpaperDao.findAllCountTsc(tsctime);
	}
	public List<TestControl> getListTsc(int i, int j,String tsctime) {
		return testpaperDao.getListTsc(i,j,tsctime);
	}
	public void delTsc(Integer tcid,String tsctime) {
		testpaperDao.delTsc(tcid,tsctime);		
	}
	public TestControl findOneTsc(Integer tcid) {
		return testpaperDao.findOneTsc(tcid);
	}
	public void addTsn(TestNote testNote) {
		testpaperDao.addTsn(testNote);
		
	}

}
