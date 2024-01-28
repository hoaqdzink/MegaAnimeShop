<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="p-4 all-order">
	<h1>Tất cả các đơn hàng</h1>
	<jsp:include page="/layout/message/inform.jsp"></jsp:include>
	<table class="table table-striped table-hover">
	  <thead>
	    <tr>
	      <th scope="col">Mã HĐ</th>
	      <th scope="col">Tên SP</th>
	      <th scope="col">Mã SP</th>
	      <th scope="col">Giá</th>
	      <th scope="col">Số Lượng</th>
	      <th scope="col">Thành Tiền</th>
	      <th scope="col">Ngày Đặt</th>
	      <th scope="col">Trạng Thái</th>
	      <th scope="col">Người Đặt</th>
	      <th scope="col">#</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach var="order" items="${orderList }">
	    <tr>
	      <th scope="row">${order.invoice.id}</th>
	      <td>${order.invoice.product.nameProduct }</td>
	      <td>${order.invoice.product.id }</td>
	      <td> 
	      	<fmt:formatNumber value="${order.invoice.product.price }" type="nuber" pattern="#,##0 VNĐ"></fmt:formatNumber>
	      </td>
	      <td>${order.invoice.quantity }</td>
	      <td>
	      	<fmt:formatNumber value=" ${order.invoice.totalMoney }" type="number" pattern="#,##0 VNĐ"></fmt:formatNumber>
	      </td>
	      <td>
	      	<fmt:formatDate value="${order.invoice.product.createDate }" pattern="dd/MM/yyyy" />
	      </td>
	      <td>
	      	${order.statuss }
	      </td>
	      <td>
	      	${order.user.username }
	      </td>
	      <td><i class="fas fa-info-circle"></i></td>
	    </tr>
	  
	  </c:forEach>
	  </tbody>
	</table>
	
	<div class="row">
	<c:if test="${totalRecords > 10}">
		<ul class="pagination">
		    
			
			<c:set var="startPage" value="${currentPage - 2}" />
			<c:set var="endPage" value="${currentPage + 2}" />
			
			<c:if test="${startPage < 1}">
			    <c:set var="startPage" value="1" />
			    <c:set var="endPage" value="${startPage + 4}" />
			</c:if>
			
			<c:if test="${endPage > totalPages}">
			    <c:set var="endPage" value="${totalPages}" />
			    <c:set var="startPage" value="${endPage - 4}" />
			</c:if>
			
			<c:choose>
			    <c:when test="${startPage < 0}">
			        <c:set var="startPage" value="1" />
			    </c:when>
			    <c:otherwise>
			        <!-- Không cần làm gì cả -->
			    </c:otherwise>
			</c:choose>
			
			<c:if test="${currentPage > 1}">
			    <li class="page-item">
			        <a class="page-link" href="<c:url value='/admin/all-orders'/>?page=${currentPage - 1}">Previous</a>
			    </li>
			</c:if>
			
			<c:forEach begin="${startPage}" end="${endPage}" var="page">
			    <li class="page-item">
			        <a class="page-link" 
			           <c:if test="${page == currentPage}">
			               style="background-color: darkgreen;"
			           </c:if>
			           href="<c:url value='/admin/all-orders'/>?page=${page}">${page}</a>
			    </li>
			</c:forEach>
			
			<c:if test="${currentPage < totalPages}">
			    <li class="page-item">
			        <a class="page-link" href="<c:url value='/admin/all-orders'/>?page=${currentPage + 1}">Next</a>
			    </li>
			</c:if>
			
			
		</ul>
	</c:if>
	</div>
</div>