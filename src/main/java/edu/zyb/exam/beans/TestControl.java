package edu.zyb.exam.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="testcontrol")
public class TestControl {
	@Id
	@GeneratedValue
	private Integer tcid;
	@Column
	private Date tdate;
	@ManyToOne(cascade=CascadeType.PERSIST,optional=true)
	@JoinColumn(name="qpid")
	private TestPaper testPaper;
	@OneToMany(fetch=FetchType.EAGER)
	private List<TestNote> testNotes = new ArrayList<TestNote>();
	public Integer getTcid() {
		return tcid;
	}
	public void setTcid(Integer tcid) {
		this.tcid = tcid;
	}
	public Date getTdate() {
		return tdate;
	}
	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}
	public TestPaper getTestPaper() {
		return testPaper;
	}
	public void setTestPaper(TestPaper testPaper) {
		this.testPaper = testPaper;
	}
	public List<TestNote> getTestNotes() {
		return testNotes;
	}
	public void setTestNotes(List<TestNote> testNotes) {
		this.testNotes = testNotes;
	}
	
	
	
}
