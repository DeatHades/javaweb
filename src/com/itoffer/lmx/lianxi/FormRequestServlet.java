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
		
		//������Ӧ�ı�������ΪHTML �ַ�����Ϊutf-8
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		String[] channel = request.getParameterValues("channel");
		Enumeration<String> elem = request.getParameterNames();
		
		//��ȡ�����
		PrintWriter out = response.getWriter();
		//��Ӧ�������
		out.println("<p>�û����û����ǣ�" + username + "</p>");
		out.println("<p>�����ǣ�" + password + "</p>");
		out.println("ע�����Ϣ��Դ�ǣ�");
		for (String cString : channel) { 
			out.print(cString + "&nbsp");
		}
		out.println("</p><p>���пͻ�����Ĳ����ǣ�");
		while (elem.hasMoreElements()) {
			out.println(elem.nextElement() + "&nbsp");
		}
		out.println("</p>");
		out.flush();
		out.close();
	}

}
