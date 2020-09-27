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
		
		//��ȡ�ַ�������ͻ��˷��ͽ��
		PrintWriter out = response.getWriter();
		//ȡ���������������
		Enumeration<String> keys = request.getParameterNames();
		//��������
		while(keys.hasMoreElements()){
			String key = keys.nextElement();
			String val = request.getParameter(key);
			out.println(key + "=" + val);
			
		}
		//��ȡ�ַ�������ͻ��˷��ͽ��
		
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
