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

@WebFilter(urlPatterns = "/invoices")
public class InvoicesFilter extends HttpFilter implements Filter {

    public InvoicesFilter() { 
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Kiểm tra xem người dùng đã đăng nhập hay chưa
        String username = (String) httpRequest.getSession().getAttribute("username");
        if (username != null) {
        	chain.doFilter(request, response); 
        } else {
            // Người dùng chưa đăng nhập, chuyển hướng đến trang đăng nhập
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
        }
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
