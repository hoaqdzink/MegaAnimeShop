package vinhnh.com.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import vinhnh.com.common.PageInfo;
import vinhnh.com.dao.RoleDao;
import vinhnh.com.dao.UserDao;
import vinhnh.com.model.Role;
import vinhnh.com.model.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/layout/login/register.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DateTimeConverter dtc = new DateConverter(new Date());
			dtc.setPattern("yyyy-MM-dd");
			ConvertUtils.register(dtc, Date.class);

			User user = new  User();
			RoleDao roleDao = new RoleDao(); // Thay RoleDao bằng class quản lý Role của bạn
			Role role = roleDao.findById(2); // 1 là ID của Role muốn set
			System.out.println(role);
			BeanUtils.populate(user, request.getParameterMap());
			
			user.setAvatar("/profile.jpg");
			user.setCreateDate(new Date());
			user.setRole(role);
			
			UserDao userDao = new UserDao();
			
			userDao.insert(user);
			response.sendRedirect(request.getContextPath()+ "/login");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		
		
	}

}
