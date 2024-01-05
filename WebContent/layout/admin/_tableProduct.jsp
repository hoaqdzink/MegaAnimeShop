<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="table-product p-4">
	<h1>Danh sách sản phẩm</h1>
	<jsp:include page="/layout/message/inform.jsp"></jsp:include>
	<table class="table table-striped table-hover">
	    <thead>
	      <tr>
	        <th scope="col">ID</th>
	        <th scope="col">Tên Sản phẩm</th>
	        <th scope="col">Giá</th>
	        <th scope="col">Ảnh</th>
	        <th scope="col">Tên Nhân vật</th>
	        <th scope="col">Mega Anime</th>
	        <th scope="col">WxHxG</th>
	        <th scope="col">Người đăng</th>
	        <th scope="col">Giờ tạo</th>
	        <th scope="col"></th>
	        <th scope="col"></th>
	      </tr>
	    </thead>
	    <tbody>
	      <!-- Sử dụng forEach để lặp qua danh sách sản phẩm -->
	        <c:forEach var="product" items="${productList}" >
	            <tr>
	                <td>${product.id}</td>
	                <td>${product.nameProduct}</td>
	                <fmt:formatNumber value="${product.price}" type="number" pattern="#,##0" var="formatPrice" />
					<td>${formatPrice}VNĐ</td>
	                <td><img src="./images/user/${product.images}" width="60px" height="60px" alt=""></td>
	                <td>${product.characterName}</td>
	                <td>${product.mageAnime}</td>
	                <td>${product.wight}cmx${product.height}cmx${product.gram}g</td>
	                <td>${product.user.username}</td>
	                <td>${product.createDate}</td>
	                <td>
	                    <a href="admin/edit-product?id=${product.id }"><i class="fas fa-edit"></i></a>
	                </td>
	                <td>
	                    <a  href="admin/delete-product?id=${product.id }"><i class="fas fa-trash-alt" style="color: red;"></i></a>
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
