<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="detailOrder container p-4">
    <h3>Chi tiết đơn hàng</h3>
    <div class="row">
    	<jsp:include page="/layout/message/inform.jsp"></jsp:include>
        <div class="col-md-4">
            <img src="./images/user/${order.invoice.product.images }" style="width: 300px; height: 350px;" class="img-fluid" alt="">
        </div>
        <div class="col-md-8">
            <form action="" method="post">
                <div class="row">
                    <div class="col-md-6">
                        <p>Mã hóa đơn: ${order.invoice.id}</p>
                        <p>Tên đơn hàng:${order.invoice.product.nameProduct }</p>
                        <p>Mã sản phẩm: ${order.invoice.product.id}</p>
                        <p>Giá sản phẩm: <fmt:formatNumber type="number" value="${order.invoice.product.price }" pattern="#,##0 VNĐ"></fmt:formatNumber> </p>
                        <p>Số lượng: ${order.invoice.quantity }</p>
                        <p>Tổng giá trị: <fmt:formatNumber type="number" value="${order.invoice.totalMoney }" pattern="#,##0 VNĐ"></fmt:formatNumber></p>
                    </div>
                    <div class="col-md-6">
                        <p>Ngày đặt: <fmt:formatDate value="${order.invoice.product.createDate }" pattern="dd/MM/yyyy" /></p>
                        <p>Người đặt: ${order.user.fullname } (${order.user.username })</p>
                        <p>Số điện thoại: ${order.invoice.phone }</p>
                        <p>Địa chỉ: ${order.invoice.placeDelivery }</p>
                        <p>Trạng thái đơn hàng:</p>
                        <select class="form-select" name="statuss" aria-label="Default select example" style=" background: unset; border: 1px solid orange;">
                            <option value="Chờ duyệt" ${order.statuss eq  'Chờ duyệt' ? 'selected' : '' }>Chờ duyệt</option>
                            <option value="Đang xử lý" ${order.statuss eq  'Đang xử lý' ? 'selected' : '' } >Đang xử lý</option>
                            <option value="Đang giao" ${order.statuss eq  'Đang giao' ? 'selected' : '' } >Đang giao</option>
                            <option value="Đã giao" ${order.statuss eq  'Đã giao' ? 'selected' : '' }>Đã giao</option>
                            <option value="Hủy mua" ${order.statuss eq  'Hủy mua' ? 'selected' : '' }>Hủy mua</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="mb-3">
                        <label for="descriptions" class="form-label">Ghi chú:</label>
                        <textarea class="form-control" name="descriptions" id="descriptions" rows="3"
                        style=" background-color: unset; border: 1px solid orange;">${order.descriptions }</textarea>
                    </div>
                </div>

                <button class="btn btn-outline-danger" type="submit">Xác nhận</button>
            </form>
        </div>            
    </div>
</div>