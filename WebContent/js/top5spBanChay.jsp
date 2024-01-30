<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
google.charts.load("current", {packages:["corechart"]});
google.charts.setOnLoadCallback(drawChart);
function drawChart() {
  var data = google.visualization.arrayToDataTable([
    ['Name', 'Count'],
    <c:forEach var="selling" items="${bestSelling }">
    	['${selling.name }',     ${selling.count }],
    </c:forEach>
  ]);

  var options = {
    title: 'Top 5 Sản phẩm bán chạy nhất năm',
    is3D: true,
  };

  var chart = new google.visualization.PieChart(document.getElementById('top5SellingProduct'));
  chart.draw(data, options);
}