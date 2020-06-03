package edu.zyb.exam.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="qprelationq")
public class Relationpq {
	@Id
	@GeneratedValue
	private Integer rid;
	@ManyToOne(cascade=CascadeType.PERSIST,optional=true)
	@JoinColumn(name="qpid")
	private TestPaper testPaper;
	@OneToOne(fetch=FetchType.EAGER)//onotomany应设置为立即加载，否则在jsp中会报懒加载异常
	@JoinColumn(name="qid")
	private Question question;
	private Integer num;
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public TestPaper getTestPaper() {
		return testPaper;
	}
	public void setTestPaper(TestPaper testPaper) {
		this.testPaper = testPaper;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	
}
