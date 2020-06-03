package edu.zyb.exam.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import edu.zyb.exam.beans.Student;
import edu.zyb.exam.beans.TestNote;
import edu.zyb.exam.service.TestnoteService;

@ParentPackage("json-default")
@Namespace("/testnoteAction")
public class TestnoteAction extends ActionSupport implements ModelDriven<TestNote>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private TestnoteService testnoteService;
	private TestNote testNote = new TestNote();
	Map<String,Object> resultMap = new HashMap<String,Object>();
	private Integer page;
	private Integer tcid;
	
	@Action(value = "queryTestonteStus",results = {
            @Result(name = "success",location = "/testnotestudents.jsp"),
            @Result(name = "error",location = "/error.jsp")
    })
	public String queryTestonteStus() throws IOException{
		if(page == null)
			page = 1;
		Integer total = testnoteService.findCountTestonteStus(tcid);
		Integer totalPage = total/8;
		if(total%8!=0)
			totalPage+=1;
		
		List<Object> list = testnoteService.queryTestonteStus((page-1)*8,8,tcid);
		
		ServletActionContext.getRequest().setAttribute("list", list);
		ServletActionContext.getRequest().setAttribute("page", page);
		ServletActionContext.getRequest().setAttribute("totalPage", totalPage);
		return SUCCESS;
	
	}
	@Action(value = "queryTestonteStu",results = {
            @Result(name = "success",location = "/testnotestudent.jsp"),
            @Result(name = "error",location = "/error.jsp")
    })
	public String queryTestonteStu() throws IOException{
		Student student = (Student) getSession().getAttribute("STU");
		if(student!=null){
			if(page == null)
				page = 1;
			Integer total = testnoteService.findCountTestonteStu(student.getSid());
			Integer totalPage = total/8;
			if(total%8!=0)
				totalPage+=1;
			
			List<Object> list = testnoteService.queryTestonteStu((page-1)*8,8,student.getSid());
			ServletActionContext.getRequest().setAttribute("list", list);
			ServletActionContext.getRequest().setAttribute("page", page);
			ServletActionContext.getRequest().setAttribute("totalPage", totalPage);
		}else
			return ERROR;
		return SUCCESS;
	
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

	public Integer getTcid() {
		return tcid;
	}

	public void setTcid(Integer tcid) {
		this.tcid = tcid;
	}

	public TestNote getModel() {
		return testNote;
	}
	private HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
	}
	

}
