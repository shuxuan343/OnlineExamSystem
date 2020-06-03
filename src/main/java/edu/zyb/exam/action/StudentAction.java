package edu.zyb.exam.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.zyb.exam.beans.BJ;
import edu.zyb.exam.beans.Student;
import edu.zyb.exam.service.ClazzService;
import edu.zyb.exam.service.StudentService;
@ParentPackage("json-default")
@Namespace("/studentAction")
public class StudentAction  extends ActionSupport implements ModelDriven<Student>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private ClazzService clazzService;
	private Student student = new Student();
	private Integer bjid;
	private String sids;
	private Integer page;
	Map<String,Object> resultMap = new HashMap<String,Object>();
	
	@Action(value = "addStu",results = {
			@Result(type="json",params={"root","resultMap"})})
	public String addQue(){
		BJ bj = new BJ();
		bj.setBjid(bjid);
		student.setBj(bj);
		student.setPassword("123456");
		boolean isadd = studentService.addStu(student);
		if(isadd){
			resultMap.put("result", "SUCCESS");			
		}else
			resultMap.put("result", "FAILED");
		return SUCCESS;
	}
	
	@Action(value = "addStuPage",results = {
            @Result(name = "success",location = "/studentAdd.jsp"),
            @Result(name = "error",location = "/error.jsp")
    })
	public String addStuPage(){
		List<BJ> bjs = clazzService.findAllCla();
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("bjs", bjs);
		return SUCCESS;
	}
	@Action(value = "findList",results = {
            @Result(name = "success",location = "/studentList.jsp"),
            @Result(name = "error",location = "/error.jsp")
    })
	public String findList(){
		if(page == null)
			page = 1;
		Integer total = studentService.findAllCount();
		Integer totalPage = total/8;
		if(total%8!=0)
			totalPage+=1;
		List<Student> list = studentService.getList((page-1)*8,8);
		HttpServletRequest req = ServletActionContext.getRequest();
		List<BJ> bjs = clazzService.findAllCla();
		req.setAttribute("bjs", bjs);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("page", page);
		req.setAttribute("list", list);
		return SUCCESS;
	}
	
	@Action(value = "editStuPage",results = {
            @Result(type="json",params={"root","resultMap"})})
	public String findOneStu() throws IOException{
		
		student = studentService.findOneStu(student.getSid());
		
		if(student!=null){
			resultMap.put("result", "SUCCESS");
			resultMap.put("student", student);
			
		}else
			resultMap.put("result", "FAILED");
		return SUCCESS;
	
	}
	@Action(value = "editStu",results = {
            @Result(type="json",params={"root","resultMap"})})
	public String updateOneStu() throws IOException{
		BJ bj = new BJ();
		bj.setBjid(bjid);
		student.setBj(bj);
		student.setPassword(studentService.findOneStu(student.getSid()).getPassword());
		boolean isupdate = studentService.updateOneStu(student);
		
		if(isupdate){
			resultMap.put("result", "SUCCESS");			
		}else
			resultMap.put("result", "FAILED");
		return SUCCESS;
	
	}
	@Action(value = "delStu",results = {
            @Result(name = "success",location = "/studentList.jsp"),
            @Result(name = "error",location = "/error.jsp")
    })
	public String delStu(){
		boolean isdel =false;
		if(sids!=null){
			String[] sid = sids.split(",");
			for(int i=0;i<sid.length;i++){
				isdel = studentService.delStu(Integer.parseInt(sid[i]));
			}	
		}
		if(page == null)
			page = 1;
		Integer total = studentService.findAllCount();
		Integer totalPage = total/8;
		if(total%8!=0)
			totalPage+=1;
		List<Student> list = studentService.getList((page-1)*8,8);
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("page", page);
		req.setAttribute("list", list);
		if(isdel)
			return SUCCESS;
		else
			return ERROR;
			
	}
	
	public String getSids() {
		return sids;
	}

	public void setSids(String sids) {
		this.sids = sids;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	public Student getModel() {
		return student;
	}

	public Integer getBjid() {
		return bjid;
	}

	public void setBjid(Integer bjid) {
		this.bjid = bjid;
	}

}
