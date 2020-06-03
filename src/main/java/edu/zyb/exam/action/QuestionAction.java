package edu.zyb.exam.action;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.zyb.exam.beans.Question;
import edu.zyb.exam.beans.QuestionType;
import edu.zyb.exam.beans.TeacherUser;
import edu.zyb.exam.service.QuestionService;
import edu.zyb.exam.service.QuestionTypeService;
import edu.zyb.exam.service.TeacherService;
//@ParentPackage("struts-default")
@ParentPackage("json-default")
@Namespace("/questionAction")
public class QuestionAction extends ActionSupport implements ModelDriven<Question>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private QuestionTypeService questionTypeService;
	private Integer qtid;
	private String qids;
	private Integer page;
	Map<String,Object> resultMap = new HashMap<String,Object>();
	
	
	private Question question = new Question();
	
	public Question getModel() {
		return question;
	}
	/**
	 * 添加题
	 * @return
	 */
	@Action(value = "addQue",results = {
			@Result(type="json",params={"root","resultMap"})})
	public String addQue(){
		TeacherUser tuser = (TeacherUser) getSession().getAttribute("TEA");
		if(tuser!=null){
			question.setTeacherUser(tuser);
			question.setQuestionType(questionTypeService.getById(qtid));
			question.setQdate(new Date());
			boolean isadd = questionService.addQue(question);
			if(isadd){
				resultMap.put("result", "SUCCESS");			
			}else
				resultMap.put("result", "FAILED");
		}else
			resultMap.put("result", "FAILED");
		return SUCCESS;
	}
	/**
	 * 进入添加试题界面方法
	 * @return
	 */
	@Action(value = "addQuePage",results = {
            @Result(name = "success",location = "/questionAdd.jsp"),
            @Result(name = "error",location = "/error.jsp")
    })
	public String addQuePage(){
		List<QuestionType> questionTypes = questionTypeService.findAllQueTy();
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("questionTypes", questionTypes);
		return SUCCESS;
	}
	
	/**
	 * 查询问题列表
	 * @return
	 */
	@Action(value = "findList",results = {
            @Result(name = "success",location = "/questionList.jsp"),
            @Result(name = "error",location = "/error.jsp")
    })
	public String findList(){
		if(page == null)
			page = 1;
		Integer total = questionService.findAllCount(null);
		Integer totalPage = total/8;
		if(total%8!=0)
			totalPage+=1;
		List<Question> list = questionService.getList((page-1)*8,8,null);
		List<TeacherUser> teacherUsers = teacherService.findAllTea();
		List<QuestionType> questionTypes = questionTypeService.findAllQueTy();
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("teacherUsers", teacherUsers);
		req.setAttribute("questionTypes", questionTypes);
		req.setAttribute("page", page);
		req.setAttribute("list", list);
		return SUCCESS;
	}
	/**
	 * 编辑问题页面
	 * @return
	 * @throws IOException
	 */
	@Action(value = "editQuePage",results = {
            @Result(type="json",params={"root","resultMap"})})
	public String findOneQue() throws IOException{
		
		question = questionService.findOneQue(question.getQid());
		
		if(question!=null){
			resultMap.put("result", "SUCCESS");
			resultMap.put("question", question);
			
		}else
			resultMap.put("result", "FAILED");
		return SUCCESS;
	
	}
	
	/**
	 * 保存编辑
	 * @return
	 * @throws IOException
	 */
	@Action(value = "editQue",results = {
            @Result(type="json",params={"root","resultMap"})})
	public String updateOneQue() throws IOException{
		TeacherUser tuser = (TeacherUser) getSession().getAttribute("TEA");
		if(tuser!=null){
			question.setTeacherUser(tuser);
			question.setQuestionType(questionTypeService.getById(qtid));
			question.setQdate(new Date());
			boolean isupdate = questionService.updateOneQue(question);
			
			if(isupdate){
				resultMap.put("result", "SUCCESS");			
			}else
				resultMap.put("result", "FAILED");
		}else
			resultMap.put("result", "FAILED");
		return SUCCESS;
	
	}
	/**
	 * 删除试题
	 * @return
	 */
	@Action(value = "delQue",results = {
            @Result(name = "success",location = "/questionList.jsp"),
            @Result(name = "error",location = "/questionList.jsp")
    })
	public String delQue(){
		boolean isdel =false;
		if(qids!=null){
			String qid[] = qids.split(",");
			for(int i=0;i<qid.length;i++){
				isdel = questionService.delQue(Integer.parseInt(qid[i]));
			}
		}
		if(page == null)
			page = 1;
		Integer total = questionService.findAllCount(null);
		Integer totalPage = total/8;
		if(total%8!=0)
			totalPage+=1;
		List<Question> list = questionService.getList((page-1)*8,8,null);
		List<TeacherUser> teacherUsers = teacherService.findAllTea();
		List<QuestionType> questionTypes = questionTypeService.findAllQueTy();
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("teacherUsers", teacherUsers);
		req.setAttribute("questionTypes", questionTypes);
		req.setAttribute("page", page);
		req.setAttribute("list", list);
		if(isdel)
			return SUCCESS;
		else
			return ERROR;
			
	}

	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getQtid() {
		return qtid;
	}

	public void setQtid(Integer qtid) {
		this.qtid = qtid;
	}

	public String getQids() {
		return qids;
	}
	
	public void setQids(String qids) {
		this.qids = qids;
	}
	private HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
	}
}
