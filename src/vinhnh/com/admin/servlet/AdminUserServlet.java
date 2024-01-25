package vinhnh.com.admin.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import vinhnh.com.common.PageInfo;
import vinhnh.com.common.PageType;
import vinhnh.com.common.UploadUtils;
import vinhnh.com.dao.RoleDao;
import vinhnh.com.dao.UserDao;
import vinhnh.com.model.Role;
import vinhnh.com.model.User;

/**
 * Servlet implementation class AdminUserServlet
 */
@MultipartConfig
@WebServlet({"/admin/admin-user","/admin/list-users","/admin/insert-user",
			"/admin/update-user","/admin/delete-user","/admin/edit-user","/admin/reset-user"})
public class AdminUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		
		RoleDao roleDao = new RoleDao();
		List<Role> role = roleDao.findAll();
		
		request.setAttribute("role", role);
		if(url.contains("admin/admin-user")){
			request.setAttribute("url", url);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_USERS_PAGE);
			return;
		}else if(url.contains("admin/list-users")) {
			findAll(request, response);
			request.setAttribute("url", url);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_LIST_USER_PAGE);
			return;
		}else if(url.contains("/admin/reset-user")) {
			reset(request, response);
			request.setAttribute("url", url);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_USERS_PAGE);
			return;
		}else if(url.contains("admin/edit-user")) {
			edit(request, response);
			request.setAttribute("url", url);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_USERS_PAGE);
			return;
		}else if(url.contains("admin/delete-user")) {
			delete(request, response);
			request.setAttribute("url", url);
			response.sendRedirect(request.getContextPath() + "/admin/list-users?page=1");
			return;
		}
		PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_USERS_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		
		RoleDao roleDao = new RoleDao();
		List<Role> role = roleDao.findAll();
		request.setAttribute("role", role);
		
		if(url.contains("insert-user")) {
			insert(request, response);
			request.setAttribute("url", url);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_USERS_PAGE);
			return;
		}else if(url.contains("reset-user")) {
			reset(request, response);
			request.setAttribute("url", url);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_USERS_PAGE);
			return;
		}else if(url.contains("delete-user")) {
			delete(request, response);
			request.setAttribute("url", url);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_USERS_PAGE);
			return;
		}else if(url.contains("update-user")) {
			update(request, response);
			request.setAttribute("url", url);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_USERS_PAGE);
			return;
		}
		
		PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_USERS_PAGE);
	}
	
	//Hiểm thị danh sách các user
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		//Gọi hàm findAll từ DAO để lấy danh sách sản phẩm
		UserDao dao = new UserDao();
		List<User> userList = dao.findAll(false, startRecord, recordsPerPage);
		// Tính toán số trang và tổng số bản ghi
        int totalRecords = dao.count();
        int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);
        
     // Đặt các thuộc tính vào request để sử dụng trong JSP
        request.setAttribute("userList", userList);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("totalRecords", totalRecords);
	}
	
	//hiểm thị thông tin lên form
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		String id = request.getParameter("id");
		
		int idUser = Integer.parseInt(id);
		UserDao dao = new UserDao();
		
		user = dao.findById(idUser);
		request.setAttribute("user", user);
		String imageWrap = "display: none;";
		String fileContent = "display: block;";
		//sử lý hình ảnh
		request.setAttribute("imageWrap", imageWrap);
		request.setAttribute("fileContent", fileContent);
	}
	
	
	protected void reset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		RoleDao roleDao = new RoleDao();
	}
	
	//thêm tài khoản
	
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DateTimeConverter dtc = new DateConverter(new Date());
			dtc.setPattern("yyyy-MM-dd");
			ConvertUtils.register(dtc, Date.class); 

		    try {
		        User user = new User();
		        
		        String rolePar = request.getParameter("rolePar");
		        int roleId = Integer.parseInt(rolePar);
		        RoleDao roleDao = new RoleDao();
		        Role role = roleDao.findById(roleId);

		        BeanUtils.populate(user, request.getParameterMap());
		        
		        if(request.getPart("avatar").getSize() ==0) {
		        	user.setAvatar("profile.jpg");
		        }else {
		        	String file = user.getUsername().trim() + "/";
			        String url = "E:\\JavaServlet\\WebShopMegaAnime\\WebContent\\images\\user\\" + user.getUsername().trim();
			        
			        user.setAvatar(file + UploadUtils.FileUpload(request, url, "avatar"));
		        }
		     
		        user.setCreateDate(new Date());
		        user.setRole(role);

		        UserDao dao = new UserDao();
		        dao.insert(user);
		        request.setAttribute("message", "Thêm thành công!");
		    } catch (Exception e) {
		        // Xử lý các lỗi khác nếu có
		        e.printStackTrace();
		        request.setAttribute("error", "Thêm thất bại!");
		    }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", "Thêm thất bại!");
		}
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String deleteId = request.getParameter("id");
			
			if(deleteId == null) {
				request.setAttribute("error", "Xóa thất bại!");
			}
			int id = Integer.parseInt(deleteId);
			UserDao dao = new UserDao();
			User user = dao.findById(id);
			
			if(user == null) {
				request.setAttribute("error", "Xóa thất bại!");
			}else {
				dao.delete(id);
				findAll(request, response);
				request.setAttribute("message", "Xóa thành công!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", "Xóa thất bại!");
		}
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DateTimeConverter dtc = new DateConverter(new Date());
		dtc.setPattern("yyyy-MM-dd");
		ConvertUtils.register(dtc, Date.class); 
		
		try {
			UserDao dao = new UserDao();
			User user = new User();
			
			BeanUtils.populate(user, request.getParameterMap());
			
			if(request.getPart("avatar").getSize() == 0) {
				User updateImage = dao.findById(user.getId());
	        	user.setAvatar(updateImage.getAvatar());
	        }else {
	        	String file = user.getUsername().trim() + "/";
		        String url = "E:\\JavaServlet\\WebShopMegaAnime\\WebContent\\images\\user\\" + user.getUsername().trim();
		        user.setAvatar(file + UploadUtils.FileUpload(request, url, "avatar"));
	        }
			
			String rolePar = request.getParameter("rolePar");
			int roleId = Integer.parseInt(rolePar);
			RoleDao roleDao = new RoleDao();
	        Role role = roleDao.findById(roleId);
	        user.setRole(role);
	        
	        user.setCreateDate(new Date());
	        dao.update(user);
	        request.setAttribute("message", "Cập nhât thành công!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", "Chỉnh sửa thất bại!");
		}
	}
}
