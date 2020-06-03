package edu.zyb.exam.dao;

import java.util.List;

import edu.zyb.exam.beans.BJ;

public interface ClazzDao {

	public List<BJ> findAllCla();

	public boolean delCla(Integer bjid);

	public BJ findOneCla(Integer bjid);

	public boolean updateOneCla(BJ bj);

	public List<BJ> getList(int i, int j);

	public Integer findAllCount();

	public boolean addCla(BJ bj);

}
