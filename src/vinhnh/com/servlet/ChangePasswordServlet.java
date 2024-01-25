package vinhnh.com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import vinhnh.com.common.PageInfo;
import vinhnh.com.common.PageType;
import vinhnh.com.dao.UserDao;
import vinhnh.com.domain.ChangePass;
import vinhnh.com.model.User;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/change-password")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//hiểm thị các thông tin cần thiết - begin
		HomeServlet home = new HomeServlet();
		home.category(request, response);
		
		CartServlet cart = new CartServlet();
		cart.countCart(request, response);
		
		FavoriteServlet favoriteServlet = new FavoriteServlet();
		favoriteServlet.coutFavorite(request, response);
		
		LoginServlet loginServlet = new LoginServlet();
		loginServlet.requestSessionForUser(request, response);
		//end-hiểm thị các thông tin cần thiết
		PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_CHANGE_PASSWORD_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String username = (String) request.getSession().getAttribute("username");
			UserDao dao = new UserDao();
			User user = dao.findByUsername(username);
			
			ChangePass changePass = new ChangePass();
			BeanUtils.populate(changePass, request.getParameterMap());
			
			if(changePass.getPassNowCurrent() != null && !changePass.getPassNowCurrent().trim().isEmpty() &&
				    changePass.getPassNew() != null && !changePass.getPassNew().trim().isEmpty() &&
				    changePass.getPassConfirm() != null && !changePass.getPassConfirm().trim().isEmpty()) {
				if(changePass.getPassNowCurrent().trim().equals(user.getPassW().trim())) {
					if(changePass.getPassNew().trim().equals(changePass.getPassConfirm().trim())) {
						user.setPassW(changePass.getPassNew());
						dao.update(user);
						request.setAttribute("message", "Thay đổi mật khẩu thành công!");
					}else {
						request.setAttribute("error", "Mật khẩu mới và mật khẩu xác nhận không trùng khớp!");
					}
				}else {
					request.setAttribute("error", "Mật khẩu không hợp lệ");
				}
			}else {
				request.setAttribute("error", "Mật khẩu không được để trống");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", "Lỗi: " + e.getMessage());
		}finally {
			PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_CHANGE_PASSWORD_PAGE);
		}
		
	}

}
