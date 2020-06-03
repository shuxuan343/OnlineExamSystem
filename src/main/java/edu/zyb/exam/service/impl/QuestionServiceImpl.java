package edu.zyb.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zyb.exam.beans.Question;
import edu.zyb.exam.dao.QuestionDao;
import edu.zyb.exam.service.QuestionService;
@Service("questionService")
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionDao questionDao;
	public Integer findAllCount(Integer queTyp) {
		return questionDao.findAllCount(queTyp);
	}

	public List<Question> getList(int page, int count,Integer queTyp) {
		return questionDao.getList(page, count,queTyp);
	}

	public boolean delQue(Integer qid) {
		return questionDao.delQue(qid);
	}

	public boolean addQue(Question question) {
		return questionDao.addQue(question);
	}

	public Question findOneQue(Integer integer) {
		return questionDao.findOneQue(integer);
	}

	public boolean updateOneQue(Question question) {
		return questionDao.updateOneQue(question);
	}

	public int queryJudge(String key, String value) {
		return questionDao.queryJudge(key,value);
	}

}
