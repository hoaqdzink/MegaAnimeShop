<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="sttOrder container"">
    <div class="row p-4">
        <h4>Sản phẩm yêu thích</h4>
    </div>
    <table class="table table-striped table-hover">
        <thead class="thead-dark">
          <tr>
            <th scope="col">#</th>
            <th scope="col">Ảnh sản phẩm</th>
            <th scope="col">Tên sản phẩm</th>
            <th scope="col">Mã sản phẩm</th>
            <th scope="col">Đợn giá</th>
            <th scope="col">Xem chi tiết sản phẩm</th>
            <th scope="col">Bỏ thích</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="favorite" items="${favoriteList }" varStatus="loop">
          <tr class="flex-fill align-middle">
            <th scope="row" class="text-center">${loop.index + 1}</th>
            <td>
              <img src="./images/user/${favorite.images }" alt="" width="140" height="180" class="img-fluid text-center">
            </td>
            <td>${favorite.tenSP }</td>
            <td>${favorite.maSP }</td>
            <td>
				<fmt:formatNumber value="${favorite.donGia}" pattern="#,##0 VNĐ"/>
			</td>
            <td>
              <a href="detail?idproduct=${favorite.maSP }" class="btn btn-outline-success">Xem chi tiết</a>
            </td>
            <td>
              <a href="favorite-delete?idproduct=${favorite.maSP }" class="btn btn-outline-danger">Bỏ thích</a>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
</div>