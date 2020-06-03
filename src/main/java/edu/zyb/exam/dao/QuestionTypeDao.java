package edu.zyb.exam.dao;

import java.util.List;

import edu.zyb.exam.beans.QuestionType;

public interface QuestionTypeDao {

	public List<QuestionType> findAllQueTy();

	public QuestionType getById(Integer qtid);

}
