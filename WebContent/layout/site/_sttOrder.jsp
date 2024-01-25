<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

 <div class="sttOrder p-3">
 	<div class="row p-4">
            <h1 class="text-center " style="color: #f78e31">TRẠNG THÁI ĐƠN HÀNG</h1>
    </div>
    <table class="table table-striped table-hover">
        <thead class="thead-dark">
          <tr>
            <th scope="col">Mã HĐ</th>
            <th scope="col">Tên SP</th>
            <th scope="col">Mã SP</th>
            <th scope="col">Giá</th>
            <th scope="col">Số Lượng</th>
            <th scope="col">Thành tiền</th>
            <th scope="col">Ngày đặt</th>
            <th scope="col">Trang thái</th>
            <th scope="col">Mô tả trạng thái</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
	        <c:forEach var="order" items="${orderStt }">
	        	<c:if test="${order.stt != 'Đã nhận' && order.stt != 'Hủy mua'}">
		          <tr>
		            <th scope="row">${order.maHD }</th>
		            <td>${order.tenSP }</td>
		            <td>${order.maSP }</td>
		            <td><fmt:formatNumber value="${order.gia}" pattern="#,##0 VNĐ"/></td>
		            <td>${order.soLuong }</td>
		            <td><fmt:formatNumber value="${order.tongTien}" pattern="#,##0 VNĐ"/></td>
		            <td><fmt:formatDate value="${order.ngayDat}" pattern="dd-MM-yyyy"/></td>
		            <td>${order.stt }</td>
		            <td><span>${order.moTa }</span></td>
		            <td><a href="cancel-sttOrder?id=${order.id }" class="btn btn-outline-danger" >Hủy mua</a></td>
		          </tr>
		         </c:if>
	        </c:forEach>
        </tbody>
      </table>
</div>