<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="infor-update">
       <form action="" method="post" enctype="multipart/form-data">
           <h3 class="text-center">Chỉnh sửa thông tin</h3>
           <div class="row container">
               <!-- col uploadfile start -->
            <div class="col-md-3">
                <!-- Upload file -->
                <div class="file-upload">
                    <button class="file-upload-btn" type="button"
                        onclick="$('.file-upload-input').trigger( 'click' )">Update Avatar</button>
                    <div class="image-upload-wrap" style="${imageWrap}">
                        <input class="file-upload-input" name="avatar" type='file' onchange="readURL(this);"
                            accept="image/*" />
                        <div class="drag-text">
                            <h3>+</h3>
                        </div>
                    </div>
                    <div class="file-upload-content" style="${fileContent}">
                        <img class="file-upload-image" src="./images/user/${user.avatar}" alt="your image" />
                        <div class="image-title-wrap">
                            <button type="button" onclick="removeUpload()" class="remove-image">Remove <span
                                    class="image-title">Uploaded Image</span></button>
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
                            <input type="text" class="form-control" name="fullname" id="fullname" value="${user.fullname }" required/>
                            <input type="hidden" class="form-control" name="id" value="${user.id }"/>
                        </div>
                        <div class=" form-group">
                            <label for="birthday">Ngày sinh</label>
                            <input type="date" class="form-control" name="birthday" id="birthday" value="${user.birthday }"/>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" name="email" id="email" value="${user.email }" required/>
                        </div>
                        <div class="form-group mt-4">
                            <label for="gender" class="p-2">Giới tính: </label>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="gender" id="gender1" value="1" <c:if test="${user.gender}">checked</c:if>/>
                                <label class="form-check-label" for="gender1">Nam</label>
                            </div>

                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="gender" id="gender2" value="0"  <c:if test="${!user.gender}">checked</c:if>>
                                <label class="form-check-label" for="gender2">Nữ</label>
                            </div>

                            <div class="form-check-inline">
                                <label class="form-check-label" for="gender2">Vai trò:</label> 
                                <span>${user.role.position }</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <label for="LocaAddress">Địa chỉ</label>
                        <input type="text" class="form-control" name="locaAddress" id="LocaAddress" value="${user.locaAddress }" required/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="username">Username</label>
                            <input type="text" class="form-control" name="username" id="username" value="${user.username }" readonly/>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="phone">Phone</label>
                            <input type="text" class="form-control" name="phone" value="${user.phone }"  id="phone"/>
                        </div>
                    </div>
                </div>

                <div class="button-group">
                    <button class="btn btn-outline-success" type="submit">Thay đổi thông tin</button>
                </div>
            </div>
        </div>
    </form>

</div>