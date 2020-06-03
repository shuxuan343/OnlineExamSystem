package edu.zyb.exam.dao;

import java.util.List;

import edu.zyb.exam.beans.Question;
import edu.zyb.exam.beans.Relationpq;
import edu.zyb.exam.beans.TestControl;
import edu.zyb.exam.beans.TestNote;
import edu.zyb.exam.beans.TestPaper;

public interface TestpaperDao {
	public void saveOrUpdate(TestPaper paper);

	public void saveRel(Relationpq relationpq);

	public List<Question> getQueListByQty(Integer qpid,Integer qtp);

	public void delRelQue(Integer qpid, Integer qid);

	public Integer findAllCount();

	public List<TestPaper> getList(int page, int limit);

	public void delTpp(Integer qpid);

	public TestPaper findOneTpp(Integer qpid);

	public void addTsc(TestControl control);
	
	public Integer findAllCountTsc(String tsctime);

	public List<TestControl> getListTsc(int page, int limit,String tsctime);

	public void delTsc(Integer tcid,String tsctime);

	public TestControl findOneTsc(Integer tcid);

	public void addTsn(TestNote testNote);
}
