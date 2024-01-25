<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!Doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <base href="/WebShopMegaAnime/">
    <link rel="icon" href="./images/login/logo.png" type="image/x-icon">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
        integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
        crossorigin="anonymous" referrerpolicy="no-referrer" /> 
    <script src="https://kit.fontawesome.com/ae360af17e.js" crossorigin="anonymous"></script>
    <title>${page.title }</title>
    <link rel="stylesheet" href="./css/site/style.css">
    <link rel="stylesheet" href="${page.cssUrl}">
</head>

<body>
    <div class="app-mega container-fluid">
        <!-- Navbar star -->
        <nav class="navbar navbar-expand-lg" id="navbar">
            <div class="container-fluid">
                <a class="navbar-brand" href="home">
                    <img src="./images/login/logo.png" width="40" height="40" alt="" />
                    <h6>Mega <span>Shop</span></h6>
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll"
                    aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon" style="color: white;">&#9776;</span>
                </button>
                <div class="collapse navbar-collapse" id="navbarScroll">
                    <ul class="navbar-nav me-auto my-2 my-lg-0 " style="--bs-scroll-height: 100px;">
                        <li class="nav-item">
                            <a class="nav-link" href="home">Trang chủ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="product?page=1">Sản phẩm</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                                data-bs-toggle="dropdown" aria-expanded="false">
                                Mega Anime
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            	<c:forEach var="categori" items="${category}">
								    <li><a class="dropdown-item" href="prod-mega?categori=${categori }&page=1">${categori}</a></li>
								</c:forEach>
                                
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Liên hệ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Đánh giá chất lượng</a>
                        </li>
                    </ul>
                    <form class="d-flex" method="post">
                        <input class="form-control me-2" type="search" name="search" placeholder="Tìm kiếm sản phẩm"
                            aria-label="Search">
                        <button class="btn btn-search" type="submit" formaction="search"><i class="fas fa-search"></i></button>
                    </form>
                    <c:if test="${not isLogin}">
                    <li class="nav-item">
                        <a class="nav-link" href="login">Đăng nhập</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="register">Đăng ký</a>
                    </li>
                    </c:if>
                    <c:if test="${isLogin}">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarScrollingDropdown" role="button"
                            data-bs-toggle="dropdown" aria-expanded="false">
                            <img class="avatar" src="./images/user/${avatar }" width="40" height="40" alt="">
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
                        	<li><h6 style="margin-left: 16px;font-size: large;font-weight: 700;color: red;">${name }</h6></li>
                            <li><a class="dropdown-item" href="change-information">Thay đổi thông tin</a></li>
                            <li><a class="dropdown-item" href="change-password">Đổi mật khẩu</a></li>
                            <c:if test="${role eq 'admin' }">
                            	<li><a class="dropdown-item" href="admin">Chuyển trang quảng trị</a></li>
                            </c:if>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="history-order">Lịch sử mua hàng</a></li>
                            <li><a class="dropdown-item" href="sttOrders">Trạng thái đơn hàng</a></li>
                            <li><a class="dropdown-item" href="logout">Đăng xuất</a></li>
                        </ul>
                    </li>
                    </c:if>


                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="favorites">
                            <div class="icon-container">
                                <i class="fas fa-heart"></i> <!-- Biểu tượng trái tim -->
                                <span class="badge">${coutFavorite }</span> <!-- Số hiển thị trên biểu tượng -->
                            </div>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="carts">
                            <div class="icon-container">
                                <i class="fas fa-shopping-cart"></i> <!-- Biểu tượng giỏ hàng -->
                                <span class="badge">${coutCart}</span> <!-- Số hiển thị trên biểu tượng -->
                            </div>
                        </a>
                    </li>
                </div>
            </div>
        </nav>
        <!-- Navbar end -->
        <jsp:include page="${page.contentUrl }"></jsp:include>
        <footer class="container-fluid">
            <div class="row mt-4">
                <div class="col-md-3 mt-4">
                    <h6 class="text-center">
                        Về chúng tôi
                    </h6>
                    <ul>
                        <li><a href="#">Về chúng tôi</a></li>
                        <li><a href="#">Liên hệ</a></li>
                        <li><a href="#">Chính sách bảo mật thông tin</a></li>
                    </ul>
                </div>
                <div class="col-md-3 mt-4">
                    <h6 class="text-center">
                        Thông tin liên hệ
                    </h6>
                    <ul>
                        <li><i class="fas fa-map-marker-alt"></i>Địa chỉ: 
                            <p>19A Tân Thuận Tây, phường Bình Thuận,Q.7, Tp Hồ Chí Minh</p></li>
                        <li><i class="fas fa-phone"></i>Điện thoại:
                            <p>0399989849</p>
                        </li>
                        <li><i class="fas fa-envelope"></i>Email: <p>vinhnh.2312@gmail.com</p></li>
                        <li><i class="far fa-clock"></i>Thơi gian làm việc: 
                            <p>Tất cả trong tuần 9:00 AM - 10:00 PM</p>
                        </li>
                    </ul>
                </div>
                <div class="col-md-6 mt-3 mb-3">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3919.804972975635!2d106.72746699999999!3d10.749509!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317525813355f181%3A0x9f63ab7437a64d1a!2zMTlhIFTDom4gVGh14bqtbiBUw6J5LCBRdeG6rW4gNywgVGjDoG5oIHBo4buRIEjhu5MgQ2jDrSBNaW5o!5e0!3m2!1svi!2s!4v1704038118508!5m2!1svi!2s" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                </div>
            </div>
            <div class="row text-center">
                <p style="color: white; font-size: small;"> Mega Shop &copy; Copyright 2023. Nguyễn Hoàng Vinh.</p>
            </div>
        </footer>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous">
    </script>
    
	<!-- Bao gồm thư viện jQuery -->
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script src="./js/upfile.js"></script>
    <script>
	 // Thực hiện tính toán khi trang được tải
	    document.addEventListener("DOMContentLoaded", function() {
	        calculateTotal();
	    });
	    function calculateTotal() {
	        var quantity = document.getElementById('quantity').value;
	        var price = ${product.price}; // Giá sản phẩm (lấy từ JSP)
	        var totalAmount = quantity * price;
	
	        // Format và cập nhật giá trị thành tiền
	        document.getElementById('totalAmount').innerText = new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(totalAmount);
	    }
	</script>	
	
</body>

</html>