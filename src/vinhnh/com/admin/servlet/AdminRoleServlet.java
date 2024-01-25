package vinhnh.com.admin.servlet;

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
import vinhnh.com.dao.RoleDao;
import vinhnh.com.model.Role;
import vinhnh.com.model.User;

/**
 * Servlet implementation class AdminRoleServlet
 */
@WebServlet({"/admin/roles","/admin/role-insert","/admin/role-update","/admin/role-delete","/admin/role-edit",
			"/admin/list-role","/admin/role-reset"})
public class AdminRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRoleServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if(url.contains("admin/roles")) {
			Role role = new Role();
			
			request.setAttribute("role", role);
			request.setAttribute("url", url);
			findAll(request, response);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_ROLE_USER_PAGE);
			return;
		}else if(url.contains("admin/list-role")) {
			findAll(request, response);
			request.setAttribute("url", url);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_ROLE_USER_PAGE);
			return;
		}else if(url.contains("admin/role-edit")) {
			
			findAll(request, response);
			edit(request, response);
			request.setAttribute("url", url);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_ROLE_USER_PAGE);
			return;
		}else if(url.contains("admin/role-reset")) {
			Role role = new Role();
			findAll(request, response);
			request.setAttribute("role", role);
			request.setAttribute("url", url);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_ROLE_USER_PAGE);
			return;
		}else if(url.contains("admin/role-delete")) {
			
			delete(request, response);
			findAll(request, response);
			
			Role role = new Role();
			request.setAttribute("role", role);
			request.setAttribute("url", url);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_ROLE_USER_PAGE);
			return;
		}
		PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_ROLE_USER_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if(url.contains("admin/role-insert")) {
			insert(request, response);
			findAll(request, response);
			
			Role role = new Role();
			request.setAttribute("role", role);
			request.setAttribute("url", url);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_ROLE_USER_PAGE);
			return;
		}else if(url.contains("admin/role-reset")) {
			Role role = new Role();
			findAll(request, response);
			request.setAttribute("role", role);
			request.setAttribute("url", url);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_ROLE_USER_PAGE);
			return;
		}else if(url.contains("admin/role-delete")) {
			
			delete(request, response);
			findAll(request, response);
			
			Role role = new Role();
			request.setAttribute("role", role);
			request.setAttribute("url", url);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_ROLE_USER_PAGE);
			return;
		}else if(url.contains("admin/role-update")) {
			update(request, response);
			findAll(request, response);
			
			Role role = new Role();
			request.setAttribute("role", role);
			request.setAttribute("url", url);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_ROLE_USER_PAGE);
			return;
		}
		PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_ROLE_USER_PAGE);
	}
	
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			RoleDao dao = new RoleDao();
			List<Role> listRole = dao.findAll();
			
			request.setAttribute("listRole", listRole);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Role role = new Role();
			RoleDao dao = new RoleDao();
			String id = request.getParameter("id");
			int idRole = Integer.parseInt(id);
			System.out.println("kq" +idRole);
			role = dao.findById(idRole);
			System.out.println("kq" +role);
			request.setAttribute("role", role);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Role role = new Role();
			RoleDao dao = new RoleDao();
			
			BeanUtils.populate(role, request.getParameterMap());
			dao.insert(role);
			request.setAttribute("message", "Thêm thành công!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", "Thêm thất bại");
		}
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Role role = new Role();
			RoleDao dao = new RoleDao();
			
			BeanUtils.populate(role, request.getParameterMap());
			
			dao.update(role);
			request.setAttribute("message", "Sửa thành công!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", "Sửa thất bại");
		}
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			RoleDao dao = new RoleDao();
			String id = request.getParameter("id");
			
			if(id == null) {
				request.setAttribute("error", "Xóa thất bại");
			}else {
				int idDelete = Integer.parseInt(id);
				Role role = dao.findById(idDelete);
				if(role ==null) {
					findAll(request, response);
					request.setAttribute("error", "Xóa thất bại");
					
					role = new Role();
					request.setAttribute("role", role);
					
					PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_ROLE_USER_PAGE);
					return;
				}else {
					dao.delete(idDelete);
					request.setAttribute("message", "Xóa thành công");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", "Xóa thất bại");
		}
	}
	
}
