package com.itoffer.lmx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApplicantLoginServlet
 */
@WebServlet("/ApplicantLoginServlet")
public class ApplicantLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicantLoginServlet() {
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
		String password = request.getParameter("password");
		//登录验证
		ApplicantDAO dao = new ApplicantDAO();
		int applicantID = dao.login(email, password);
		if (applicantID != 0) {
			//登陆成功跳转到主页
			response.sendRedirect("index.html");
		} else {
			out.println("<script  type='text/javascript'>");
			out.println("alert('用户名或密码错误，请重新输入')");
			out.println("window.location='login.html'");
			out.println("</script>");
			out.flush();
		}
		out.close();	
	}

}
