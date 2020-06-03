package edu.zyb.exam.beans;

import java.util.HashSet;
import java.util.Set;

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
@Table(name = "bj")
public class BJ {

	@Id
	@GeneratedValue
	private Integer bjid;
	@Column
	private String bjname;
	@ManyToOne(cascade=CascadeType.PERSIST,optional=true)
	@JoinColumn(name="tid")
	private TeacherUser teacherUser;
	@OneToMany(fetch=FetchType.EAGER)//onotomany应设置为立即加载，否则在jsp中会报懒加载异常
	private Set<Student> students = new HashSet<Student>();
	
	public Integer getBjid() {
		return bjid;
	}

	public void setBjid(Integer bjid) {
		this.bjid = bjid;
	}

	public String getBjname() {
		return bjname;
	}

	public void setBjname(String bjname) {
		this.bjname = bjname;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public TeacherUser getTeacherUser() {
		return teacherUser;
	}

	public void setTeacherUser(TeacherUser teacherUser) {
		this.teacherUser = teacherUser;
	}

	
	
}
