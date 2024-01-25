<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="sttOrder container">
    <div class="row p-4">
        <h4>Giỏ hàng của bạn</h1>
    </div>
    <table class="table table-striped table-hover">
        <thead class="thead-dark">
          <tr>
            <th scope="col">Ảnh sản phẩm</th>
            <th scope="col">Tên sản phẩm</th>
            <th scope="col">Mã sản phẩm</th>
            <th scope="col">Đợn giá</th>
            <th scope="col">Số lượng</th>
            <th scope="col">Thành tiền</th>
            <th scope="col">Xóa</th>
            <th scope="col">Mua Sản Phẩm</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cart" items="${carts }">
          <tr class="flex-fill align-middle">
            <td>
              <img src="./images/user/${cart.images }" alt="" width="140" height="180" class="img-fluid text-center">
            </td>
            <td>${cart.tenSP }</td>
            <td>${cart.maSP }</td>
            <td><fmt:formatNumber value="${cart.donGia}" pattern="#,##0 VNĐ"/></td>
            <td>${cart.soLuong }</td>
            <td><fmt:formatNumber value="${cart.thanhTien}" pattern="#,##0 VNĐ"/></td>
            <td>
              <a href="cart-delete?product=${cart.maSP }" class="btn btn-outline-danger">Xóa</a>
            </td>
            <td>
              <a href="invoices?product=${cart.maSP}&quantity=${cart.soLuong }" class="btn btn-outline-success">Mua</a>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
</div>