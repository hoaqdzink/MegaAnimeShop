package vinhnh.com.admin.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

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
import vinhnh.com.dao.StatisticalDao;
import vinhnh.com.dao.UserDao;
import vinhnh.com.domain.Top5BestSellingProducts;
import vinhnh.com.domain.Top5MostPurchasedMegaAnime;
import vinhnh.com.model.User;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StatisticalDao dao = new StatisticalDao();
		BigDecimal totalMonth = dao.totalPriceMonth();
		BigDecimal totalPrice = dao.totalPrice();
		
		List<Top5BestSellingProducts> bestSellingProducts = dao.top5BestSellingProduct();
		
		List<Top5MostPurchasedMegaAnime> purchasedMegaAnimes = dao.mostPurchasedMegaAnimes();
		request.setAttribute("bestSelling", bestSellingProducts);
		request.setAttribute("purchasedMegaAnimes", purchasedMegaAnimes);
		request.setAttribute("linkScript", "top5spBanChay.jsp");
		request.setAttribute("totalMonth", totalMonth);
		request.setAttribute("totalPrice", totalPrice);
		PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_HOME_PAGE);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
