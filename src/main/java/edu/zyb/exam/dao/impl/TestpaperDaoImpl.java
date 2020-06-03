package edu.zyb.exam.dao.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import edu.zyb.exam.beans.Question;
import edu.zyb.exam.beans.Relationpq;
import edu.zyb.exam.beans.TestControl;
import edu.zyb.exam.beans.TestNote;
import edu.zyb.exam.beans.TestPaper;
import edu.zyb.exam.dao.TestpaperDao;
@Repository("testpaperDao")
public class TestpaperDaoImpl implements TestpaperDao{

	@Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
	
	public void saveOrUpdate(TestPaper paper) {
		if(paper.getQpid()!=null){
			sessionFactory.getCurrentSession().update(paper);
		}else{
			sessionFactory.getCurrentSession().save(paper);
		}
	}
	
	public void saveRel(Relationpq relationpq) {
		sessionFactory.getCurrentSession().save(relationpq);
	}
	/**
	 * 根据题型查询试题列表的多表关联查询
	 */
	@SuppressWarnings("unchecked")
	public List<Question> getQueListByQty(Integer qpid,Integer qtp) {
		List<Question> objects = sessionFactory.getCurrentSession().createSQLQuery("select q.qid qid,q.qcontent qcontent,q.aoption aoption,q.boption boption,"
				+ "q.coption coption,q.doption doption from qprelationq r RIGHT JOIN question q on q.qid =r.qid "
				+ "LEFT JOIN questionpaper qp on qp.qpid=r.qpid where q.qtid = ? and qp.qpid =? ").setInteger(0,qtp).setInteger(1, qpid).setResultTransformer(Transformers.aliasToBean(Question.class)).list();
		return objects;
	}
	/**
	 * 删除一个试题，或者删除改试卷所有试题
	 */
	public void delRelQue(Integer qpid,Integer qid) {
		if(qid==null)
			sessionFactory.getCurrentSession().createSQLQuery("DELETE from qprelationq where qpid = ?").setInteger(0, qpid).executeUpdate();
		else
			sessionFactory.getCurrentSession().createSQLQuery("DELETE from qprelationq where qpid = ? and qid = ?").setInteger(0, qpid).setInteger(1, qid).executeUpdate();
	}
	
	public Integer findAllCount() {
		Object total = sessionFactory.getCurrentSession().createSQLQuery("select count(*) from questionpaper ").uniqueResult();
		return ((BigInteger) total).intValue();
	}
	/**
	 * 获取试卷列表
	 */
	@SuppressWarnings("unchecked")
	public List<TestPaper> getList(int page, int limit) {
		return sessionFactory.getCurrentSession().createQuery("from TestPaper ").setFirstResult(page).setMaxResults(limit).list();
	}
	/**
	 * 删除试卷
	 */
	public void delTpp(Integer qpid) {
		sessionFactory.getCurrentSession().createSQLQuery("DELETE from questionpaper where qpid = ?").setInteger(0, qpid).executeUpdate();
	}
	
	/**
	 * 根据试卷的id查询
	 */
	public TestPaper findOneTpp(Integer qpid) {
		return (TestPaper) sessionFactory.getCurrentSession().createQuery("from TestPaper where qpid=?").setInteger(0, qpid).list().get(0);
	}
	
	/**
	 * 添加考试计划
	 */
	public void addTsc(TestControl control) {
		sessionFactory.getCurrentSession().save(control);
	}
	
	/**
	 * 统计已考或未考计划数据量 
	 */
	public Integer findAllCountTsc(String tsctime) {
		if(tsctime.equals("aft")){
			Date date = new Date();
			BigInteger one = BigInteger.valueOf(date.getTime());
			BigInteger two = BigInteger.valueOf(20*60);
			two = two.multiply(BigInteger.valueOf(1000));
			date = new Date(one.subtract(two).longValue());
			Object total = sessionFactory.getCurrentSession().createSQLQuery("select  count(*) from testcontrol as tc where UNIX_TIMESTAMP(tc.tdate) >  ?").setTimestamp(0, date).uniqueResult();
			return ((BigInteger) total).intValue();
		}else{
			Object total = sessionFactory.getCurrentSession().createSQLQuery("select  count(*) from testcontrol as tc where UNIX_TIMESTAMP(tc.tdate) < UNIX_TIMESTAMP(NOW()) ").uniqueResult();
			return ((BigInteger) total).intValue();
		}
	}
	/**
	 * 查询已考或为考的考试计划列表
	 */
	@SuppressWarnings("unchecked")
	public List<TestControl> getListTsc(int page, int limit,String tsctime) {
		if(tsctime.equals("aft")){
			Date date = new Date();
			BigInteger one = BigInteger.valueOf(date.getTime());
			BigInteger two = BigInteger.valueOf(20*60);
			two = two.multiply(BigInteger.valueOf(1000));
			date = new Date(one.subtract(two).longValue());
			return sessionFactory.getCurrentSession().createQuery("from TestControl  where tdate>?").setTimestamp(0, date).setFirstResult(page).setMaxResults(limit).list();
		}else{
			return sessionFactory.getCurrentSession().createQuery("from TestControl  where tdate<?").setTimestamp(0, new Date()).setFirstResult(page).setMaxResults(limit).list();
		}
	}
	
	/**
	 * 删除考试计划
	 */
	public void delTsc(Integer tcid,String tsctime) {
			sessionFactory.getCurrentSession().createSQLQuery("DELETE from testcontrol where tcid = ?").setInteger(0, tcid).executeUpdate();
	}
	
	/**
	 * 查找一个考试计划
	 */
	public TestControl findOneTsc(Integer tcid) {
		return (TestControl) sessionFactory.getCurrentSession().createQuery("from TestControl where tcid=?").setInteger(0, tcid).list().get(0);
	}
	
	/**
	 * 添加学生考试交卷记录
	 */
	public void addTsn(TestNote testNote) {
		sessionFactory.getCurrentSession().save(testNote);
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
