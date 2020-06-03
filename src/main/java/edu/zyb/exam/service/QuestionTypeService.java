package edu.zyb.exam.service;

import java.util.List;

import edu.zyb.exam.beans.QuestionType;

public interface QuestionTypeService {

	public List<QuestionType> findAllQueTy();

	public QuestionType getById(Integer qtid);

}
