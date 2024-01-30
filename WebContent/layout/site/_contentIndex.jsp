<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 <!-- Giới thiệu mô hình begin -->
<section id="introduce" class="introduce">
   <div class="introduceText text-center">
       <h1>Mage <span>ANIME</span></h1>
   </div>
   <div class="introducePoke container">
   	
       <div class="row">
           <div class="col-md-4" style="margin-left: 50px;">
                <img src="./images/site/pokemon3.jpg" class="img-fluid" width="400px">
            </div>
            <div class="col-md-7">
                <p>Tại <span>Mega Shop</span>, chúng tôi tự hào giới thiệu bộ sưu tập đặc sắc của mô hình
                     Pokémon, nơi bạn có thể khám phá và sở hữu những tác phẩm nghệ thuật tinh tế và độc
                      đáo nhất. Dựa trên đam mê vô tận với thế giới Pokémon, chúng tôi đã tạo ra một 
                      không gian trực tuyến đặc biệt để các Huấn luyện viên có thể tận hưởng niềm đam mê
                       của mình và mở rộng bộ sưu tập Pokémon của mình.
                </p>
                <p>
                    Tại đây, bạn sẽ khám phá một loạt các mô hình Pokémon tuyệt vời, từ những tạo hình chân thực 
                    đến những phiên bản nghệ thuật sáng tạo. Chúng tôi tự hào cung cấp những sản phẩm chất lượng 
                    cao được làm từ các nguyên liệu an toàn, đảm bảo rằng mỗi mô hình không chỉ là một sản phẩm 
                    nghệ thuật mà còn là một cảm xúc đong đầy và sự kỳ diệu của thế giới Pokémon.
                </p>
                <p>
                    Với việc liên tục cập nhật bộ sưu tập, chúng tôi cam kết mang đến cho bạn trải nghiệm mua sắm 
                    độc đáo và hấp dẫn. Bạn sẽ không chỉ mua được một sản phẩm, mà còn là sự kết nối với những kí 
                    ức và cảm xúc của thời thơ ấu, khi Pokémon là một phần quan trọng của cuộc sống của chúng ta.
                </p>
            </div>
        </div>
    </div>
</section>
<!-- Giới thiệu mô hình end -->

<!-- Sản phẩm bán chạy begin-->
<section id="bestseller" class="bestseller">
    <div class="container">
        <div class="bestsellertitel text-center">
            <h1>Sản phẩm <span>bán chạy</span></h1>
        </div>
        <div class="row g-2 bestsellerCard">
            <c:forEach var="sell" items="${selling}">
            	<div class="col-md-3 d-flex justify-content-center">
	                <div class="card p-2">
	                    <a href="detail?idproduct=${sell.id }" style="text-decoration: none;color: black;">
	                    <div class="text-center"> 
	                    	<img src="./images/user/${sell.image }" class="img-fluid"/> 
	                   	</div>
	                    <div class="content">
	                
		                        <div class="d-flex justify-content-between align-items-center"> 
		                        	<div class="row">
		                        		<div class="col-md-8">
		                            		<span class="category">${sell.nameProduct }</span> 
		                        		</div>
		                        		<div class="col-md-4">
				                            <span class="price">
												<fmt:formatNumber value="${sell.price}" pattern="#,##0 VNĐ"/>
											</span> 
											<p>${sell.purchaseQuantity } lượt mua</p>
		                        		</div>
		                        	</div>
		                        </div>
		                        <p>${sell.characterName }</p> 
	                        </a>
	                        <div class="buttons d-flex justify-content-center"> 
								
								<c:set var="isLiked" value="false" />
								<c:forEach var="like" items="${checkLike}">
								    <c:if test="${like.maSP eq sell.id}">
								        <c:set var="isLiked" value="true" />
								    </c:if>
								</c:forEach>
								
								<c:choose>
								    <c:when test="${isLiked}">
								        <!-- Nếu product.id có trong danh sách checkLike -->
								        <a href="favorite-delete?idproduct=${sell.id}" style="color: red;" class="btn btn-heart"><i class="fas fa-heart"></i></a>
								    </c:when>
								    <c:otherwise>
								        <!-- Nếu product.id không có trong danh sách checkLike -->
								        <a href="favorite-insert?product=${sell.id}" class="btn btn-heart"><i class="fas fa-heart"></i></a>
								    </c:otherwise>
								</c:choose>	                            
 
	                            <a href="invoices?product=${sell.id }" class="btn btn-outline-danger mr-1">Mua ngay</a> 
	                            <a href="cart-insert?product=${sell.id }" class="btn btn-shopping-cart"><i class="fas fa-shopping-cart"></i></a> 
	                        </div>
	                    </div>
	                </div>
	            </div>
            </c:forEach>
        </div>
    </div>
</section>
<!-- Sản phẩm bán chạy end -->

<!-- Ảnh mô hình begin-->
<section class="imgMega mt-4 container-fluid">
    <div class="introduceText text-center">
        <h1>MEGA <span>IMAGE</span></h1>
    </div>
    <div class="row contenImg">
        <div class="col-md-4">
            <div class="row">
                <div class="col-md-6">
                    <img src="./images/site/pokemon1.jpg" class="img-fluid">
                </div>
                <div class="col-md-6">
                    <img src="./images/site/pokemon3.jpg" class="img-fluid">
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-md-6">
                    <img src="./images/site/KimetsunoYaiba1.jpg" class="img-fluid">
                </div>
                <div class="col-md-6">
                    <img src="./images/site/KimetsunoYaiba2.jpg" class="img-fluid">
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <img src="./images/site/pokemon2.jpg" class="img-fluid">
        </div>
        <div class="col-md-4">
            <div class="row">
                <div class="col-md-6">
                    <img src="./images/site/pokemon4.jpg" class="img-fluid">

                </div>
                <div class="col-md-6">
                    <img src="./images/site/pokemon5.jpg" class="img-fluid">

                </div>
            </div>
            <div class="row mt-2">
                <div class="col-md-6">
                    <img src="./images/site/pikachu.jpg" class="img-fluid">
                </div>
                <div class="col-md-6">
                    <img src="./images/site/pokemon6.jpg" class="img-fluid" style="height: 247px; width: 100%;">
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Ảnh mô hình end-->

<!-- Sản phẩm bán chạy begin-->
<section id="bestseller" class="bestseller">
    <div class="container">
        <div class="bestsellertitel text-center">
            <h1>Sản phẩm <span>Pokemon</span></h1>
        </div>
        <div class="row g-2 bestsellerCard">
            <c:forEach var="pokemon" begin="0" end="7" items="${prodPokenmon }">
            	<div class="col-md-3 d-flex justify-content-center">
	                <div class="card p-2">
	                    <a href="detail?idproduct=${pokemon.id }" style="text-decoration: none;color: black;">
	                    <div class="text-center"> 
	                    	<img src="./images/user/${pokemon.images }" class="img-fluid"/> 
	                   	</div>
	                    <div class="content">
	                
		                        <div class="d-flex justify-content-between align-items-center"> 
		                        	<div class="row">
		                        		<div class="col-md-8">
		                            		<span class="category">${pokemon.nameProduct }</span> 
		                        		</div>
		                        		<div class="col-md-4">
				                            <span class="price">
												<fmt:formatNumber value="${pokemon.price}" pattern="#,##0 VNĐ"/>
											</span> 
		                        		</div>
		                        	</div>
		                        </div>
		                        <p>${pokemon.characterName }</p> 
	                        </a>
	                        <div class="buttons d-flex justify-content-center"> 
								
								<c:set var="isLiked" value="false" />
								<c:forEach var="like" items="${checkLike}">
								    <c:if test="${like.maSP eq pokemon.id}">
								        <c:set var="isLiked" value="true" />
								    </c:if>
								</c:forEach>
								
								<c:choose>
								    <c:when test="${isLiked}">
								        <!-- Nếu product.id có trong danh sách checkLike -->
								        <a href="favorite-delete?idproduct=${pokemon.id}" style="color: red;" class="btn btn-heart"><i class="fas fa-heart"></i></a>
								    </c:when>
								    <c:otherwise>
								        <!-- Nếu product.id không có trong danh sách checkLike -->
								        <a href="favorite-insert?product=${pokemon.id}" class="btn btn-heart"><i class="fas fa-heart"></i></a>
								    </c:otherwise>
								</c:choose>	                            
 
	                            <a href="invoices?product=${pokemon.id }" class="btn btn-outline-danger mr-1">Mua ngay</a> 
	                            <a href="cart-insert?product=${pokemon.id }" class="btn btn-shopping-cart"><i class="fas fa-shopping-cart"></i></a> 
	                        </div>
	                    </div>
	                </div>
	            </div>
            </c:forEach>
        </div>
    </div>
</section>
<!-- Sản phẩm bán chạy end -->
 