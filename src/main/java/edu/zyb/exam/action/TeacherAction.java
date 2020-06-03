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

import edu.zyb.exam.beans.TeacherUser;
import edu.zyb.exam.service.TeacherService;
@ParentPackage("json-default")
@Namespace("/teacherAction")
public class TeacherAction  extends ActionSupport implements ModelDriven<TeacherUser>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private TeacherService teacherService;
	private TeacherUser teacherUser = new TeacherUser();
	private String tids ;
	private Integer page;
	Map<String,Object> resultMap = new HashMap<String,Object>();
	
	@Action(value = "addTea",results = {
			@Result(type="json",params={"root","resultMap"})})
	public String addTea(){
		teacherUser.setPassword("123456");
		boolean isadd = teacherService.addTea(teacherUser);
		if(isadd){
			resultMap.put("result", "SUCCESS");			
		}else
			resultMap.put("result", "FAILED");
		return SUCCESS;
	}
	
	@Action(value = "addTeaPage",results = {
            @Result(name = "success",location = "/teacherAdd.jsp"),
            @Result(name = "error",location = "/error.jsp")
    })
	public String addTeaPage(){
		return SUCCESS;
	}
	@Action(value = "findList",results = {
            @Result(name = "success",location = "/teacherList.jsp"),
            @Result(name = "error",location = "/error.jsp")
    })
	public String findList(){
		if(page == null)
			page = 1;
		Integer total = teacherService.findAllCount();
		Integer totalPage = total/8;
		if(total%8!=0)
			totalPage+=1;
		List<TeacherUser> list = teacherService.getList((page-1)*8,8);
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("page", page);
		req.setAttribute("list", list);
		return SUCCESS;
	}
	
	@Action(value = "editTeaPage",results = {
            @Result(type="json",params={"root","resultMap"})})
	public String findOneTea() throws IOException{
		
		teacherUser = teacherService.findOneTea(teacherUser.getTid());
		
		if(teacherUser!=null){
			resultMap.put("result", "SUCCESS");
			resultMap.put("teacherUser", teacherUser);
			
		}else
			resultMap.put("result", "FAILED");
		return SUCCESS;
	
	}
	@Action(value = "editTea",results = {
            @Result(type="json",params={"root","resultMap"})})
	public String updateOneTea() throws IOException{
		teacherUser.setPassword(teacherService.findOneTea(teacherUser.getTid()).getPassword());
		boolean isupdate = teacherService.updateOneTea(teacherUser);
		
		if(isupdate){
			resultMap.put("result", "SUCCESS");			
		}else
			resultMap.put("result", "FAILED");
		return SUCCESS;
	
	}
	@Action(value = "delTea",results = {
            @Result(name = "success",location = "/teacherList.jsp"),
            @Result(name = "error",location = "/teacherList.jsp")
    })
	public String delTea(){
		boolean isdel =false;
		if(tids!=null){
			String []tid = tids.split(",");
			for(int i=0;i<tid.length;i++){
				isdel = teacherService.delTea(Integer.parseInt(tid[i]));
			}
		}
		if(page == null)
			page = 1;
		Integer total = teacherService.findAllCount();
		Integer totalPage = total/8;
		if(total%8!=0)
			totalPage+=1;
		List<TeacherUser> list = teacherService.getList((page-1)*8,8);
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("page", page);
		req.setAttribute("list", list);
		if(isdel)
			return SUCCESS;
		else
			return ERROR;
			
	}
	
	public String getTids() {
		return tids;
	}

	public void setTids(String tids) {
		this.tids = tids;
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
	public TeacherUser getModel() {
		return teacherUser;
	}

}
