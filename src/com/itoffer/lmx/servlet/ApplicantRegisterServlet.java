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
		//设置请求和响应编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset= UTF-8");
		//获取字符流，向客户端发送结果
		PrintWriter out = response.getWriter();
		// 获取请求参数
		String email = request.getParameter("email");
		System.out.print(email);
		String password = request.getParameter("password");
		// 判断是否已经注册
		ApplicantDAO dao = new ApplicantDAO();
		boolean flag = dao.isExistEmail(email);
		if (flag) {// 如果已经注册，提示用户
			out.println("<script  type='text/javascript'>");
			out.println("alert('邮箱已经被注册，请重新输入')");
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
