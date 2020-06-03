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
@Table(name="questionpaper")
public class TestPaper {
	@Id
	@GeneratedValue
	private Integer qpid;
	@Column
	private String qpname;
	@Column
	private Date qpdate;
	@Column
	private Integer time;
	@ManyToOne(cascade=CascadeType.PERSIST,optional=true)
	@JoinColumn(name="tid")
	private TeacherUser teacherUser;
	@OneToMany(fetch=FetchType.EAGER)
	private List<Relationpq> relationpqs = new ArrayList<Relationpq>();
	@OneToMany(fetch=FetchType.EAGER)
	private List<TestControl> controls = new ArrayList<TestControl>();
	
	
	public TestPaper() {
		super();
	}
	public TestPaper(Integer qpid, String qpname, Date qpdate, Integer time,
			TeacherUser teacherUser, List<Relationpq> relationpqs) {
		super();
		this.qpid = qpid;
		this.qpname = qpname;
		this.qpdate = qpdate;
		this.time = time;
		this.teacherUser = teacherUser;
		this.relationpqs = relationpqs;
	}
	public Integer getQpid() {
		return qpid;
	}
	public void setQpid(Integer qpid) {
		this.qpid = qpid;
	}
	public String getQpname() {
		return qpname;
	}
	public void setQpname(String qpname) {
		this.qpname = qpname;
	}
	public Date getQpdate() {
		return qpdate;
	}
	public void setQpdate(Date qpdate) {
		this.qpdate = qpdate;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	public TeacherUser getTeacherUser() {
		return teacherUser;
	}
	public void setTeacherUser(TeacherUser teacherUser) {
		this.teacherUser = teacherUser;
	}
	public List<Relationpq> getRelationpqs() {
		return relationpqs;
	}
	public void setRelationpqs(List<Relationpq> relationpqs) {
		this.relationpqs = relationpqs;
	}
	public List<TestControl> getControls() {
		return controls;
	}
	public void setControls(List<TestControl> controls) {
		this.controls = controls;
	}
	
}
