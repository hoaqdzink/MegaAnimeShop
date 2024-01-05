package vinhnh.com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vinhnh.com.common.CookieUtils;
import vinhnh.com.common.PageInfo;
import vinhnh.com.common.PageType;
import vinhnh.com.common.SessionUtils;
import vinhnh.com.dao.UserDao;
import vinhnh.com.model.User;

@WebServlet({"/home","/product","/detail","/invoices"})
public class HomeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if(url.contains("home")) {
			PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_HOME_PAGE);
			return;
		}else if(url.contains("product")) {
			PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_PRODUCTS_PAGE);
			return;
		}else if(url.contains("detail")){
			PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_DETAIL_PAGE);
			return;
		}else if(url.contains("invoices")) {
			PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_INVOICES_PAGE);
			return;
		}else {
			PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_HOME_PAGE);
			return;
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
