<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="row product">
    <form action="" method="post" enctype="multipart/form-data">
        <h1 class="text-center">Thêm sản phẩm</h1>
        <div class="row container">
            <!-- col uploadfile start -->
            <div class="col-md-3">
                <!-- Upload file -->
                <div class="file-upload">
                    <button class="file-upload-btn" type="button" onclick="$('.file-upload-input').trigger( 'click' )">Add Image</button>
                  
                    <div class="image-upload-wrap" style="${imageWrap}">
                      <input class="file-upload-input" name="images" type='file' onchange="readURL(this);" accept="image/*" />
                      <div class="drag-text">
                        <h3>+</h3>
                      </div>
                    </div>
                    <div class="file-upload-content" style="${fileContent}">
                      <img class="file-upload-image" src="./images/user/${product.images}" alt="your image" />
                      <div class="image-title-wrap">
                        <button type="button" onclick="removeUpload()" class="remove-image">Remove <span class="image-title">Uploaded Image</span></button>
                      </div>
                    </div>
                </div>
            </div>
            <!-- col uploadfile end -->
            <div class="col-md-9">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="nameProduct">Tên sản phẩm</label>
                            <input type="text" class="form-control" value="${product.nameProduct }" name="nameProduct" id="nameProduct" required>
                    		<input type="hidden" name="id" value="${product.id}">
                        </div>
                        <div class="form-group">
                            <label for="price">Giá tiền</label>
                            <input type="text" class="form-control" value="${product.price }" name="price" id="price" required>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="characterName">Tên nhân vật</label>
                            <input type="text" class="form-control" value="${product.characterName }" name="characterName" id="characterName" required>
                        </div>
                        <div class="form-group">
                            <label for="megaAnime">Mege Anime</label>
                            <input type="text" class="form-control" value="${product.mageAnime }" name="mageAnime" id="megaAnime" required>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="wight">Ngang</label>
                            <input type="text" class="form-control" value="${product.wight }" name="wight" id="wight" required>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="height">Cao</label>
                            <input type="text" class="form-control" value="${product.height }" name="height" id="height" required>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="gram">Nặng</label>
                            <input type="text" class="form-control" value="${product.gram }" name="gram" id="gram" required>
                        </div>
                    </div>                                
                </div>
                <div class="form-group">
                    <label for="discription">Mô tả</label>
                    <textarea class="form-control" id="discription" name="descriptions">${product.descriptions }</textarea>
                </div>
                
                <div class="button-group">  
                	<c:if test="${fn:contains(url,'admin-product') or fn:contains(url,'reset-product') or fn:contains(url,'insert-product') or fn:contains(url,'update-product')}">
                		<button class="btn btn-outline-success" formaction="admin/insert-product" >Thêm</button>
                	</c:if> 
                	<c:if test="${fn:contains(url,'edit-product') }">     	             	
                    	<button class="btn btn-outline-warning" formaction="admin/update-product" >Sửa</button>
                    </c:if>
                    <c:if test="${fn:contains(url,'edit-product') }">  
                    	<a class="btn btn-outline-danger" href="admin/delete-product?id=${product.id}" >Xóa</a>
                    </c:if>
                    <button class="btn btn-outline-info" formaction="admin/reset-product" >Reset</button>
                </div>
                
            </div>
        </div>
    </form>
</div>