<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="row conten-role">
    <h1 class="text-center p-4">Quản lý chức vụ</h1>
    <form action="" method="post" class="content">
    	<jsp:include page="/layout/message/inform.jsp"></jsp:include>
        <div class="row justify-content-center align-items-center">
            <div class="col-md-6">  
                <div class="form-inline d-flex align-items-center">
                    <label for="role" style="width: 90px; font-weight: bold;">Chức vụ:</label>
                    <input type="text" name="position" class="form-control" placeholder="Nhập chứ vụ" value="${role.position }"
                        style="border: none;  border-radius: 5px; border-bottom: solid 1px orange; background-color: #fffcfc00;"/>
                    <input type="hidden" class="form-control" name="id" value="${role.id }">    
                </div>
            </div>
            <div class="col-md-6">
                <div class="button-group">
                	<c:if test="${fn:contains(url,'admin/roles') or fn:contains(url,'role-reset') or fn:contains(url,'role-insertr') or fn:contains(url,'role-update') or fn:contains(url,'role-delete') or fn:contains(url,'role-insert')}">
                		<button class="btn btn-outline-success" formaction="admin/role-insert">Thêm</button>  
                	</c:if>
                	<c:if test="${fn:contains(url,'role-edit') }"> 
                		<button class="btn btn-outline-warning" formaction="admin/role-update">Sửa</button> 
                	</c:if>
                    <c:if test="${fn:contains(url,'role-edit') }">       
                    	<button class="btn btn-outline-danger" formaction="admin/role-delete">Xóa</button>
                    </c:if>
                    <button class="btn btn-outline-info" formaction="admin/role-reset">Reset</button>
                </div>
            </div>
        </div>
    </form>
    
    <div class="row d-flex justify-content-center mt-5">
        <div class="table-role text-center" style="width: 60%;">
            <table class="table table-striped table-hover">
                <thead>
                  <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Chứ Vụ</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="roles" items="${listRole}">
                  <tr>
                    <th scope="row">${roles.id }</th>
                    <td>${roles.position }</td>
                    <td>
                    	<a href="admin/role-edit?id=${roles.id }"><i class="fas fa-edit"></i></a>
                    </td>
                    <td>
                    	<a href="admin/role-delete?id=${roles.id }"><i class="fas fa-trash-alt" style="color: red;"></i></a>
                    </td>
                  </tr>
                
                </c:forEach>
                </tbody>
              </table>
        </div>
    </div>
</div>  