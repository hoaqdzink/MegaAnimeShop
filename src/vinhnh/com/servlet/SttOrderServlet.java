package vinhnh.com.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.persistence.criteria.Order;
import vinhnh.com.common.PageInfo;
import vinhnh.com.common.PageType;
import vinhnh.com.dao.SttOrderDao;
import vinhnh.com.domain.OrderStatus;
import vinhnh.com.model.SttOder;

/**
 * Servlet implementation class SttOrderServlet
 */
@WebServlet({"/sttOrders","/cancel-sttOrder"})
public class SttOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SttOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HomeServlet home = new HomeServlet();
		home.category(request, response);
		
		CartServlet cart = new CartServlet();
		cart.countCart(request, response);
		
		FavoriteServlet favorite = new FavoriteServlet();
		favorite.coutFavorite(request, response);
		
		LoginServlet loginServlet = new LoginServlet();
		loginServlet.requestSessionForUser(request, response);
		
		
		String url = request.getRequestURL().toString();
		if(url.contains("cancel-sttOrder")) {
			cancel(request, response);
			PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_STTODER_PAGE);
			return;
		}else if(url.contains("sttOrders")) {
			findAllChoDuyet(request, response);
			PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_STTODER_PAGE);
			return;
		}
		PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_STTODER_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void cancel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		int idInvoices = Integer.parseInt(id);
		SttOrderDao dao = new SttOrderDao();
		SttOder orderStatus = dao.findById(idInvoices);
		orderStatus.setStatuss("Hủy mua");
		orderStatus.setDescriptions("Người mua hàng đã hủy vào lúc " + new Date());
		
		dao.update(orderStatus);
		findAllChoDuyet(request, response);
	}
	
	protected void findAllChoDuyet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userSession =  (String) request.getSession().getAttribute("username");
		SttOrderDao dao = new SttOrderDao();
		
		List<OrderStatus> orderStatus = dao.findAllOrderUser(userSession);
		
		request.setAttribute("orderStt", orderStatus);
	}
	
	

}
