package edu.zyb.exam.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.zyb.exam.beans.AdminUser;
import edu.zyb.exam.beans.Student;
import edu.zyb.exam.beans.TeacherUser;
import edu.zyb.exam.service.AdminService;
import edu.zyb.exam.service.StudentService;
import edu.zyb.exam.service.TeacherService;
@ParentPackage("struts-default")
@Namespace("/loginAction")
public class LoginAction extends ActionSupport implements ModelDriven{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private StudentService studentService; 
	@Autowired
	private AdminService adminService; 
	@Autowired
	private TeacherService teacherService; 
	private String password;
	private String username;
	private String logintype;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLogintype() {
		return logintype;
	}
	public void setLogintype(String logintype) {
		this.logintype = logintype;
	}
	/**
	 * 登陆入口
	 * @return
	 */
	@Action(value="toLogin",results = {
            @Result(name = "success",location = "/login.jsp")
    })
	public String toLogin(){
		
		return SUCCESS;
	}
	@Action(value = "login",results = {
            @Result(name = "success",location = "/index.jsp"),
            @Result(name = "error",location = "/login.jsp")
    })
	/**
	 * 登陆校验
	 * @return
	 */
	public String login(){
		if(logintype==null)
			return ERROR;
		if(logintype.equals("stu")){//学生
			Student student = studentService.login(username,password);
			if(student==null){
				ServletActionContext.getRequest().setAttribute("errinfo", "用户名或密码错误！");
				return ERROR;
			}else{
				getSession().setAttribute("STU", student);
			}
		}else if(logintype.equals("tea")){//教师
			TeacherUser teacher = teacherService.login(username,password);
			if(teacher==null){
				ServletActionContext.getRequest().setAttribute("errinfo", "用户名或密码错误！");
				return ERROR;
			}else{
				getSession().setAttribute("TEA", teacher);
			}
		}else if(logintype.equals("adm")){
			AdminUser admin = adminService.login(username,password);
			if(admin==null){
				ServletActionContext.getRequest().setAttribute("errinfo", "用户名或密码错误！");
				return ERROR;
			}else{
				getSession().setAttribute("ADM", admin);
			}
		}
		return SUCCESS;
	}
	/**
	 * 查看个人信息
	 * @return
	 */
	@Action(value="profilePage",results = {
            @Result(name = "success",location = "/profilePage.jsp")
    })
	public String profilePage(){
		
		return SUCCESS;
	}
	
	/**
	 * 密码修改页面
	 * @return
	 */
	@Action(value="editpwdPage",results = {
            @Result(name = "success",location = "/editpwdPage.jsp")
    })
	public String editpwdPage(){
		
		return SUCCESS;
	}
	/**
	 * 密码修改保存
	 * @return
	 */
	@Action(value="editpwd",results = {
            @Result(name = "success",location = "/editpwdPage.jsp")    })
	public String editpwd(){
		String edittype = ServletActionContext.getRequest().getParameter("edittype");
		String old = ServletActionContext.getRequest().getParameter("oldpwd");
		String newp = ServletActionContext.getRequest().getParameter("newpwd");
		String confirm = ServletActionContext.getRequest().getParameter("confirmpwd");
		if(edittype.equals("stu")){
			Student student = (Student) getSession().getAttribute("STU");
			if(student.getPassword().equals(old)&&newp.equals(confirm)&&!old.equals(newp)){
				student.setPassword(newp);
				studentService.updateOneStu(student);
				getSession().setAttribute("STU", student);
				return SUCCESS;
			}
		}else{
			TeacherUser teacherUser = (TeacherUser) getSession().getAttribute("TEA");
			if(teacherUser.getPassword().equals(old)&&newp.equals(confirm)&&!old.equals(newp)){
				teacherUser.setPassword(newp);
				teacherService.updateOneTea(teacherUser);
				getSession().setAttribute("TEA", teacherUser);
				return SUCCESS;
			}
		}
		ServletActionContext.getRequest().setAttribute("errinfo", "密码错误或格式不正确！");
		return SUCCESS;
	}
	
	/**
	 * 登陆退出
	 * @return
	 */
	@Action(value="logout",results = {
            @Result(name = "success",location = "/login.jsp")
    })
	public String logout(){
		String type = ServletActionContext.getRequest().getParameter("type");
		if(type.equals("stu"))
			getSession().removeAttribute("STU");
		else if(type.equals("tea"))
			getSession().removeAttribute("TEA");
		else
			getSession().removeAttribute("ADM");
		return SUCCESS;
	}
	
	private HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
	}
	public Object getModel() {
		return null;
	}
}
