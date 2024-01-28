package vinhnh.com.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vinhnh.com.common.PageInfo;
import vinhnh.com.common.PageType;
import vinhnh.com.dao.SttOrderDao;
import vinhnh.com.model.SttOder;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet({"/admin/all-orders","/admin/approver-order","/admin/handle-order",
			"/admin/delivering-order","/admin/received-order","/admin/recovery-order"})
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if(url.contains("all-orders")) {
			findAll(request, response);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_ALL_ORDER_PAGE);
			return;
		}else if(url.contains("approver-order")) {
			approverOrder(request, response);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_APPROVER_ORDER_PAGE);
			return;
		}else if(url.contains("handle-order")) {
			handleOrder(request, response);
			updateVanChuyen(request, response);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_HANDLE_ORDER_PAGE);
			return;
		}else if(url.contains("delivering-order")) {
			deliveringOrder(request, response);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_DELIVERING_ORDER_PAGE);
			return;
		}else if(url.contains("received-order")) {
			receivedOrder(request, response);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_RECEIVED_ORDER_PAGE);
			return;
		}else if(url.contains("recovery-order")) {
			recpveryOrder(request, response);
			PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_RECOVERY_ORDER_PAGE);
			return;
		}
		PageInfo.prepareAndForwardAdmin(request, response, PageType.ADMIN_ALL_ORDER_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	//Hiểm thị tất cả các đơn hàng
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
		
		
		SttOrderDao orderDao = new SttOrderDao();
		List<SttOder> order = orderDao.findAll(false, startRecord, recordsPerPage);
		
		// Tính toán số trang và tổng số bản ghi
        int totalRecords = orderDao.count();
        int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);

        // Đặt các thuộc tính vào request để sử dụng trong JSP
        request.setAttribute("orderList", order);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("totalRecords", totalRecords);
	}
	
	//hiểm thị danh sách các sản phầm đang chờ duyệt
	protected void approverOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SttOrderDao orderDao = new SttOrderDao();
		String stt = "Chờ duyệt";
		List<SttOder> orderList = orderDao.orderStatus(stt);
		
		request.setAttribute("orderList", orderList);
		
	}
	
	//Hiểm thị danh sách các đơn hàng cần sử lý
	protected void handleOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SttOrderDao orderDao = new SttOrderDao();
		String stt = "Đang xử lý";
		List<SttOder> orderList = orderDao.orderStatus(stt);
		
		request.setAttribute("orderList", orderList);
	}
	
	//Hiểm thị danh sách đơn hàng đang giao
	protected void deliveringOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SttOrderDao orderDao = new SttOrderDao();
		String stt = "Đang giao";
		List<SttOder> orderList = orderDao.orderStatus(stt);
		
		request.setAttribute("orderList", orderList);
	}
	
	//Hiểm thị danh sách đơn hàng đã giao
	protected void receivedOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SttOrderDao orderDao = new SttOrderDao();
		String stt = "Đã giao";
		List<SttOder> orderList = orderDao.orderStatus(stt);
		
		request.setAttribute("orderList", orderList);
	}
	
	//Hiểm thị danh sách các đơn hàng đã hủy
	protected void recpveryOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SttOrderDao orderDao = new SttOrderDao();
		String stt = "Đã hủy";
		List<SttOder> orderList = orderDao.orderStatus(stt);
		
		request.setAttribute("orderList", orderList);
	}
	
	//Xử lý đơn hàng vận chuyển
	protected void updateVanChuyen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SttOrderDao orderDao = new SttOrderDao();
		String idOrder = request.getParameter("idOrder");
		if(idOrder == null) {
			handleOrder(request, response);
		}else {

			int orderId = Integer.parseInt(idOrder);
			
			SttOder sttOder = orderDao.findById(orderId);
			
			sttOder.setStatuss("Đang giao");
			orderDao.update(sttOder);
			
			handleOrder(request, response);
			request.setAttribute("message", "Đơn hàng " + sttOder.getId() + " đã được giao hàng!");
		}
	}
}
