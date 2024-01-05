package vinhnh.com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vinhnh.com.common.MailForgotPass;

@WebServlet("/forgotPassword")
public class ForgotPasswordServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/layout/login/forgotP.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("email");
		try {
			MailForgotPass sendMail = new MailForgotPass();
			
			sendMail.JavaMailForgotPass(mail);
			request.setAttribute("message", "Vui lòng kiểm tra mail để lấy lại mật khẩu");
			request.getRequestDispatcher("/layout/login/login.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("message", "Gửi mail thất bại");
		}
		
	}

}
