package vinhnh.com.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
public class SessionUtils {

    // Phương thức thêm thuộc tính vào phiên
    public static void add(HttpServletRequest request, String name, Object value) {
        HttpSession session = request.getSession();
        session.setAttribute(name, value);
    }

    // Phương thức lấy giá trị của một thuộc tính từ phiên
    public static Object get(HttpServletRequest request, String name) {
        HttpSession session = request.getSession();
        return session.getAttribute(name);
    }

    // Phương thức hủy bỏ phiên và loại bỏ một thuộc tính cụ thể từ phiên
    public static void invalidate(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("username"); // Loại bỏ thuộc tính "username" từ phiên
        session.invalidate(); // Hủy bỏ toàn bộ phiên
    }

    // Phương thức kiểm tra xem người dùng có đăng nhập hay không
    public static boolean isLogin(HttpServletRequest request) {
        return get(request, "username") != null;
    }

    // Phương thức lấy tên người dùng đã đăng nhập từ thuộc tính "username" trong phiên
    public static String getLoginedUsername(HttpServletRequest request) {
        Object username = get(request, "username");
        return username == null ? null : username.toString();
    }
}
