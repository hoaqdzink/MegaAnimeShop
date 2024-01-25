package vinhnh.com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import vinhnh.com.dao.UserDao;
import vinhnh.com.model.User;

/**
 * Servlet implementation class ChangInformationServlet
 */
@MultipartConfig
@WebServlet({"/change-information"})
public class ChangInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangInformationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HomeServlet home = new HomeServlet();
		home.category(request, response);
		
		CartServlet cart = new CartServlet();
		cart.countCart(request, response);
		
		FavoriteServlet favorite = new FavoriteServlet();
		favorite.coutFavorite(request, response);
		
		LoginServlet loginServlet = new LoginServlet();
		loginServlet.requestSessionForUser(request, response);
		
		showInfomation(request, response);
		PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_CHANGE_INFORMATION_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HomeServlet home = new HomeServlet();
		home.category(request, response);
		
		CartServlet cart = new CartServlet();
		cart.countCart(request, response);
		
		FavoriteServlet favorite = new FavoriteServlet();
		favorite.coutFavorite(request, response);
		
		updateInformation(request, response);
		PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_CHANGE_INFORMATION_PAGE);
	}
	
	
	protected void showInfomation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("username");
		UserDao dao = new UserDao();
		User user = dao.findByUsername(username);
		
		request.setAttribute("user", user);
		String imageWrap = "display: none;";
		String fileContent = "display: block;";
		//sử lý hình ảnh
		request.setAttribute("imageWrap", imageWrap);
		request.setAttribute("fileContent", fileContent);
	}
	
	protected void updateInformation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateTimeConverter dtc = new DateConverter(new Date());
		dtc.setPattern("yyyy-MM-dd");
		ConvertUtils.register(dtc, Date.class); 
		try {
			UserDao dao = new UserDao();
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			User updateImage = dao.findById(user.getId());
			if(request.getPart("avatar").getSize() == 0) {
	        	user.setAvatar(updateImage.getAvatar());
	        }else {
	        	String file = user.getUsername().trim() + "/";
		        String url = "E:\\JavaServlet\\WebShopMegaAnime\\WebContent\\images\\user\\" + user.getUsername().trim();
		        user.setAvatar(file + UploadUtils.FileUpload(request, url, "avatar"));
	        }
			
			
	        user.setRole(updateImage.getRole());
	        user.setCreateDate(new Date());
	        user.setPassW(updateImage.getPassW());
//	        user.setBirthday(birthdayDate);
	        dao.update(user);
	        showInfomation(request, response);
	        request.setAttribute("message", "Cập nhât thành công!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", "Cập nhât thất bại!");
		}
	}
}
