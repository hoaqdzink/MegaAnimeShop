package vinhnh.com.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vinhnh.com.common.PageInfo;
import vinhnh.com.common.PageType;
import vinhnh.com.dao.StatisticalDao;
import vinhnh.com.domain.ProductsSoilInMonths;
import vinhnh.com.domain.StatusOrder;

/**
 * Servlet implementation class StatusOrderServlet
 */
@WebServlet("/admin/status-order")
public class StatusOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StatisticalDao dao = new StatisticalDao();
		List<StatusOrder> list = dao.statusOrders();
		request.setAttribute("status", list);
		request.setAttribute("linkScript", "statusOrder.jsp");
		PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_STATISTICAL_STATUS_ORDER_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
