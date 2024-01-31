<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
    var data = google.visualization.arrayToDataTable([
        ['Tháng', 'Số lượng'],
        <c:forEach var="product" items="${productsInMonth}">
            [${product.month}, ${product.count}],
        </c:forEach>
    ]);

    var options = {
        title: 'Số lượng hàng bán được trong các tháng',
        hAxis: {title: 'Tháng', minValue: 1, maxValue: 12},
        vAxis: {title: 'Số lượng', minValue: 0, maxValue: 100},
        trendlines: {
            0: {
                type: 'exponential',
                visibleInLegend: true,
            }
        }
    };

    var chart = new google.visualization.ScatterChart(document.getElementById('productsSoilInMonths'));
    chart.draw(data, options);
}
