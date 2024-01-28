<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- Các đơn hàng đang giao -->
<div class="p-4 delivering">
	<h3>Các đơn hàng đang giao</h1>
	<jsp:include page="/layout/message/inform.jsp"></jsp:include>
	<table class="table table-hover table table-striped container">
       <thead>
         <tr>
           <th scope="col">Mã HĐ</th>
           <th scope="col">Ảnh</th>
           <th scope="col">Mã SP</th>
           <th scope="col">Giá</th>
           <th scope="col">Số Lượng</th>
           <th scope="col">Thành Tiền</th>
           <th scope="col">Ngày Đặt</th>
           <th scope="col">Trạng Thái</th>
           <th scope="col">Người Đặt</th>
           <th scope="col">Xác nhận đã giao</th>
           <th scope="col">Xem chi tiết</th>
         </tr>
       </thead>
       <tbody>
       <c:forEach var="order" items="${orderList }">
         <tr>
           <th scope="row">${order.invoice.id}</th>
           <td>
           		<img alt="Chờ duyệt" src="./images/user/${order.invoice.product.images }" style="width: 100px; height: 150px" class="img-fluid"/>
           </td>
           <td>${order.invoice.product.id}</td>
           <td>
           		<fmt:formatNumber type="number" value="${order.invoice.product.price }" pattern="#,##0 VNĐ"></fmt:formatNumber>
           </td>
           <td>${order.invoice.quantity }</td>
           <td><fmt:formatNumber type="number" value="${order.invoice.totalMoney }" pattern="#,##0 VNĐ"></fmt:formatNumber></td>
           <td><fmt:formatDate value="${order.invoice.product.createDate }" pattern="dd/MM/yyyy" /></td>
           <td>${order.statuss }</td>
           <td>${order.user.username }</td>
           <td>
             <a href="#" style="color: green"><i class="fas fa-check-circle"></i></a> 
           </td>
           <td>
             <a href="#"><i class="fas fa-info-circle"></i></a>
           </td>
         </tr>
       </c:forEach>
       </tbody>
     </table>
</div>