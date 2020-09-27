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
 * Servlet implementation class HandleLinkedServlet
 */
@WebServlet("/HandleLinkedServlet")
public class HandleLinkedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleLinkedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取字符流，向客户端发送结果
		PrintWriter out = response.getWriter();
		//取出所有请求参数名
		Enumeration<String> keys = request.getParameterNames();
		//遍历参数
		while(keys.hasMoreElements()){
			String key = keys.nextElement();
			String val = request.getParameter(key);
			out.println(key + "=" + val);
			
		}
		//获取字符流，向客户端发送结果
		
		out.flush();
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
