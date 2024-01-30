package vinhnh.com.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageInfo {
    public static Map<PageType, PageInfo> pageRoute = new HashMap<>();

    static {
        pageRoute.put(PageType.INDEX_HOME_PAGE, new PageInfo("Mega Shop", "#", "/layout/site/_contentIndex.jsp"));
        pageRoute.put(PageType.INDEX_PRODUCTS_PAGE, new PageInfo("Product Mega", "./css/site/product.css", "/layout/site/_product.jsp"));
        pageRoute.put(PageType.INDEX_PRODUCT_CATEGORI_PAGE, new PageInfo("Product Mega", "./css/site/product.css", "/layout/site/_productMegaAnime.jsp"));
        pageRoute.put(PageType.INDEX_DETAIL_PAGE, new PageInfo("Detail Mega", "./css/site/detail.css", "/layout/site/_detail.jsp"));
        pageRoute.put(PageType.INDEX_INVOICES_PAGE, new PageInfo("Invoices Mega", "./css/site/invoices.css", "/layout/site/_invoices.jsp"));
        pageRoute.put(PageType.INDEX_SUCCESS_PAGE, new PageInfo("Đặt hàng thành công", "#", "/layout/site/_success.jsp"));
        pageRoute.put(PageType.INDEX_STTODER_PAGE, new PageInfo("Trạng thái đơn hàng", "#", "/layout/site/_sttOrder.jsp"));
        pageRoute.put(PageType.INDEX_HISTORY_ORDER_PAGE, new PageInfo("Lịch sử đặt hàng", "#", "/layout/site/_historyOrder.jsp"));
        pageRoute.put(PageType.INDEX_CART_PAGE, new PageInfo("Giỏ hàng", "#", "/layout/site/_cart.jsp"));
        pageRoute.put(PageType.INDEX_FAVORITE_PAGE, new PageInfo("Sản phẩm yêu thích", "#", "/layout/site/_favorite.jsp"));
        pageRoute.put(PageType.INDEX_CHANGE_INFORMATION_PAGE, new PageInfo("Thay đổi thông tin", "./css/site/infor.css", "/layout/site/_changeInfor.jsp"));
        pageRoute.put(PageType.INDEX_CHANGE_PASSWORD_PAGE, new PageInfo("Thay đổi mật khẩu", "./css/site/infor.css", "/layout/site/_changePass.jsp"));
        
        pageRoute.put(PageType.ADMIN_HOME_PAGE, new PageInfo("Admin Mega", "#", "/layout/admin/_main.jsp"));
        pageRoute.put(PageType.ADMIN_PRODUCT_PAGE, new PageInfo("Product Admin", "./css/admin/adProduct.css", "/layout/admin/_product.jsp"));
        pageRoute.put(PageType.ADMIN_LIST_PRODUCT_PAGE, new PageInfo("Danh sách sản phẩm Mega", "#", "/layout/admin/_tableProduct.jsp"));
        pageRoute.put(PageType.ADMIN_USERS_PAGE, new PageInfo("User Admin", "./css/admin/adUser.css", "/layout/admin/_user.jsp"));
        pageRoute.put(PageType.ADMIN_LIST_USER_PAGE, new PageInfo("Danh sách tài khoản", "#", "/layout/admin/_tableUsers.jsp"));
        pageRoute.put(PageType.ADMIN_ROLE_USER_PAGE, new PageInfo("Danh sách các chức vụ", "#", "/layout/admin/_role.jsp"));
        pageRoute.put(PageType.ADMIN_ALL_ORDER_PAGE, new PageInfo("Danh sách các đơn hàng", "#", "/layout/admin/_allOrder.jsp"));
        pageRoute.put(PageType.ADMIN_APPROVER_ORDER_PAGE, new PageInfo("Đơn hàng chờ duyệt", "#", "/layout/admin/_approverOrder.jsp"));
        pageRoute.put(PageType.ADMIN_HANDLE_ORDER_PAGE, new PageInfo("Đơn hàng cần xử lý", "#", "/layout/admin/_handleOrder.jsp"));
        pageRoute.put(PageType.ADMIN_DELIVERING_ORDER_PAGE, new PageInfo("Đơn hàng đang giao", "#", "/layout/admin/_delivering.jsp"));
        pageRoute.put(PageType.ADMIN_RECEIVED_ORDER_PAGE, new PageInfo("Đơn hàng đã giao", "#", "/layout/admin/_received.jsp"));
        pageRoute.put(PageType.ADMIN_RECOVERY_ORDER_PAGE, new PageInfo("Đơn hàng đã hủy", "#", "/layout/admin/_recoveryOrder.jsp"));
        pageRoute.put(PageType.ADMIN_DETAIL_ORDER_PAGE, new PageInfo("Chi tiết đơn hàng", "#", "/layout/admin/_detailOrder.jsp"));
        pageRoute.put(PageType.ADMIN_STATISTICAL_PRODUCT_PAGE, new PageInfo("Thống kê các sản phẩm", "#", "/layout/admin/_sellingProduct.jsp"));
    }

    // Chuẩn bị và chuyển hướng đến trang
    public static void prepareAndForwardIndex(HttpServletRequest request, HttpServletResponse response, PageType pageType)
            throws ServletException, IOException {
    	try {
    		// Dựa vào pageType được truyền vào, để lấy giá trị thông tin của pageRoute
            PageInfo page = pageRoute.get(pageType);

            // Đặt đối tượng PageInfo vào thuộc tính của yêu cầu
            request.setAttribute("page", page);
            // Chuyển hướng yêu cầu và phản hồi đến trang
            request.getRequestDispatcher("/layoutIndex.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        
    }
    
    public static void prepareAndForwardAdmin(HttpServletRequest request, HttpServletResponse response, PageType pageType)
            throws ServletException, IOException {
    	try {
    		// Dựa vào pageType được truyền vào, để lấy giá trị thông tin của pageRoute
            PageInfo page = pageRoute.get(pageType);

            // Đặt đối tượng PageInfo vào thuộc tính của yêu cầu
            request.setAttribute("page", page);
            // Chuyển hướng yêu cầu và phản hồi đến trang
            request.getRequestDispatcher("/layout/admin/layout.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        
    }

    private String title;
    private String cssUrl;
    private String contentUrl;

    public PageInfo() {
    }

    public PageInfo(String title, String cssUrl, String contentUrl) {
        this.title = title;
        this.cssUrl = cssUrl;
        this.contentUrl = contentUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCssUrl() {
        return cssUrl;
    }

    public void setCssUrl(String cssUrl) {
        this.cssUrl = cssUrl;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }
}
