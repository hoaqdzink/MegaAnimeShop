package vinhnh.com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
import vinhnh.com.dao.FavoriteDao;
import vinhnh.com.dao.ProductDao;
import vinhnh.com.dao.UserDao;
import vinhnh.com.domain.FavoriteList;
import vinhnh.com.model.Favorite;
import vinhnh.com.model.Product;
import vinhnh.com.model.User;

/**
 * Servlet implementation class FavoriteServlet
 */
@WebServlet({"/favorites","/favorite-insert","/favorite-delete"})
public class FavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavoriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		
		HomeServlet home = new HomeServlet();
		home.category(request, response);
		
		CartServlet cart = new CartServlet();
		cart.countCart(request, response);
		
		coutFavorite(request, response);
		checkLike(request, response);
		
		LoginServlet loginServlet = new LoginServlet();
		loginServlet.requestSessionForUser(request, response);
		if(url.contains("favorites")) {
			findAll(request, response);
			PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_FAVORITE_PAGE);
			return;
		}else if(url.contains("favorite-insert")) {
			insert(request, response);
			PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_FAVORITE_PAGE);
			return;
		}else if(url.contains("favorite-delete")) {
			delete(request, response);
			PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_FAVORITE_PAGE);
			return;
		}
		PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_FAVORITE_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Lưu lại URL trước đó vào session
		    HttpSession session = request.getSession();
		    String referringURL = request.getHeader("referer");
		    session.setAttribute("referringURL", referringURL);
			
			String username = (String) request.getSession().getAttribute("username");
			UserDao userDao = new UserDao();
			User user = userDao.findByUsername(username);
			
			String idPorduct = request.getParameter("product");
			int id = Integer.parseInt(idPorduct);
			ProductDao productDao = new ProductDao();
			Product product = productDao.findById(id);
			
			FavoriteDao favoriteDao = new FavoriteDao();
			Favorite favorite = new Favorite(); 
			
			// Lấy ngày giờ hiện tại
	        Date currentDate = new Date();

	        // Định dạng ngày giờ
	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	        String formattedDate = sdf.format(currentDate);
	        
			favorite.setDateLike(currentDate);
			favorite.setProduct(product);
			favorite.setUser(user);
			
			favoriteDao.insert(favorite);
			System.out.println("Thêm thành công!");
			
			 // Chuyển hướng về trang trước đó
		    String referringURLFromSession = (String) session.getAttribute("referringURL");
		    response.sendRedirect(referringURLFromSession);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	protected void coutFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("username");
		FavoriteDao dao = new FavoriteDao();
		int count = dao.countFavoriteDaoOfUsername(username);
		request.setAttribute("coutFavorite", count);
	}
	
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("username");
		FavoriteDao dao = new FavoriteDao();
		List<FavoriteList> faList = dao.findAllByUsername(username);
		
		request.setAttribute("favoriteList", faList);
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Lưu lại URL trước đó vào session
		    HttpSession session = request.getSession();
		    String referringURL = request.getHeader("referer");
		    session.setAttribute("referringURL", referringURL);
		    
			String username = (String) request.getSession().getAttribute("username");
			String product = request.getParameter("idproduct");
			int idProduct = Integer.parseInt(product);
			
			System.out.println(username);
			System.out.println(idProduct);
			FavoriteDao dao = new FavoriteDao();
			dao.delete(username, idProduct);

			coutFavorite(request, response);
			findAll(request, response);
			System.out.println("Xóa thành công!");
			
			 // Chuyển hướng về trang trước đó
		    String referringURLFromSession = (String) session.getAttribute("referringURL");
		    response.sendRedirect(referringURLFromSession);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	protected void checkLike(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			String username = (String) request.getSession().getAttribute("username");
			FavoriteDao dao = new FavoriteDao();
			List<FavoriteList> faList = dao.findAllByUsername(username);
			
			request.setAttribute("checkLike", faList);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
