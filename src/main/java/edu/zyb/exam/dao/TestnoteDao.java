package edu.zyb.exam.dao;

import java.util.List;

public interface TestnoteDao {

	public List<Object> queryTestonteStus(int i, int j, Integer tcid);

	public Integer findCountTestonteStus(Integer tcid);

	public Integer findCountTestonteStu(Integer qid);

	public List<Object> queryTestonteStu(int i, int j, Integer qid);

}
