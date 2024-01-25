<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- Product begin -->
<main class="container product" id="product">
    <h3 class="text-center product-text">Sản phẩm về ${caterogi }</h3>

    <!-- Card begin -->
    <div class="row g-2 bestsellerCard">
        <c:forEach var="product" items="${productList }">
	        <div class="col-md-3 d-flex justify-content-center">
	        	<a href="detail?idproduct=${product.id }" style="text-decoration: none;color: black;">
	            <div class="card p-2">
	                <div class="text-center"> <img src="./images/user/${product.images }" class="img-fluid" /> </div>
	                <div class="content">
	                    <div class="justify-content-between align-items-center"> 
	                        <div class="row">
	                       		<div class="col-md-8">
	                           		<span class="category">${product.nameProduct }</span> 
	                       		</div>
	                       		<div class="col-md-4">
		                            <span class="price">
										<fmt:formatNumber value="${product.price}" pattern="#,##0 VNĐ"/>
									</span> 
	                       		</div>
	                       	</div>
	                    </div>
	                    <p>${product.characterName }</p>
	             </a>
	                    <div class="buttons d-flex justify-content-center"> 
	                        
							<c:set var="isLiked" value="false" />
							<c:forEach var="like" items="${checkLike}">
							    <c:if test="${like.maSP eq product.id}">
							        <c:set var="isLiked" value="true" />
							    </c:if>
							</c:forEach>
							
							<c:choose>
							    <c:when test="${isLiked}">
							        <!-- Nếu product.id có trong danh sách checkLike -->
							        <a href="favorite-delete?idproduct=${product.id}" style="color: red;" class="btn btn-heart"><i class="fas fa-heart"></i></i></a>
							    </c:when>
							    <c:otherwise>
							        <!-- Nếu product.id không có trong danh sách checkLike -->
							        <a href="favorite-insert?product=${product.id}" class="btn btn-heart"><i class="fas fa-heart"></i></i></a>
							    </c:otherwise>
							</c:choose>

	                        <a href="invoices?product=${product.id}" class="btn btn-outline-danger mr-1">Mua ngay</a> 
	                        <a href="cart-insert?product=${product.id }" class="btn btn-shopping-cart"><i class="fas fa-shopping-cart"></i></a> 
	                    </div>
	                </div>
	            </div>
	        </div> 
	    </c:forEach>

    </div>
    <div class="m-3 d-flex justify-content-center">
        <div class="row">
			<c:if test="${totalRecords > 8}">
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
					        <a class="page-link" href="<c:url value='/prod-mega?categori=${caterogi }'/>&page=${currentPage - 1}">Previous</a>
					    </li>
					</c:if>
					
					<c:forEach begin="${startPage}" end="${endPage}" var="page">
					    <li class="page-item">
					        <a class="page-link" 
					           <c:if test="${page == currentPage}">
					               style="background-color: darkgreen;"
					           </c:if>
					           href="<c:url value='/prod-mega?categori=${caterogi }'/>&page=${page}">${page}</a>
					    </li>
					</c:forEach>
					
					<c:if test="${currentPage < totalPages}">
					    <li class="page-item">
					        <a class="page-link" href="<c:url value='/prod-mega?categori=${caterogi }'/>&page=${currentPage + 1}">Next</a>
					    </li>
					</c:if>
					
					
				</ul>
			</c:if>
			</div>
    </div>
    <!-- Card end -->
</main>
<!-- Product end -->