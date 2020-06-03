package edu.zyb.exam.beans;

import java.util.ArrayList;
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

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(generator = "stutableGenerator")    
	@GenericGenerator(name = "stutableGenerator", strategy = "assigned") //程序自己定义主键，而非自动生成
	private Integer sid;
	@Column
	private String password;
	@Column
	private String name;
	@Column
	private String phone;
	@Column
	private String email;
	@ManyToOne(cascade=CascadeType.PERSIST,optional=true)
	@JoinColumn(name="bjid")
	private BJ bj;
	@OneToMany(fetch=FetchType.EAGER)
	private List<TestNote> testNotes = new ArrayList<TestNote>();
	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BJ getBj() {
		return bj;
	}
	public void setBj(BJ bj) {
		this.bj = bj;
	}
	public List<TestNote> getTestNotes() {
		return testNotes;
	}
	public void setTestNotes(List<TestNote> testNotes) {
		this.testNotes = testNotes;
	}
	

}
