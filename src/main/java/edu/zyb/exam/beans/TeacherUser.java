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

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="teacheruser")
public class TeacherUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id

	@GeneratedValue(generator = "teatableGenerator")    
	@GenericGenerator(name = "teatableGenerator", strategy = "assigned") //程序自己定义主键，而非自动生成
	private Integer tid;
	@Column
	private String tname;
	@Column
	private String password;
	@Column
	private String phone;
	@Column
	private String email;
	@OneToMany(fetch=FetchType.EAGER)
	private Set<BJ> bjs = new HashSet<BJ>();
	
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public Set<BJ> getBjs() {
		return bjs;
	}
	public void setBjs(Set<BJ> bjs) {
		this.bjs = bjs;
	}


}
