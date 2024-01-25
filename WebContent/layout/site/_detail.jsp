<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- detail begin -->
<main class="container detail" id="detail">
    <div class="row p-4 mt-4">
        <div class="col-md-5">
            <!-- style="box-shadow: rgba(0, 0, 0, 0.07) 0px 1px 2px, rgba(0, 0, 0, 0.07) 0px 2px 4px, rgba(0, 0, 0, 0.07) 0px 4px 8px, rgba(0, 0, 0, 0.07) 0px 8px 16px, rgba(0, 0, 0, 0.07) 0px 16px 32px, rgba(0, 0, 0, 0.07) 0px 32px 64px;"> -->
            <img src="./images/user/${product.images }" class="img-fluid">
        </div>
        <div class="col-md-7 content">
            <h6 class="detail-nameProduct">${product.nameProduct }</h6>
            <h6 class="detail-price"><fmt:formatNumber value="${product.price}" pattern="#,##0 VNĐ"/></h6>
            <span>Thông tin sản phẩm</span>
            <p>Mã sản phẩm: <span>${product.id }.</span></p>
            <p>Tên nhân vật: <span>${product.characterName }.</span></p>
            <p>Mega Anime: <span>${product.mageAnime }.</span></p>
            <p>Wight: <span>${product.wight }cm</span> x Height: <span>${product.height }cm.</span></p>
            <p>Năng: <span>${product.gram } gram.</span></p>
            <div class="group-btn">
                <a href="cart-insert?product=${product.id}" class="btn btn-outline-danger"><i class="fas fa-shopping-cart"></i> Thêm Vào Giỏ Hàng</a>
                <a href="invoices?product=${product.id}" class="btn btn-outline-success">Mua Ngay</a>
            </div>
        </div>
    </div>
    
    <div class="row description">
        <h6>Mô tả sản phẩm</h6>
        <p> ${product.descriptions }
        </p>
    </div>
</main>
<!-- detail end -->
<!-- Sản phẩm bán chạy begin-->
<section id="bestseller" class="bestseller">
    <div class="container">
        <div class="bestsellertitel">
            <h3>Sản phẩm <span>liên quan</span></h1>
        </div>
        <div class="row g-2 bestsellerCard">
           <c:forEach var="product" items="${listProduct }" begin="0" end="3">
            	<div class="col-md-3 d-flex justify-content-center">
	                <div class="card p-2">
	                    <a href="detail?idproduct=${product.id }" style="text-decoration: none;color: black;">
	                    <div class="text-center"> 
	                    	<img src="./images/user/${product.images}" class="img-fluid" style="object-fit: contain;">
	                   	</div>
	                    <div class="content">
	                
		                        <div class="d-flex justify-content-between align-items-center"> 
		                        	<div class="row">
		                        		<div class="col-md-8">
		                            		<span class="category">${product.nameProduct }</span> 
		                        		</div>
		                        		<div class="col-md-4 p-0">
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
	                            <a href="invoices?product=${product.id }" class="btn btn-outline-danger mr-1">Mua ngay</a> 
	                            <a href="cart-insert?product=${product.id}" class="btn btn-shopping-cart"><i class="fas fa-shopping-cart"></i></a> 
	                        </div>
	                    </div>
	                </div>
	            </div>
            </c:forEach>
        </div>
    </div>
</section>
<!-- Sản phẩm bán chạy end -->
    
<div class="row d-flex justify-content-center"> 
    <a href="prod-mega?categori=${product.mageAnime  }&page=1" class="btn btn-outline-danger" style="width: 100px;
    margin-top: 60px; margin-bottom: 20px;">Xem thêm</a>
</div>