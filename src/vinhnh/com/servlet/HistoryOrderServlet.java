package vinhnh.com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vinhnh.com.common.PageInfo;
import vinhnh.com.common.PageType;
import vinhnh.com.dao.SttOrderDao;
import vinhnh.com.domain.OrderStatus;

/**
 * Servlet implementation class HistoryOrderServlet
 */
@WebServlet("/history-order")
public class HistoryOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userSession =  (String) request.getSession().getAttribute("username");

		HomeServlet home = new HomeServlet();
		home.category(request, response);
		
		CartServlet cart = new CartServlet();
		cart.countCart(request, response);
		
		FavoriteServlet favorite = new FavoriteServlet();
		favorite.coutFavorite(request, response);
		
		LoginServlet loginServlet = new LoginServlet();
		loginServlet.requestSessionForUser(request, response);
		SttOrderDao dao = new SttOrderDao();
		
		List<OrderStatus> orderStatus = dao.findAllOrderUser(userSession);
		
		request.setAttribute("orderStt", orderStatus);
		PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_HISTORY_ORDER_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
