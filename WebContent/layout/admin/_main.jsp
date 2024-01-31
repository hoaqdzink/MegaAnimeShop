<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="container-fluid">
    <div class="mb-3">
        <h4>Page Dành Cho Quản Trị Viên</h4>
    </div>
    <div class="row">
        <div class="col-12 col-md-6 d-flex">
            <div class="card flex-fill border-0 illustration">
                <div class="card-body p-0 d-flex flex-fill">
                    <div class="row g-0 w-100">
                        <div class="col-6">
                            <div class="p-3 m-1">
                                <h4>Xin Chào, ${name}</h4>
                            </div>
                        </div>
                        <div class="col-6 align-self-end text-end">
                            <img src="./images/user/${avatar }" class="img-fluid illustration-img" alt="">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-12 col-md-6 d-flex">
            <div class="card flex-fill border-0">
                <div class="card-body py-4">
                    <div class="d-flex align-items-start">
                        <div class="flex-grow-1">
                            <h4 class="mb-2">
                                 <fmt:formatNumber value="${totalPrice}" type="number" pattern="#,##0 VNĐ"/>
                            </h4>
                            <p class="mb-2">
                                Tổng tiền bán được
                            </p>
                            <div class="mb-0">
                                <span class="badge text-success me-2">
                                   <fmt:formatNumber value="${totalMonth}" type="number" pattern="#,##0 VNĐ"/>
                                </span>
                                <span class="text-muted">
                                    Tiền bán được trong tháng
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Table Element -->
    <div class="card border-0">
        <div class="row">
        	<div class="col-md-6">
        		<div id="top5SellingProduct" style="width: 600px; height: 300px;"></div>
        	</div>
        	<div class="col-md-6">
        		<div id="top5MostPurchasedMegaAnimes" style="width: 600px; height: 300px;"></div>
        	</div>
        </div>
       
    </div>
</div>
