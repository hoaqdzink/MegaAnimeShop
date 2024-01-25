package vinhnh.com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vinhnh.com.common.Mail;

@WebServlet("/forgotPassword")
public class ForgotPasswordServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HomeServlet home = new HomeServlet();
		home.category(request, response);
		
		CartServlet cart = new CartServlet();
		cart.countCart(request, response);
		
		FavoriteServlet favorite = new FavoriteServlet();
		favorite.coutFavorite(request, response);
		
		LoginServlet loginServlet = new LoginServlet();
		loginServlet.requestSessionForUser(request, response);
		
		request.getRequestDispatcher("/layout/login/forgotP.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("email");
		try {
			Mail sendMail = new Mail();
			
			sendMail.JavaMailForgotPass(mail);
			request.setAttribute("message", "Vui lòng kiểm tra mail để lấy lại mật khẩu");
			request.getRequestDispatcher("/layout/login/login.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("message", "Gửi mail thất bại");
		}
		
	}

}
