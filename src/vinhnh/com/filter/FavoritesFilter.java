package vinhnh.com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CartFilter
 */
@WebFilter({"/favorites","/favorite-insert","/favorite-delete"})
public class FavoritesFilter extends HttpFilter implements Filter {

    public FavoritesFilter() {
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
