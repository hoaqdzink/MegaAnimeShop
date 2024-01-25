package vinhnh.com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import vinhnh.com.common.PageInfo;
import vinhnh.com.common.PageType;
import vinhnh.com.dao.ProductDao;
import vinhnh.com.model.Product;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//hiểm thị category
		HomeServlet home = new HomeServlet();
		home.category(request, response);
		
		CartServlet cart = new CartServlet();
		cart.countCart(request, response);
		
		FavoriteServlet favorite = new FavoriteServlet();
		favorite.coutFavorite(request, response);
		favorite.checkLike(request, response);
		
		LoginServlet loginServlet = new LoginServlet();
		loginServlet.requestSessionForUser(request, response);
		//hiểm thị chi tiết sản phẩm
		String idProduct = request.getParameter("idproduct");
		
		int id = Integer.parseInt(idProduct);
		
		ProductDao dao = new ProductDao();
		Product product = dao.findById(id);
		request.setAttribute("product", product);
		
		//hiểm thi các sản phẩm liên quan
		List<Product> listProduct = dao.relatedProducts(product.getMageAnime());
		request.setAttribute("listProduct", listProduct);
		PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_DETAIL_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);		
	}

}
