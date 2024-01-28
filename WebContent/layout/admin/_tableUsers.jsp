<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="table-product p-4">
	<h1>Danh sách Tài Khoản</h1>
	<jsp:include page="/layout/message/inform.jsp"></jsp:include>
	<table class="table table-striped table-hover">
	    <thead>
	      <tr>
	        <th scope="col">ID</th>
	        <th scope="col">Họ và Tên</th>
	        <th scope="col">Ngày Sinh</th>
	        <th scope="col">Giới tính</th>
	        <th scope="col">Địa Chỉ</th>
	        <th scope="col">Avatar</th>
	        <th scope="col">Phone</th>
	        <th scope="col">Email</th>
	        <th scope="col">Tài khoản</th>
	        <th scope="col">Mật khẩu</th>
	        <th scope="col">CreateDate</th>
	        <th scope="col">Chức vụ</th>
	        <th scope="col"></th>
	        <th scope="col"></th>
	      </tr>
	    </thead>
	    <tbody>
	      <!-- Sử dụng forEach để lặp qua danh sách sản phẩm -->
	        <c:forEach var="user" items="${userList }">
	            <tr>
	                <td class="col">${user.id }</td>
	                <td class="col">${user.fullname }</td>
	                <td class="col">
						<fmt:formatDate value="${user.birthday}" pattern="dd/MM/yyyy" />
					</td>
	                <td class="col">${user.gender ? 'Nam' : 'Nữ'}</td>
	                <td class="col">${user.locaAddress }</td>
	                <td class="col">
	                	<img class="img-fluid" src="./images/user/${user.avatar}" width="100px" alt="your image" />
	                </td>
	                <td class="col">${user.phone }</td>
	                <td class="col" style="max-width: 130px; overflow-wrap: break-word;">${user.email }</td>
	                <td class="col">${user.username }</td>
	                <td class="col">${user.passW }</td>
	                <td class="col">
	                	<fmt:formatDate value="${user.createDate }" pattern="dd/MM/yyyy" />
	                </td>
	                <td class="col">${user.role.position }</td>
	                <td class="col">
	                    <a href="admin/edit-user?id=${user.id }"><i class="fas fa-edit"></i></a>
	                </td>
	                <td class="col">
	                    <a  href="admin/delete-user?id=${user.id }"><i class="fas fa-trash-alt" style="color: red;"></i></a>
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
			        <a class="page-link" href="<c:url value='/admin/list-users'/>?page=${currentPage - 1}">Previous</a>
			    </li>
			</c:if>
			
			<c:forEach begin="${startPage}" end="${endPage}" var="page">
			    <li class="page-item">
			        <a class="page-link" 
			           <c:if test="${page == currentPage}">
			               style="background-color: darkgreen;"
			           </c:if>
			           href="<c:url value='/admin/list-users'/>?page=${page}">${page}</a>
			    </li>
			</c:forEach>
			
			<c:if test="${currentPage < totalPages}">
			    <li class="page-item">
			        <a class="page-link" href="<c:url value='/admin/list-users'/>?page=${currentPage + 1}">Next</a>
			    </li>
			</c:if>
			
			
		</ul>
	</c:if>
	</div>
</div>
