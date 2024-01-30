<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en" data-bs-theme="dark">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <base href="/WebShopMegaAnime/">
    <title>${page.title }</title>
    <link rel="icon" href="./images/login/logo.png" type="image/x-icon">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css">
    <script src="https://kit.fontawesome.com/ae360af17e.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./css/admin/admin.css">
    <link rel="stylesheet" href="${page.cssUrl }">
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
    	<jsp:include page="/js/${linkScript}"></jsp:include>
    </script>
</head>

<body>
    <div class="wrapper">
        <aside id="sidebar" class="js-sidebar">
            <!-- Content For Sidebar -->
            <div class="h-100">
                <div class="sidebar-logo">
                    <a href="home">Mega Shop</a>
                </div>
                <ul class="sidebar-nav">
                    <li class="sidebar-header">
                        Admin Elements
                    </li>
                    <li class="sidebar-item">
                        <a href="admin" class="sidebar-link">
                            <i class="fa-solid fa-list pe-2"></i>
                            Trang chính
                        </a>
                    </li>
                    <li class="sidebar-item">
                        <a href="#" class="sidebar-link collapsed" data-bs-target="#pages" data-bs-toggle="collapse"
                            aria-expanded="false"><i class="fas fa-chart-bar"></i>
                            Thống kê
                        </a>
                        <ul id="pages" class="sidebar-dropdown list-unstyled collapse" data-bs-parent="#sidebar">
                            <li class="sidebar-item">
                                <a href="admin/top5-best-selling-product" class="sidebar-link">Thống kê sản phẩm</a>
                            </li>
                            <li class="sidebar-item">
                                <a href="#" class="sidebar-link">Page 2</a>
                            </li>
                        </ul>
                    </li>
                    <li class="sidebar-item">
                        <a href="#" class="sidebar-link collapsed" data-bs-target="#posts" data-bs-toggle="collapse"
                            aria-expanded="false"><i class="fas fa-tag"></i>
                            Sản phẩm
                        </a>
                        <ul id="posts" class="sidebar-dropdown list-unstyled collapse" data-bs-parent="#sidebar">
                            <li class="sidebar-item">
                                <a href="admin/admin-product" class="sidebar-link">Thêm sản phẩm</a>
                            </li>
                            <li class="sidebar-item">
                                <a href="admin/list-products?page=1" class="sidebar-link">Xem danh sách sản phẩm</a>
                            </li>
                        </ul>
                    </li>
                    <li class="sidebar-item">
                        <a href="#" class="sidebar-link collapsed" data-bs-target="#auth" data-bs-toggle="collapse"
                            aria-expanded="false"><i class="fa-regular fa-user pe-2"></i>
                            Users
                        </a>
                        <ul id="auth" class="sidebar-dropdown list-unstyled collapse" data-bs-parent="#sidebar">
                            <li class="sidebar-item">
                                <a href="admin/admin-user" class="sidebar-link">Thêm tài khoản</a>
                            </li>
                            <li class="sidebar-item">
                                <a href="admin/list-users?page=1" class="sidebar-link">Xem danh sách tài khoản </a>
                            </li>
                            <li class="sidebar-item">
                                <a href="admin/roles" class="sidebar-link">Thêm chức vụ</a>
                            </li>
                        </ul>
                    </li>
                     <li class="sidebar-item">
                        <a href="#" class="sidebar-link collapsed" data-bs-target="#order" data-bs-toggle="collapse"
                            aria-expanded="false"><i class="fas fa-shopping-cart"></i>
                             Đơn hàng
                        </a>
                        <ul id="order" class="sidebar-dropdown list-unstyled collapse" data-bs-parent="#sidebar">
                            <li class="sidebar-item">
                                <a href="admin/all-orders?page=1" class="sidebar-link"> Tất cả đơn hàng</a>
                            </li>
                            <li class="sidebar-item">
                                <a href="admin/approver-order" class="sidebar-link"> Chờ duyệt</a>
                            </li>
                            <li class="sidebar-item">
                                <a href="admin/handle-order" class="sidebar-link"> Đang xử lý</a>
                            </li>
                            <li class="sidebar-item">
                                <a href="admin/delivering-order" class="sidebar-link"> Đang Giao</a>
                            </li>
                            <li class="sidebar-item">
                                <a href="admin/received-order" class="sidebar-link"> Đã Giao</a>
                            </li>
                            <li class="sidebar-item">
                                <a href="admin/recovery-order" class="sidebar-link"> Đã Hủy</a>
                            </li>
                        </ul>
                    </li>
                    <li class="sidebar-header">
                        Multi Level Menu
                    </li>
                    <li class="sidebar-item">
                        <a href="#" class="sidebar-link collapsed" data-bs-target="#multi" data-bs-toggle="collapse"
                            aria-expanded="false"><i class="fa-solid fa-share-nodes pe-2"></i>
                            Multi Dropdown
                        </a>
                        <ul id="multi" class="sidebar-dropdown list-unstyled collapse" data-bs-parent="#sidebar">
                            <li class="sidebar-item">
                                <a href="#" class="sidebar-link collapsed" data-bs-target="#level-1"
                                    data-bs-toggle="collapse" aria-expanded="false">Level 1</a>
                                <ul id="level-1" class="sidebar-dropdown list-unstyled collapse">
                                    <li class="sidebar-item">
                                        <a href="#" class="sidebar-link">Level 1.1</a>
                                    </li>
                                    <li class="sidebar-item">
                                        <a href="#" class="sidebar-link">Level 1.2</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </aside>
        <div class="main">
            <nav class="navbar navbar-expand px-3 border-bottom">
                <button class="btn" id="sidebar-toggle" type="button">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="navbar-collapse navbar">
                    <ul class="navbar-nav">
                        <li class="nav-item dropdown">
                            <a href="#" data-bs-toggle="dropdown" class="nav-icon pe-md-0">
                                <img src="./images/user/${avatar }" class="avatar img-fluid rounded" alt="">
                            </a>
                            <div class="dropdown-menu dropdown-menu-end">
                            	<h6 class="text-center p-2" style="color: red; font-weight: bold;">${name}</h6>
                                <a href="#" class="dropdown-item">Profile</a>
                                <a href="#" class="dropdown-item">Setting</a>
                                <a href="logout" class="dropdown-item">Logout</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
            <a class="theme-toggle">
                <i class="fa-regular fa-moon"></i>
                <i class="fa-regular fa-sun"></i>
            </a>
            <main class="content px-3 py-2">
            <jsp:include page="${page.contentUrl }"></jsp:include>
            </main>
            
            <footer class="footer">
                <div class="container-fluid">
                    <div class="row text-muted">
                        <div class="col-6 text-start">
                            <p class="mb-0">
                                <a href="#" class="text-muted">
                                    <strong>Mega Shop</strong>
                                </a>
                            </p>
                        </div>
                        <div class="col-6 text-end">
                            <ul class="list-inline">
                                <li class="list-inline-item">
                                    <a href="home" class="text-muted">Trang chủ</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="#" class="text-muted">Liên hệ</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="admin/list-products?page=1" class="text-muted">Xem sản phẩm</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="#" class="text-muted">Thống kê</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-4s0geq5m1RgSm8g5rl5eA5M6N2w2O7i+y2B5G5B6XztEJlLUNM5EaRj2iX2Btk6M" crossorigin="anonymous"></script>
    <script src="./js/admin.js"></script>
    <script src="./js/upfile.js"></script>
</body>

</html>
