package vinhnh.com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import vinhnh.com.common.CookieUtils;
import vinhnh.com.common.PageInfo;
import vinhnh.com.common.PageType;
import vinhnh.com.common.SessionUtils;
import vinhnh.com.dao.UserDao;
import vinhnh.com.domain.Login;
import vinhnh.com.model.User;

@WebServlet({"/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String username = CookieUtils.get("username", request);
	    HttpSession session = request.getSession();

	    if (username == null) {
	        // Người dùng chưa đăng nhập, chuyển hướng đến trang đăng nhập
	        request.setAttribute("isLogin", false);
	        request.getRequestDispatcher("/layout/login/login.jsp").forward(request, response);
	        return;
	    }

	    User user = new UserDao().findByUsername(username);

	    if (SessionUtils.isLogin(request)) {
	        // Người dùng đã đăng nhập, thiết lập các thuộc tính của phiên
	        session.setAttribute("name", user.getFullname());
	        session.setAttribute("role", user.getRole().getPosition());
	        session.setAttribute("avatar", user.getAvatar());
	        response.sendRedirect(request.getContextPath() + "/home");
	        return;
	    } else {
	        // Người dùng chưa đăng nhập, thực hiện các hành động khác nếu cần
	        SessionUtils.add(request, "username", username);
	        PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_HOME_PAGE);
	        return;
	    }
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Login login = new Login();
			BeanUtils.populate(login, request.getParameterMap());
			HttpSession session = request.getSession();
			
			if (login.getUsername() == null || login.getPassword() == null) {
	            // Kiểm tra giá trị null
	            request.setAttribute("error", "Tài khoản và mật khẩu không được để trống");
	            request.getRequestDispatcher("/layout/login/login.jsp").forward(request, response);
	            return;
	        }
			UserDao dao = new UserDao();
	        
			User user = dao.findByUsername(login.getUsername());
			if(user!=null && user.getPassW().trim().equals(login.getPassword().trim())) {
				SessionUtils.add(request, "username", user.getUsername());
				
				if(login.isRemember()) {
					CookieUtils.add("username", login.getUsername(), 24, response);
				}else {
					CookieUtils.add("username", login.getUsername(), 1, response);
				}
				request.setAttribute("isLogin", true);
				
				session.setAttribute("name", user.getFullname());
				session.setAttribute("role", user.getRole().getPosition());
				session.setAttribute("avatar", user.getAvatar());
				response.sendRedirect(request.getContextPath() + "/home");
				return;
			}
			request.setAttribute("error", "Tài khoản hoặc mật khẩu không đúng");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("/layout/login/login.jsp").forward(request, response);
	}
	
	protected void requestSessionForUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) request.getSession().getAttribute("username");
		if(username!=null) {

			UserDao dao = new UserDao();
			User user = dao.findByUsername(username);
			session.setAttribute("name", user.getFullname());
			session.setAttribute("role", user.getRole().getPosition());
			session.setAttribute("avatar", user.getAvatar());
		}
	}

}
