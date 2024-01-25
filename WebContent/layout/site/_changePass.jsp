<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="password-update">
    <form action="change-password" method="post">
        <h3>Đổi mật khẩu</h3>
        <div class="row">
            <jsp:include page="/layout/message/inform.jsp"></jsp:include>
        </div>
        <div class="row">
		    <div class="form-group">
		        <label for="passNow">Mật khẩu hiện tại:</label>
		        <input type="password" class="form-control" id="passNowCurrent" name="passNowCurrent" placeholder="Nhập mật khẩu hiện tại">
		    </div>
		    <div class="form-group">
		        <label for="passNew">Mật khẩu mới:</label>
		        <input type="password" class="form-control" id="passNew" name="passNew" placeholder="Nhập mật khẩu mới">
		    </div>
		    <div class="form-group">
		        <label for="passConfirm">Xác nhận mật khẩu mới:</label>
		        <input type="password" class="form-control" id="passConfirm" name="passConfirm" placeholder="Nhập lại mật khẩu mới">
		    </div>
		</div>

        <div class="button-group">
            <button class="btn btn-outline-success" type="submit">Thay đổi mật khẩu</button>
        </div>
    </form>

</div>