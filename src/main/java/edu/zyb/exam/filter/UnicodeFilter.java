package edu.zyb.exam.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UnicodeFilter  implements Filter{
	
	public void destroy() {
		
	}
	/**
	 * 过滤编码级
	 */
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
        chain.doFilter(req,resp);	
	}

	public void init(FilterConfig arg0) throws ServletException {
	
	}
	
}
