package vinhnh.com.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import vinhnh.com.common.CookieUtils;
import vinhnh.com.common.Mail;
import vinhnh.com.common.PageInfo;
import vinhnh.com.common.PageType;
import vinhnh.com.dao.InvoiceDao;
import vinhnh.com.dao.ProductDao;
import vinhnh.com.dao.SttOrderDao;
import vinhnh.com.dao.UserDao;
import vinhnh.com.model.Invoice;
import vinhnh.com.model.Product;
import vinhnh.com.model.SttOder;
import vinhnh.com.model.User;

/**
 * Servlet implementation class InvoicesServlet
 */
@WebServlet("/invoices")
public class InvoicesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InvoicesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idProduct = request.getParameter("product");
		String quantity = request.getParameter("quantity");
		HomeServlet home = new HomeServlet();
		home.category(request, response);
		
		CartServlet cart = new CartServlet();
		cart.countCart(request, response);
		
		FavoriteServlet favorite = new FavoriteServlet();
		favorite.coutFavorite(request, response);
		
		LoginServlet loginServlet = new LoginServlet();
		loginServlet.requestSessionForUser(request, response);
		int id = Integer.parseInt(idProduct);
		
		ProductDao daoProduct = new ProductDao();
		Product product = daoProduct.findById(id);	
		
		String username = (String) request.getSession().getAttribute("username");
		User user = new UserDao().findByUsername(username);	
		request.setAttribute("product", product);
		request.setAttribute("quantity", quantity);
		request.setAttribute("user", user);
		PageInfo.prepareAndForwardIndex(request, response, PageType.INDEX_INVOICES_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    order(request, response);
	}
	
protected void order(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    String idProduct = request.getParameter("productId");
	    int id = Integer.parseInt(idProduct);
	    ProductDao daoProduct = new ProductDao();
		Product product = daoProduct.findById(id);
		
		String userSession =  (String) request.getSession().getAttribute("username");
		UserDao daoUser = new UserDao();
		User user = daoUser.findByUsername(userSession);
		
		String soLuong = request.getParameter("quantity");
		int quantity = Integer.parseInt(soLuong);
    	BigDecimal totalMoney = BigDecimal.valueOf(quantity).multiply(product.getPrice());
    	
		String diaChi = request.getParameter("placeDelivery");
		String phone = request.getParameter("phone");
	    try {
	    	Invoice invoice = new Invoice();
	    	
	    	invoice.setCreateDate(new Date());
	    	invoice.setQuantity(quantity);
	    	invoice.setPhone(phone);
	    	invoice.setPlaceDelivery(diaChi);
            invoice.setTotalMoney(totalMoney);
	    	invoice.setUser(user);
	    	invoice.setProduct(product);
            
	    	InvoiceDao daoInvoiceDao = new InvoiceDao();
	    	int generatedId = daoInvoiceDao.insertKey(invoice);
	    	
	    	Invoice order = daoInvoiceDao.findById(generatedId);
	    	
	    	SttOder sttOrder = new SttOder();
	    	sttOrder.setStatuss("Chờ duyệt");
	    	sttOrder.setInvoice(order);
	    	sttOrder.setCreateDate(new Date());
	    	sttOrder.setUser(user);
	    	
	    	SttOrderDao sttDao = new SttOrderDao();
	    	sttDao.insert(sttOrder);
	    	Mail mail = new Mail();
	    	mail.InvoicesMail(userSession, id, generatedId);
            response.sendRedirect(request.getContextPath()+"/success");
            return;
	    } catch (Exception e) {
	        e.printStackTrace();
	        request.setAttribute("error", "Đặt hàng không thành công");
	        doGet(request, response);
	    }

	}

}
