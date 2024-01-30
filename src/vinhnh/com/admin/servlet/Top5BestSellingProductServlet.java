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
import vinhnh.com.domain.Top5BestSellingProducts;

/**
 * Servlet implementation class Top5BestSellingProductServlet
 */
@WebServlet("/admin/top5-best-selling-product")
public class Top5BestSellingProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Top5BestSellingProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StatisticalDao dao = new StatisticalDao();
		List<Top5BestSellingProducts> bestSellingProducts = dao.top5BestSellingProduct();
		
		request.setAttribute("bestSelling", bestSellingProducts);
		request.setAttribute("linkScript", "top5spBanChay.jsp");
		
		PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_STATISTICAL_PRODUCT_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
