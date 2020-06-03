package edu.zyb.exam.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="testnote")
public class TestNote {
	@Id
	@GeneratedValue
	private Integer tnid;
	@Column
	private Integer score;
	@Column
	private Integer tscore;
	@ManyToOne(cascade=CascadeType.PERSIST,optional=true)
	@JoinColumn(name="sid")
	private Student student;
	@ManyToOne(cascade=CascadeType.PERSIST,optional=true)
	@JoinColumn(name="tcid")
	private TestControl testControl;
	public Integer getTnid() {
		return tnid;
	}
	public void setTnid(Integer tnid) {
		this.tnid = tnid;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getTscore() {
		return tscore;
	}
	public void setTscore(Integer tscore) {
		this.tscore = tscore;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public TestControl getTestControl() {
		return testControl;
	}
	public void setTestControl(TestControl testControl) {
		this.testControl = testControl;
	}
	
	

}
