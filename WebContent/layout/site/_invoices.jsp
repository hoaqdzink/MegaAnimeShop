<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- Content begin -->
<section class="invoices container">
    <form action="" method="post" class="container">
        <h1 class="mt-3 text-center">Thông tin hóa đơn</h1>
        <div class="form-group">
            <div class="row">
                <div class="col-md-1"></div>
                <div class="col-md-1">
                    <img src="./images/user/${product.images }" width="100px" height="100px" alt="">
                </div>
                <div class="col-md-3">
                    <p>Mã sp: ${product.id }</p>
                    <p>Tên sp: ${product.nameProduct }</p>
                    <p>Mega Anime: ${product.mageAnime }</p>
                </div>
                <div class="col-md-6">
                <jsp:include page="/layout/message/inform.jsp"></jsp:include>
                    <div class="form-inline">
                    	<input type="hidden" name="productId" value="${product.id }"/>
                        <label for="">Giá sản phẩm: </label>
                        <span><fmt:formatNumber value="${product.price}" pattern="#,##0 VNĐ"/></span>
                    </div>
                    <div class="form-inline">
                       <label for="quantity">Số lượng:</label>
                       <input type="number" name="quantity" id="quantity" class="form-control" min="1" value="${quantity != null ? quantity : 1}" style="width: 100px" onchange="calculateTotal()">
                    </div>
                    <div class="form-group">
                        <label for="PlaceDelivery">Địa chỉ giao hàng:</label>
                        <input type="text" value="${user.locaAddress }" name="placeDelivery" id="PlaceDelivery" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="phone">SĐT giao hàng:</label>
                        <input type="text" name="phone" id="phone" value="${user.phone }"  class="form-control">
                    </div>
                    <div class="form-inline">
                         <h3>Thành tiền: <span id="totalAmount"><fmt:formatNumber value="${product.price}" pattern="#,##0 VNĐ"/></span></h3>
                	</div>
                    <div class="group-btn">
                        <button type="submit" class="btn btn-outline-danger"> Mua Hàng</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</section>
<!-- Content end -->