<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
google.charts.load("current", {packages:["corechart"]});
google.charts.setOnLoadCallback(drawChart);
function drawChart() {
  var data = google.visualization.arrayToDataTable([
    ['Trang thái', 'Số lượng'],
    <c:forEach var="stt" items="${status }">
    ['${stt.status }', ${stt.count }],
    </c:forEach>
  ]);

  var options = {
    title: 'Thống kê trạng thái của các đơn hàng',
    pieHole: 0.4,
  };

  var chart = new google.visualization.PieChart(document.getElementById('status-order'));
  chart.draw(data, options);
}