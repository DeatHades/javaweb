package com.itoffer.lmx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/ApplicantRegisterServlet")
public class ApplicantRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicantRegisterServlet() {
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
		//�����������Ӧ����
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset= UTF-8");
		//��ȡ�ַ�������ͻ��˷��ͽ��
		PrintWriter out = response.getWriter();
		// ��ȡ�������
		String email = request.getParameter("email");
		System.out.print(email);
		String password = request.getParameter("password");
		// �ж��Ƿ��Ѿ�ע��
		ApplicantDAO dao = new ApplicantDAO();
		boolean flag = dao.isExistEmail(email);
		if (flag) {// ����Ѿ�ע�ᣬ��ʾ�û�
			out.println("<script  type='text/javascript'>");
			out.println("alert('�����Ѿ���ע�ᣬ����������')");
			out.println("window.location='register.html'");
			out.println("</script>");
			out.flush();
		}else{
			dao.save(email, password);
			response.sendRedirect("login.html");
		}
		out.close();

	}
}
