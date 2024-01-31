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

/**
 * Servlet implementation class ProductsSoilInMonthServlet
 */
@WebServlet("/admin/products-soil-in-month")
public class ProductsSoilInMonthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsSoilInMonthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			StatisticalDao dao = new StatisticalDao();
			List<ProductsSoilInMonths> list = dao.productsSoilInMonths();
			
			request.setAttribute("productsInMonth", list);
			request.setAttribute("linkScript", "ProductsSoidInMonths.jsp");
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_STATISTICAL_PRODUCT_SOIL_IN_MONTH_PAGE);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
