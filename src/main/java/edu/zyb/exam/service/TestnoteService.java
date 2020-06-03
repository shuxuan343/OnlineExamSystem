package edu.zyb.exam.service;

import java.util.List;

public interface TestnoteService {

	public List<Object> queryTestonteStus(int i, int j, Integer tcid);

	public Integer findCountTestonteStus(Integer tcid);
	
	public List<Object> queryTestonteStu(int i, int j, Integer qid);

	public Integer findCountTestonteStu(Integer qid);

}
