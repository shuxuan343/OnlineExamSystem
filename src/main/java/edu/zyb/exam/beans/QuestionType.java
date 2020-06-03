package edu.zyb.exam.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="questiontype")
public class QuestionType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue
	@Id
	private Integer qtid;    //试题类型id
	@Column
	private String qtname;	 //试题类型名称
	@Column
	private Integer score;	 //试题类型分数
	@OneToMany(fetch=FetchType.EAGER)//onotomany应设置为立即加载，否则在jsp中会报懒加载异常
	private Set<Question> questions = new HashSet<Question>();
	public Integer getQtid() {
		return qtid;
	}
	public void setQtid(Integer qtid) {
		this.qtid = qtid;
	}
	public String getQtname() {
		return qtname;
	}
	public void setQtname(String qtname) {
		this.qtname = qtname;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Set<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}	
	
	
}
