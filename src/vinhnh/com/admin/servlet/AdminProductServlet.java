package vinhnh.com.admin.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import vinhnh.com.common.PageInfo;
import vinhnh.com.common.PageType;
import vinhnh.com.common.UploadUtils;
import vinhnh.com.dao.ProductDao;
import vinhnh.com.dao.UserDao;
import vinhnh.com.model.Product;
import vinhnh.com.model.User;

/**
 * Servlet implementation class AdminProductServlet
 */
@MultipartConfig
@WebServlet({"/admin/admin-product","/admin/insert-product",
	"/admin/update-product","/admin/delete-product","/admin/edit-product","/admin/reset-product",
	"/admin/list-products"})
public class AdminProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		
		if(url.contains("admin-product")) {
			request.setAttribute("url", url);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_PRODUCT_PAGE);
			return;
		}else if(url.contains("list-products")) {
			FindAll(request, response);
			request.setAttribute("url", url);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_LIST_PRODUCT_PAGE);
			return;
		}else if(url.contains("reset-product")) {
			reset(request, response);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_PRODUCT_PAGE);
			return;
		}else if(url.contains("edit-product")) {
			edit(request, response);
			request.setAttribute("url", url);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_PRODUCT_PAGE);
			return;
		}else if(url.contains("delete-product")) {
			delete(request, response);
			request.setAttribute("url", url);
			response.sendRedirect(request.getContextPath() + "/admin/list-products?page=1");
			return;
		}
		PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_PRODUCT_PAGE);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if(url.contains("insert-product")) {
			insert(request, response);
			request.setAttribute("url", url);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_PRODUCT_PAGE);
			return;
		}else if(url.contains("update-product")) {
			update(request, response);
			reset(request, response);
			request.setAttribute("url", url);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_PRODUCT_PAGE);
			return;
		}else if(url.contains("reset-product")) {
			reset(request, response);
			request.setAttribute("url", url);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_PRODUCT_PAGE);
			return;
		}
		PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_PRODUCT_PAGE);
	}
	
	
	//reset lại form
	protected void reset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product = new Product();
		request.setAttribute("product", product);
	}
	
	//hiểm thị thông tin các sản phẩm và phân trang
	protected void FindAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Số sản phẩm hiển thị trên mỗi trang
        int recordsPerPage = 10;
        
        // Trang hiện tại, mặc định là trang đầu tiên
        int currentPage = 10;
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
	
	
	//hiểm thị sản phẩm lên form 
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product = new Product();
		String id = request.getParameter("id");
		
		int idProduct = Integer.parseInt(id);
		ProductDao dao = new ProductDao();
		
		product = dao.findById(idProduct);
		request.setAttribute("product", product);
		String imageWrap = "display: none;";
		String fileContent = "display: block;";
		//sử lý hình ảnh
		request.setAttribute("imageWrap", imageWrap);
		request.setAttribute("fileContent", fileContent);
		
	}
	
	//thêm sản phẩm
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String username =  (String) request.getSession().getAttribute("username");
			UserDao daoUser = new UserDao();
			User user = daoUser.findByUsername(username);
			
			Product product = new Product();
			BeanUtils.populate(product, request.getParameterMap());
			
			
			product.setCreateDate(new Date());
			product.setUser(user);
	
			String file = username.trim() + "/";
			String url = "E:\\JavaServlet\\WebShopMegaAnime\\WebContent\\images\\user\\" +username.trim();
			product.setImages(file + UploadUtils.FileUpload(request, url, "images"));
			
			ProductDao dao = new ProductDao();
			dao.insert(product);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//thêm sản phẩm
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String userSession =  (String) request.getSession().getAttribute("username");
			UserDao daoUser = new UserDao();
			User user = daoUser.findByUsername(userSession);
			
			
			Product product = new Product();
			BeanUtils.populate(product, request.getParameterMap());
			
			String idString = request.getParameter("id");
			Integer id = Integer.parseInt(idString);
			ProductDao dao = new ProductDao();
			Product productUpdate = dao.findById(id);
			
		    if(request.getPart("images").getSize()==0) {
				product.setImages(productUpdate.getImages());
			}else {
				String username =  (String) request.getSession().getAttribute("username");
				String file = username.trim() + "/";
				String url = "E:\\JavaServlet\\WebShopMegaAnime\\WebContent\\images\\user\\" +username.trim();
				product.setImages(file + UploadUtils.FileUpload(request, url, "images"));
			}
		    
		    
		    product.setCreateDate(new Date());
		    product.setUser(user);
		    
		    dao.update(product);
		    
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//xóa sản phẩm
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			String id = request.getParameter("id");
		    
		    int idProduct = Integer.parseInt(id);

		    ProductDao dao = new ProductDao();
		    Product productToDelete = dao.findById(idProduct);
		    
		    dao.delete(idProduct);

			FindAll(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
