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
        pageRoute.put(PageType.INDEX_DETAIL_PAGE, new PageInfo("Detail Mega", "./css/site/detail.css", "/layout/site/_detail.jsp"));
        pageRoute.put(PageType.INDEX_INVOICES_PAGE, new PageInfo("Invoices Mega", "./css/site/invoices.css", "/layout/site/_invoices.jsp"));
        
        pageRoute.put(PageType.ADMIN_HOME_PAGE, new PageInfo("Admin Mega", "#", "/layout/admin/_main.jsp"));
        pageRoute.put(PageType.ADMIN_PRODUCT_PAGE, new PageInfo("Product Admin", "./css/admin/adProduct.css", "/layout/admin/_product.jsp"));
        pageRoute.put(PageType.ADMIN_LIST_PRODUCT_PAGE, new PageInfo("Danh sách sản phẩm Mega", "#", "/layout/admin/_tableProduct.jsp"));
    
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
