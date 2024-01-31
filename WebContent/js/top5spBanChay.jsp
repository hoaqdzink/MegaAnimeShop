<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
google.charts.load("current", {packages:["corechart"]});
google.charts.setOnLoadCallback(drawPieChart);
google.charts.setOnLoadCallback(drawColumnChart);

function drawPieChart() {
  var data = google.visualization.arrayToDataTable([
    ['Name', 'Count'],
    <c:forEach var="selling" items="${bestSelling }">
      ['${selling.name }', ${selling.count }],
    </c:forEach>
  ]);

  var options = {
    title: 'Top 5 Sản phẩm bán chạy nhất năm',
    is3D: true,
  };

  var chart = new google.visualization.PieChart(document.getElementById('top5SellingProduct'));
  chart.draw(data, options);
}
function drawColumnChart() {
  var data = google.visualization.arrayToDataTable([
    ["Mage Anime", "Tổng số lượng" ],
    <c:forEach var="mostPurchasedMegaAnime" items="${purchasedMegaAnimes }">
      ['${mostPurchasedMegaAnime.mageAnime }', ${mostPurchasedMegaAnime.countQuantity }],
    </c:forEach>
  ]);

  var colors = ['#3366cc', '#dc3912', '#ff9900', '#109618', '#990099'];

  // Tạo một mảng chứa các đặc tính cho từng cột, bao gồm màu sắc
  var seriesProperties = Array.from({ length: data.getNumberOfColumns() - 1 }, (_, i) => {
    return { color: colors[i] };
  });

  var options = {
    title: "Thống kê 5 Mage Anime được mua nhiều nhất!",
    width: 600,
    height: 300,
    bar: { groupWidth: "95%" },
    series: seriesProperties
  };

  var chart = new google.visualization.ColumnChart(document.getElementById("top5MostPurchasedMegaAnimes"));
  chart.draw(data, options);
}
