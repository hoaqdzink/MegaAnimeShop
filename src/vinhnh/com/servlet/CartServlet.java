package vinhnh.com.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vinhnh.com.common.PageInfo;
import vinhnh.com.common.PageType;
import vinhnh.com.dao.CartDao;
import vinhnh.com.dao.ProductDao;
import vinhnh.com.dao.UserDao;
import vinhnh.com.domain.CartDetails;
import vinhnh.com.model.Cart;
import vinhnh.com.model.Product;
import vinhnh.com.model.User;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet({"/carts","/cart-insert","/cart-delete"})
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		//hiểm thị các thông tin cần thiết - begin
		HomeServlet home = new HomeServlet();
		home.category(request, response);
		home.productPokemon(request, response);
		
		countCart(request, response);
		
		FavoriteServlet favorite = new FavoriteServlet();
		favorite.coutFavorite(request, response);
		LoginServlet loginServlet = new LoginServlet();
		loginServlet.requestSessionForUser(request, response);
		//end-hiểm thị các thông tin cần thiết
		if(url.contains("/carts")) {
			findAllByUsername(request, response);
			PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_CART_PAGE);
			return;
		}else if(url.contains("cart-insert")) {
			insert(request, response);
			return;
		}else if(url.contains("cart-delete")) {
			deleteCart(request, response);
			findAllByUsername(request, response);
			PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_CART_PAGE);
			return;
		}
		PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_CART_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Lưu lại URL trước đó vào session
	    HttpSession session = request.getSession();
	    String referringURL = request.getHeader("referer");
	    session.setAttribute("referringURL", referringURL);

	    // Lấy thông tin user
	    String username = (String) request.getSession().getAttribute("username");
	    UserDao userDao = new UserDao();
	    User user = userDao.findByUsername(username);

	    // Lấy thông tin product
	    String productId = request.getParameter("product");
	    int id = Integer.parseInt(productId);
	    ProductDao productDao = new ProductDao();
	    Product product = productDao.findById(id);

	    // Thêm dữ liệu vào cart
	    CartDao cartDao = new CartDao();
	    Cart cart = new Cart();
	    cart.setCreateDate(new Date());
	    cart.setUser(user);
	    cart.setProduct(product);

	    cartDao.insert(cart);

	    // Chuyển hướng về trang trước đó
	    String referringURLFromSession = (String) session.getAttribute("referringURL");
	    response.sendRedirect(referringURLFromSession);
	}

	
	protected void countCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("username");
		CartDao dao = new CartDao();
		int count = dao.countCartOfUsername(username);
		request.setAttribute("coutCart", count);
	}
	
	protected void findAllByUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("username");
		CartDao dao = new CartDao();
		List<CartDetails> listCart = dao.FindAllByUsername(username);
		request.setAttribute("carts", listCart);
	}
	
	protected void deleteCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String username = (String) request.getSession().getAttribute("username");
			String idproduct = request.getParameter("product");
			
			int productId = Integer.parseInt(idproduct);
			CartDao dao = new CartDao();
			dao.detelteCart(username, productId);
			countCart(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
