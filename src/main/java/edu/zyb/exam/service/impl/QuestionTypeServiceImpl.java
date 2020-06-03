package edu.zyb.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zyb.exam.beans.Question;
import edu.zyb.exam.beans.QuestionType;
import edu.zyb.exam.dao.QuestionDao;
import edu.zyb.exam.dao.QuestionTypeDao;
import edu.zyb.exam.service.QuestionService;
import edu.zyb.exam.service.QuestionTypeService;
@Service("questionTypeService")
public class QuestionTypeServiceImpl implements QuestionTypeService {
	
	@Autowired
	private QuestionTypeDao questionTypeDao;

	public List<QuestionType> findAllQueTy() {
		return questionTypeDao.findAllQueTy();
	}

	public QuestionType getById(Integer qtid) {
		return questionTypeDao.getById(qtid);
	}
	
}
