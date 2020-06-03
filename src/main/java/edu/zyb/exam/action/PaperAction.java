package edu.zyb.exam.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
import edu.zyb.exam.beans.Relationpq;
import edu.zyb.exam.beans.Student;
import edu.zyb.exam.beans.TeacherUser;
import edu.zyb.exam.beans.TestControl;
import edu.zyb.exam.beans.TestNote;
import edu.zyb.exam.beans.TestPaper;
import edu.zyb.exam.service.QuestionService;
import edu.zyb.exam.service.TeacherService;
import edu.zyb.exam.service.TestpaperService;

@ParentPackage("json-default")
@Namespace("/testpaperAction")
public class PaperAction extends ActionSupport implements ModelDriven<TestPaper>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired 
	private QuestionService questionService;
	@Autowired
	private TestpaperService testpaperService;
	@Autowired
	private TeacherService teacherService ;
	private TestPaper testPaper = new TestPaper();
	Map<String,Object> resultMap = new HashMap<String,Object>();
	private Integer page;
	private Integer queTyp;//问题类型id
	private String qids;//问题id数组，struts json无法处理，故字符串
	private Integer qid;//问题id
	private String qpids;//试卷id数组
	private String tdate;//考试时间
	private String tcids;//考试计划id数组
	private String tsctime;//考试之前与考试之后标识
	private Integer tcid;
	/**
	 * 添加试卷页面方法
	 * @return
	 */
	@Action(value = "addTppPage",results = {
            @Result(name = "success",location = "/testpaperAdd.jsp"),
            @Result(name = "error",location = "/error.jsp")
    })
	public String addTppPage(){
		
		return SUCCESS;
	}
	/**
	 * 查找题库通过题型
	 * @return
	 * @throws IOException
	 */
	@Action(value = "findQueByQty",results = {
            @Result(type="json",params={"root","resultMap"})})
	public String findQueByQty() throws IOException{
		if(page == null)
			page = 1;
		Integer total = questionService.findAllCount(queTyp);
		Integer totalPage = total/8;
		if(total%8!=0)
			totalPage+=1;
		
		List<Question> list = questionService.getList((page-1)*8,8,queTyp);
		if(list!=null&&list.size()>0){
			resultMap.put("result", "SUCCESS");	
			resultMap.put("list", list);
			resultMap.put("page", page);
			resultMap.put("totalPage", totalPage);
		}else
			resultMap.put("result", "FAILED");
		
		return SUCCESS;
	
	}
	/**
	 * 保存到数据库，生成试卷，保存题库的关联关系
	 * @return
	 */
	@Action(value = "batchAdd",results = {
            @Result(name = "success",location = "/testpaperAdd.jsp"),
            @Result(name = "error",location = "/error.jsp")
    })
	public String batchAdd(){
		if(qids!=null&&testPaper.getQpname()!=null&&testPaper.getTime()!=null){
			testPaper.setQpdate(new Date());
			TeacherUser teacherUser = (TeacherUser) getSession().getAttribute("TEA");
			String ids[] = qids.split(",");
			testPaper.setTeacherUser(teacherUser);
			testpaperService.saveOrUpdate(testPaper);//第一次为save,第n次为更新
			for(int i=0;i<ids.length;i++){
				Relationpq relationpq = new Relationpq();
				relationpq.setQuestion(questionService.findOneQue(Integer.parseInt((ids[i]))));
				relationpq.setTestPaper(testPaper);
				testpaperService.saveRel(relationpq);//保存关联关系
			}
			/**
			 * 查询关系表，回显考卷
			 */
			List<Question> list = testpaperService.getQueListByQty(testPaper.getQpid(),1);
			ServletActionContext.getRequest().setAttribute("listc", list);
			list = testpaperService.getQueListByQty(testPaper.getQpid(),2);
			ServletActionContext.getRequest().setAttribute("listi", list);
			list = testpaperService.getQueListByQty(testPaper.getQpid(),3);
			ServletActionContext.getRequest().setAttribute("listp", list);
			ServletActionContext.getRequest().setAttribute("testPaper", testPaper);
		}else
			return ERROR;
		return SUCCESS;
	}
	/**
	 * 添加过程中，可删除以保存的关联关系
	 * @return
	 */
	@Action(value = "delOneQue",results = {
            @Result(name = "success",location = "/testpaperAdd.jsp"),
            @Result(name = "error",location = "/error.jsp")
    })
	public String delOneQue(){
		if(qid!=null&&testPaper.getQpname()!=null&&testPaper.getTime()!=null){
			
			testpaperService.delRelQue(testPaper.getQpid(),qid);//根据id删除
			/**
			 * 查询关系表，回显考卷
			 */
			List<Question> list = testpaperService.getQueListByQty(testPaper.getQpid(),1);
			ServletActionContext.getRequest().setAttribute("listc", list);
			list = testpaperService.getQueListByQty(testPaper.getQpid(),2);
			ServletActionContext.getRequest().setAttribute("listi", list);
			list = testpaperService.getQueListByQty(testPaper.getQpid(),3);
			ServletActionContext.getRequest().setAttribute("listp", list);
			ServletActionContext.getRequest().setAttribute("testPaper", testPaper);
		}else
			return ERROR;
		return SUCCESS;
	}
	/**
	 * 查找所有添加的考卷
	 * @return
	 */
	@Action(value = "findList",results = {
            @Result(name = "success",location = "/testpaperList.jsp"),
            @Result(name = "error",location = "/error.jsp")
    })
	public String findList(){
		if(page==null)
			page = 1;
		Integer total = testpaperService.findAllCount();
		Integer totalPage = total/8;
		if(total%8!=0)
			totalPage+=1;
		List<TestPaper> list = testpaperService.getList((page-1)*8,8);
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("page", page);
		req.setAttribute("list", list);
		return SUCCESS;
	}
	/**
	 * 删除考卷,根据id
	 * @return
	 */
	@Action(value = "delTpp",results = {
            @Result(name = "success",location = "/testpaperList.jsp"),
            @Result(name = "error",location = "/error.jsp")
    })
	public String delTpp(){
		String qpid[] = qpids.split(",");
		for(int i=0;i<qpid.length;i++){
			testpaperService.delRelQue(Integer.parseInt(qpid[i]), null);//删除关联关系
			testpaperService.delTpp(Integer.parseInt(qpid[i]));//删除试卷表
		}
		
		if(page==null)
			page = 1;
		Integer total = testpaperService.findAllCount();
		Integer totalPage = total/8;
		if(total%8!=0)
			totalPage+=1;
		List<TestPaper> list = testpaperService.getList((page-1)*8,8);
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("page", page);
		req.setAttribute("list", list);
		return SUCCESS;
	}
	
	/**
	 * 查看一张试卷
	 * @return
	 */
	@Action(value = "findOneTpp",results = {
            @Result(name = "success",location = "/testpaper.jsp"),
            @Result(name = "error",location = "/error.jsp")
    })
	public String findOneTpp(){
		testPaper = testpaperService.findOneTpp(testPaper.getQpid());
		List<Question> list = testpaperService.getQueListByQty(testPaper.getQpid(),1);
		ServletActionContext.getRequest().setAttribute("listc", list);
		list = testpaperService.getQueListByQty(testPaper.getQpid(),2);
		ServletActionContext.getRequest().setAttribute("listi", list);
		list = testpaperService.getQueListByQty(testPaper.getQpid(),3);
		ServletActionContext.getRequest().setAttribute("listp", list);
		ServletActionContext.getRequest().setAttribute("testPaper", testPaper);
		
		return SUCCESS;
	}
	/**
	 * 对生成的考卷，添加考试计划
	 * @return
	 */
	@Action(value = "addTsc",results = {
            @Result(type="json",params={"root","resultMap"})})
	public String addTsc(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date;
		try {
			date = format.parse(tdate);//计划时间
		
			TestControl control = new TestControl();
			control.setTdate(date);
			testPaper = testpaperService.findOneTpp(testPaper.getQpid());
			control.setTestPaper(testPaper);
			testpaperService.addTsc(control);//添加到考试计划表
			resultMap.put("result", "SUCCESS");
			return SUCCESS;
		} catch (ParseException e) {
			resultMap.put("result", "FAILED");
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/**
	 * 查询考试计划列表，已完成和未完成
	 * @return
	 */
	@Action(value = "findListTsc",results = {
            @Result(name = "success",location = "/testcontrolList.jsp"),
            @Result(name = "error",location = "/error.jsp")
    })
	public String findListTsc(){
		if(page==null)
			page = 1;
		//aft为计划的; bef为已经进行了的 
		Integer total = testpaperService.findAllCountTsc(tsctime);
		Integer totalPage = total/8;
		if(total%8!=0)
			totalPage+=1;
		List<TestControl> list = testpaperService.getListTsc((page-1)*8,8,tsctime);
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("page", page);
		req.setAttribute("list", list);
		req.setAttribute("tsctime", tsctime);
		return SUCCESS;
	}
	
	/**
	 * 删除计划
	 * @return
	 */
	@Action(value = "delTsc",results = {
            @Result(name = "success",location = "/testcontrolList.jsp"),
            @Result(name = "error",location = "/error.jsp")
    })
	public String delTsc(){
		String tcid[] = tcids.split(",");
		for(int i=0;i<tcid.length;i++){
			testpaperService.delTsc(Integer.parseInt(tcid[i]),tsctime);
		}
		
		if(page==null)
			page = 1;
		Integer total = testpaperService.findAllCountTsc(tsctime);
		Integer totalPage = total/8;
		if(total%8!=0)
			totalPage+=1;
		List<TestControl> list = testpaperService.getListTsc((page-1)*8,8,tsctime);
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("page", page);
		req.setAttribute("list", list);
		req.setAttribute("tsctime", tsctime);
		return SUCCESS;
	}
	
	/**
	 * 学生考试
	 * @return
	 */
	@Action(value = "startOneTsc",results = {
            @Result(name = "success",location = "/starttestpaper.jsp"),
            @Result(name = "error",location = "/error.jsp")
    })
	public String startOneTsc(){
		TestControl testControl = testpaperService.findOneTsc(tcid);
		testPaper = testControl.getTestPaper();
		List<Question> list = testpaperService.getQueListByQty(testPaper.getQpid(),1);
		ServletActionContext.getRequest().setAttribute("listc", list);
		list = testpaperService.getQueListByQty(testPaper.getQpid(),2);
		ServletActionContext.getRequest().setAttribute("listi", list);
		list = testpaperService.getQueListByQty(testPaper.getQpid(),3);
		ServletActionContext.getRequest().setAttribute("listp", list);
		ServletActionContext.getRequest().setAttribute("testPaper", testPaper);
		ServletActionContext.getRequest().setAttribute("tcid", tcid);
		
		return SUCCESS;
	}
	/**
	 * 提交考卷，自动生成分数
	 * @return
	 */
	@Action(value = "subOneTsc",results = {
            @Result(name = "success",location = "/starttestpaper.jsp"),
            @Result(name = "error",location = "/error.jsp")
    })
	public String subOneTsc(){
		
		Student student = (Student) getSession().getAttribute("STU");
		if(student!=null){
			TestControl testControl = testpaperService.findOneTsc(tcid);
			testPaper = testControl.getTestPaper();
			
			Map<String, String[]> keyMap = new HashMap<String, String[]>();
	        keyMap = ServletActionContext.getRequest().getParameterMap();
	        Iterator<Map.Entry<String, String[]>> it2 = keyMap.entrySet().iterator();
	        int totalScore = 0;
	        int score = 0;
	        while(it2.hasNext()){
	        	 Map.Entry<String, String[]> entry = it2.next();
	             String keyStr = entry.getKey();
	             String values[] = entry.getValue();
	             String key;
	             String value = "";
	             if(keyStr.split("-").length!=3)
	            	 continue;
	             if (keyStr.split("-")[1].equals("c")||keyStr.split("-")[1].equals("i")||keyStr.split("-")[1].equals("p")) {//单选c 判断i 程序题p
	            	 key = keyStr.split("-")[2];
	                 value = values[0];
	                 score += questionService.queryJudge(key, value);//对比答案，获取分数
	                 totalScore += questionService.findOneQue(Integer.parseInt(key)).getQuestionType().getScore();
	             }
	             
	        }
			TestNote testNote = new TestNote();
			testNote.setTestControl(testControl);
			testNote.setScore(score);
			testNote.setTscore(totalScore);
			testNote.setStudent(student);
			testpaperService.addTsn(testNote);//记录考试分数
		}else
			return ERROR;
		return SUCCESS;
	}
	
	
	
	public TestPaper getModel() {
		return testPaper;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getQueTyp() {
		return queTyp;
	}

	public void setQueTyp(Integer queTyp) {
		this.queTyp = queTyp;
	}

	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	
	public String getQids() {
		return qids;
	}

	public void setQids(String qids) {
		this.qids = qids;
	}
	
	public Integer getQid() {
		return qid;
	}

	public void setQid(Integer qid) {
		this.qid = qid;
	}
	

	public String getQpids() {
		return qpids;
	}

	public void setQpids(String qpids) {
		this.qpids = qpids;
	}
	
	public String getTdate() {
		return tdate;
	}

	public void setTdate(String tdate) {
		this.tdate = tdate;
	}
	
	public String getTcids() {
		return tcids;
	}

	public void setTcids(String tcids) {
		this.tcids = tcids;
	}

	public String getTsctime() {
		return tsctime;
	}

	public void setTsctime(String tsctime) {
		this.tsctime = tsctime;
	}
	

	public Integer getTcid() {
		return tcid;
	}

	public void setTcid(Integer tcid) {
		this.tcid = tcid;
	}

	private HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
	}
}
