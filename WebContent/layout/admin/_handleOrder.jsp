<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- Xử lý đơn hàng -->
<div class="p-4 handle-order">
	<h3>Các đơn hàng cần xử lý</h1>
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
            <th scope="col">Xử lý đơn</th>
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
            <td> ${order.invoice.quantity }</td>
            <td>
            	<fmt:formatNumber type="number" value="${order.invoice.totalMoney }" pattern="#,##0 VNĐ"></fmt:formatNumber>
            </td>
            <td><fmt:formatDate value="${order.invoice.product.createDate }" pattern="dd/MM/yyyy" /></td>
            <td>${order.statuss }</td>
            <td>${order.user.username }</td>
            <td>
              <a href="#" class="btn btn-outline-success"><i class="fas fa-truck"></i> Vận chuyển</a> | 
              <a href="#" class="btn btn-outline-danger"><i class="fas fa-times"></i> Hủy</a>
            </td>
            <td>
              <a href="#"><i class="fas fa-info-circle"></i></a>
            </td>
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
					        <a class="page-link" href="<c:url value='/admin/list-products'/>?page=${currentPage - 1}">Previous</a>
					    </li>
					</c:if>
					
					<c:forEach begin="${startPage}" end="${endPage}" var="page">
					    <li class="page-item">
					        <a class="page-link" 
					           <c:if test="${page == currentPage}">
					               style="background-color: darkgreen;"
					           </c:if>
					           href="<c:url value='/admin/list-products'/>?page=${page}">${page}</a>
					    </li>
					</c:forEach>
					
					<c:if test="${currentPage < totalPages}">
					    <li class="page-item">
					        <a class="page-link" href="<c:url value='/admin/list-products'/>?page=${currentPage + 1}">Next</a>
					    </li>
					</c:if>
					
					
				</ul>
			</c:if>
			</div>
</div>