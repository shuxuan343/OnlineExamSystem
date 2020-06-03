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
import edu.zyb.exam.beans.TeacherUser;
import edu.zyb.exam.service.ClazzService;
import edu.zyb.exam.service.TeacherService;
/**
 * 班级管理
 * @author Administrator
 *
 */
@ParentPackage("json-default")//此注解可返回json数据
@Namespace("/clazzAction")//等同于struts.xml中的namespace节点
public class ClazzAction  extends ActionSupport implements ModelDriven<BJ>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ClazzService clazzService;
	@Autowired
	private TeacherService teacherService;
	private BJ bj = new BJ();
	
	private Integer tid ;//教师id
	private String bjids;//多个班级ID,删除时传参
	private Integer page;
	Map<String,Object> resultMap = new HashMap<String,Object>();
	/**
	 * 添加班级 struts全注解 ajax json前后台通讯
	 * @return
	 */
	@Action(value = "addCla",results = {
			@Result(type="json",params={"root","resultMap"})})
	public String addCla(){
		TeacherUser teacherUser = new TeacherUser();
		teacherUser.setTid(tid);
		bj.setTeacherUser(teacherUser);
		boolean isadd = clazzService.addCla(bj);
		if(isadd){
			resultMap.put("result", "SUCCESS");			
		}else
			resultMap.put("result", "FAILED");
		return SUCCESS;
	}
	/**
	 * 添加班级页面
	 * @return
	 */
	@Action(value = "addClaPage",results = {
            @Result(name = "success",location = "/clazzAdd.jsp"),
            @Result(name = "error",location = "/error.jsp")
    })
	public String addClaPage(){
		List<TeacherUser> teacherUsers = teacherService.findAllTea();
		ServletActionContext.getRequest().setAttribute("teacherUsers", teacherUsers);
		return SUCCESS;
	}
	/**
	 * 查询班级列表
	 * @return
	 */
	@Action(value = "findList",results = {
            @Result(name = "success",location = "/clazzList.jsp"),
            @Result(name = "error",location = "/error.jsp")
    })
	public String findList(){
		if(page == null)
			page = 1;
		Integer total = clazzService.findAllCount();//获取班级的总条数
		Integer totalPage = total/8;
		if(total%8!=0)
			totalPage+=1;
		List<BJ> list = clazzService.getList((page-1)*8,8);//根据当前页获取8条数据
		HttpServletRequest req = ServletActionContext.getRequest();
		List<TeacherUser> teacherUsers = teacherService.findAllTea();
		req.setAttribute("teacherUsers", teacherUsers);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("page", page);
		req.setAttribute("list", list);
		return SUCCESS;
	}
	/**
	 * ajax返回json，准备数据
	 * @return
	 * @throws IOException
	 */
	@Action(value = "editClaPage",results = {
            @Result(type="json",params={"root","resultMap"})})
	public String findOneCla() throws IOException{
		
		bj = clazzService.findOneCla(bj.getBjid());//查询一个班级实例
		
		if(bj!=null){
			resultMap.put("result", "SUCCESS");
			resultMap.put("bj", bj);
			
		}else
			resultMap.put("result", "FAILED");
		return SUCCESS;
	
	}
	/**
	 * 班级编辑后保存动作
	 * @return
	 * @throws IOException
	 */
	@Action(value = "editCla",results = {
            @Result(type="json",params={"root","resultMap"})})
	public String updateOneCla() throws IOException{
		TeacherUser teacherUser = new TeacherUser();
		teacherUser.setTid(tid);
		bj.setTeacherUser(teacherUser);
		boolean isupdate = clazzService.updateOneCla(bj);
		
		if(isupdate){
			resultMap.put("result", "SUCCESS");			
		}else
			resultMap.put("result", "FAILED");
		return SUCCESS;
	
	}
	/**
	 * 根据ID数组删除多个班级
	 * @return
	 */
	@Action(value = "delCla",results = {
            @Result(name = "success",location = "/clazzList.jsp"),
            @Result(name = "error",location = "/error.jsp")
    })
	public String delCla(){
		boolean isdel =false;
		
 		if(bjids!=null){
 			String []bjid = bjids.split(",");
			for(int i=0;i<bjid.length;i++){
				isdel = clazzService.delCla(Integer.parseInt(bjid[i]));
			}
 		}
		if(page == null)
			page = 1;
		Integer total = clazzService.findAllCount();
		Integer totalPage = total/8;
		if(total%8!=0)
			totalPage+=1;
		List<BJ> list = clazzService.getList((page-1)*8,8);
		HttpServletRequest req = ServletActionContext.getRequest();
		List<TeacherUser> teacherUsers = teacherService.findAllTea();
		req.setAttribute("teacherUsers", teacherUsers);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("page", page);
		req.setAttribute("list", list);
		if(isdel)
			return SUCCESS;
		else
			return ERROR;
			
	}
	
	
	
	

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public void setBjids(String bjids) {
		this.bjids = bjids;
	}
	
	public String getBjids() {
		return bjids;
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
	public BJ getModel() {
		return bj;
	}

}
