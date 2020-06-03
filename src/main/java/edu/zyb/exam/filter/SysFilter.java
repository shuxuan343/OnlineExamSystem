package edu.zyb.exam.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 过滤session是否登陆
 * @author Administrator
 *
 */
public class SysFilter implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse)resp;
		// 请求资源路径
		String url = request.getRequestURI().toLowerCase();
		//System.out.println("放行："+url);
		//chain.doFilter(request, response);
		// 如果是登录页面，放行
		String hostname = request.getContextPath().toLowerCase();
		if (url.indexOf("login.jsp") > 0||url.endsWith(hostname)||url.endsWith(hostname+"/")){
			chain.doFilter(request, response);
			System.out.println("放行："+url);
			return;
		}
		//如果是静态资源放行
		if(url.indexOf(".css")>0||url.indexOf("/fonts/")>0||url.indexOf("/images/")>0||url.indexOf(".js")>0){
			chain.doFilter(request, response);
			System.out.println("放行："+url);
			return;
		}
		//拦截所有action
		if(url.indexOf("action")>0){
			//登陆放行
			if(url.indexOf("loginaction")>0&&(url.indexOf("tologin")>0||url.indexOf("login")>0)){
				chain.doFilter(request, response);
				System.out.println("放行："+url);
				return;
			}else{//检查session
				Object object1 = request.getSession().getAttribute("TEA");
				Object object2 = request.getSession().getAttribute("STU");
				Object object3 = request.getSession().getAttribute("ADM");
				if(object1==null&&object2==null&&object3==null){//拦截到登陆界面
					response.sendRedirect(request.getContextPath()+"/loginAction/toLogin.do");
				}else{//放行
					chain.doFilter(request, response);
					System.out.println("放行："+url);
					return;
				}
			}
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
