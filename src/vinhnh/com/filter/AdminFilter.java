package vinhnh.com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vinhnh.com.dao.UserDao;
import vinhnh.com.model.User;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter(urlPatterns = "/admin/*")
public class AdminFilter implements Filter {
   
    public AdminFilter() {
    }
    
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Kiểm tra xem người dùng đã đăng nhập hay chưa
        String username = (String) httpRequest.getSession().getAttribute("username");

        if (username != null) {
            // Người dùng đã đăng nhập, kiểm tra quyền admin
            User user = new UserDao().findByUsername(username);

            if (user != null && user.getRole() != null && user.getRole().getPosition().equals("admin")) {
                // Người dùng có quyền admin, cho phép truy cập trang yêu cầu
                chain.doFilter(request, response);
            } else {
                // Người dùng không có quyền admin, xóa Cookie và Session
                Cookie[] cookies = httpRequest.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("username")) {
                            // Đặt thời gian sống của cookie là 0 để xóa nó
                            cookie.setMaxAge(0);
                            httpResponse.addCookie(cookie);
                            break;
                        }
                    }
                }

                HttpSession session = httpRequest.getSession(false);
                if (session != null) {
                    // Hủy bỏ Session
                    session.invalidate();
                }

                // Chuyển hướng đến trang đăng nhập
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            }
        } else {
            // Người dùng chưa đăng nhập, chuyển hướng đến trang đăng nhập
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
        }
	}

	public void init(FilterConfig fConfig) throws ServletException { 
	}

}
