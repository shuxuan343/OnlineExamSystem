package edu.zyb.exam.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
@Entity
@Table(name = "question")
public class Question implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer qid;		//试题id
	@Column
	private String qcontent;	//试题内容
	@Column
	private String aoption;		//选项a
	@Column
	private String boption;		//选项b
	@Column
	private String coption;		//选项c
	@Column
	private String doption;		//选项d
	@Column
	private String qanswer;		//答案
	@Column
	private String qanalysis;	//解析
	@Column
	private String oword;		//关键词
	@Column
	private String qscope;		//试题范围
	@Column
	private String qdifficulty; //试题难度
	@Column
	private Date qdate;			//试题添加日期
	@ManyToOne(cascade=CascadeType.PERSIST,optional=true)
	@JoinColumn(name="qtid")
	private QuestionType questionType = new QuestionType();	//试题类型
	@ManyToOne(cascade=CascadeType.PERSIST,optional=true)
	@JoinColumn(name="tid")
	private TeacherUser teacherUser = new TeacherUser();	//添加教师
	public Integer getQid() {
		return qid;
	}
	public void setQid(Integer qid) {
		this.qid = qid;
	}
	public String getQcontent() {
		return qcontent;
	}
	public void setQcontent(String qcontent) {
		this.qcontent = qcontent;
	}
	public String getAoption() {
		return aoption;
	}
	public void setAoption(String aoption) {
		this.aoption = aoption;
	}
	public String getBoption() {
		return boption;
	}
	public void setBoption(String boption) {
		this.boption = boption;
	}
	public String getCoption() {
		return coption;
	}
	public void setCoption(String coption) {
		this.coption = coption;
	}
	public String getDoption() {
		return doption;
	}
	public void setDoption(String doption) {
		this.doption = doption;
	}
	public String getQanswer() {
		return qanswer;
	}
	public void setQanswer(String qanswer) {
		this.qanswer = qanswer;
	}
	public String getQanalysis() {
		return qanalysis;
	}
	public void setQanalysis(String qanalysis) {
		this.qanalysis = qanalysis;
	}
	public String getOword() {
		return oword;
	}
	public void setOword(String oword) {
		this.oword = oword;
	}
	public String getQscope() {
		return qscope;
	}
	public void setQscope(String qscope) {
		this.qscope = qscope;
	}
	public String getQdifficulty() {
		return qdifficulty;
	}
	public void setQdifficulty(String qdifficulty) {
		this.qdifficulty = qdifficulty;
	}
	public Date getQdate() {
		return qdate;
	}
	public void setQdate(Date qdate) {
		this.qdate = qdate;
	}
	public QuestionType getQuestionType() {
		return questionType;
	}
	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}
	public TeacherUser getTeacherUser() {
		return teacherUser;
	}
	public void setTeacherUser(TeacherUser teacherUser) {
		this.teacherUser = teacherUser;
	}
	
	
}
