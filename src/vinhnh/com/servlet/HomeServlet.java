package vinhnh.com.servlet;

import java.io.IOException;
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
import vinhnh.com.dao.ProductDao;
import vinhnh.com.dao.UserDao;
import vinhnh.com.model.Product;
import vinhnh.com.model.User;

@WebServlet({"/home","/product","/success","/prod-mega","/search"})
public class HomeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		category(request, response);
		
		CartServlet cart = new CartServlet();
		cart.countCart(request, response);
		
		FavoriteServlet favorite = new FavoriteServlet();
		favorite.coutFavorite(request, response);
		favorite.checkLike(request, response);
		
		LoginServlet loginServlet = new LoginServlet();
		loginServlet.requestSessionForUser(request, response);
		if(url.contains("home")) {
			productPokemon(request, response);
			PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_HOME_PAGE);
			return;
		}else if(url.contains("product")) {
			productFindAll(request, response);
			PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_PRODUCTS_PAGE);
			return;
		}else if(url.contains("success")) {
			PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_SUCCESS_PAGE);
			return;
		}else if(url.contains("prod-mega")) {
			findAllByMega(request, response);
			PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_PRODUCT_CATEGORI_PAGE);
			return;
		}else {
			PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_HOME_PAGE);
			return;
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if(url.contains("search")) {
			search(request, response);
			PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_PRODUCTS_PAGE);
			return;
		}
		PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_HOME_PAGE);
	}
	
	protected void topSellingProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void productPokemon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pokemon = "Pokemon";
		
		ProductDao dao = new ProductDao();
		List<Product> products = dao.productMegaAnime(pokemon);
		
		request.setAttribute("prodPokenmon", products);
	}
	
	protected void productFindAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		// Số sản phẩm hiển thị trên mỗi trang
        int recordsPerPage = 8;
        
        // Trang hiện tại, mặc định là trang đầu tiên
        int currentPage = 1;
        String pageStr = request.getParameter("page");
        if (pageStr != null) {
            currentPage = Integer.parseInt(pageStr);
        }

        // Tính toán vị trí bắt đầu của kết quả trên trang hiện tại
        int startRecord = (currentPage - 1) * recordsPerPage;

        // Gọi hàm findAll từ DAO để lấy danh sách sản phẩm
        ProductDao productDAO = new ProductDao();
        List<Product> productList = productDAO.findAll(false, startRecord, recordsPerPage);

        // Tính toán số trang và tổng số bản ghi
        int totalRecords = productDAO.count();
        int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);

        // Đặt các thuộc tính vào request để sử dụng trong JSP
        request.setAttribute("productList", productList);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("totalRecords", totalRecords);
	}

	protected void category(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    ProductDao dao = new ProductDao();
	    List<String> category = dao.category();
	    request.setAttribute("category", category);
	}
	protected void findAllByMega(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categori = request.getParameter("categori").toString();

		// Số sản phẩm hiển thị trên mỗi trang
        int recordsPerPage = 8;
        
        // Trang hiện tại, mặc định là trang đầu tiên
        int currentPage = 1;
        String pageStr = request.getParameter("page");
        if (pageStr != null) {
            currentPage = Integer.parseInt(pageStr);
        }

        // Tính toán vị trí bắt đầu của kết quả trên trang hiện tại
        int startRecord = (currentPage - 1) * recordsPerPage;

        // Gọi hàm findAll từ DAO để lấy danh sách sản phẩm
        
		ProductDao dao = new ProductDao();
		List<Product> listProduct = dao.relatedProducts(categori, startRecord, recordsPerPage);
		
		System.out.println(listProduct.size());
		 // Tính toán số trang và tổng số bản ghi
        int totalRecords = dao.count(categori);
        int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);
        
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("totalRecords", totalRecords);
        request.setAttribute("productList", listProduct);
		request.setAttribute("caterogi", categori);
	}
	

	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		
		ProductDao dao = new ProductDao();
		List<Product> searchList = dao.search(search);
		
		request.setAttribute("productList", searchList);
	}
}
