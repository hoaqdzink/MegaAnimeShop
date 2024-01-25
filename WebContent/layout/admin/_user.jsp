<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
  <div class="row users">
    <form action="" method="post" enctype="multipart/form-data">
        <h1 class="text-center">Thêm Tài Khoản</h1>
        <div class="row container">
            <!-- col uploadfile start -->
            <div class="col-md-3">
                <!-- Upload file -->
                <div class="file-upload">
                    <button class="file-upload-btn" type="button" onclick="$('.file-upload-input').trigger( 'click' )">Add Image</button>
                    <div class="image-upload-wrap" style="${imageWrap}">
                      <input class="file-upload-input" name="avatar" type='file' onchange="readURL(this);" accept="image/*" />
                      <div class="drag-text">
                        <h3>+</h3>
                      </div>
                    </div>
                    <div class="file-upload-content"  style="${fileContent}">
                      <img class="file-upload-image" src="./images/user/${user.avatar}" alt="your image" />
                      <div class="image-title-wrap">
                        <button type="button" onclick="removeUpload()" class="remove-image">Remove <span class="image-title">Uploaded Image</span></button>
                      </div>
                    </div>
                </div>
            </div>
            <!-- col uploadfile end -->
            <div class="col-md-9">
                <div class="row">
                	<jsp:include page="/layout/message/inform.jsp"></jsp:include>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="fullname"> Học và Tên</label>
                            <input type="text" class="form-control" name="fullname" value="${user.fullname }" id="fullname" required>
                            <input type="hidden" class="form-control" name="id" value="${user.id }">
                        </div>
                        <div class="form-group">
                            <label for="birthday">Ngày sinh</label>
                            <input type="date" class="form-control" value="${user.birthday }" name="birthday" id="birthday">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" name="email" id="email" value="${user.email }" required>
                        </div>
                        <div class="form-group mt-4">
                            <label for="gender" class="p-2">Giới tính: </label>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="gender" id="gender1" value="1" <c:if test="${user.gender}">checked</c:if> style="border-top: solid 1px orange;">
                                <label class="form-check-label" for="gender1">Nam</label>
                            </div>

                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="gender" id="gender2" value="0" <c:if test="${!user.gender}">checked</c:if> style="border-top: solid 1px orange;">
                                <label class="form-check-label" for="gender2">Nữ</label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <label for="LocaAddress">Địa chỉ</label>
                        <input type="text" class="form-control" name="locaAddress" id="LocaAddress" value="${user.locaAddress }" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="username">Username</label>
                            <input type="text" class="form-control" name="username" value="${user.username }" id="username">
                        </div>
                        <div class="form-group">
                            <label for="passW">Password</label>
                            <input type="password" class="form-control" name="passW" value="${user.passW }" id="passW" required>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="phone">Phone</label>
                            <input type="text" class="form-control" name="phone" value="${user.phone }" id="phone">
                        </div>
                       <div class="form-group">
						    <label for="role">Vai trò</label>
						    <select class="form-select" name="rolePar" aria-label="Default select example">
							    <c:forEach var="rol" items="${role}">
							        <option value="${rol.id}" ${user.role.id eq rol.id ? 'selected' : ''}>${rol.position}</option>
							    </c:forEach>
							</select>

						</div>

                    </div>
                </div>
                
                <div class="button-group">
                	<c:if test="${fn:contains(url,'admin-user') or fn:contains(url,'reset-user') or fn:contains(url,'insert-user') or fn:contains(url,'update-user') or fn:contains(url,'delete-user')}">
                    	<button class="btn btn-outline-success" formaction="admin/insert-user">Thêm</button>
                    </c:if>
                    <c:if test="${fn:contains(url,'edit-user') }">     	             	
                    	<button class="btn btn-outline-warning" formaction="admin/update-user">Sửa</button>
                    </c:if>
					<c:if test="${fn:contains(url,'edit-user') }">                     
                    	<button class="btn btn-outline-danger" formaction="admin/delete-user">Xóa</button>
                    </c:if>
                    <button class="btn btn-outline-info" formaction="admin/reset-user">Reset</button>
                </div>
                
            </div>
        </div>
    </form>
</div>