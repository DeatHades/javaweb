package com.itoffer.lmx.lianxi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormRequestServlet
 */
@WebServlet("/FormRequestServlet")
public class FormRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//设置响应文本的类型为HTML 字符编码为utf-8
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		String[] channel = request.getParameterValues("channel");
		Enumeration<String> elem = request.getParameterNames();
		
		//获取输出流
		PrintWriter out = response.getWriter();
		//响应输出数据
		out.println("<p>用户的用户名是：" + username + "</p>");
		out.println("<p>密码是：" + password + "</p>");
		out.println("注册的信息来源是：");
		for (String cString : channel) { 
			out.print(cString + "&nbsp");
		}
		out.println("</p><p>所有客户请求的参数是：");
		while (elem.hasMoreElements()) {
			out.println(elem.nextElement() + "&nbsp");
		}
		out.println("</p>");
		out.flush();
		out.close();
	}

}
