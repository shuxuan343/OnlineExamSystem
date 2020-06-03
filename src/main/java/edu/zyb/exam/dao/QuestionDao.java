package edu.zyb.exam.dao;

import java.util.List;

import edu.zyb.exam.beans.Question;

public interface QuestionDao {

	public Integer findAllCount(Integer queTyp);

	public List<Question> getList(int page, int count,Integer queTyp);

	public boolean delQue(Integer qid);

	public boolean addQue(Question question);

	public Question findOneQue(Integer integer);

	public boolean updateOneQue(Question question);

	public int queryJudge(String key, String value);

}
