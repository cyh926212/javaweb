<%@ page import="dao.ConsumptionDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%! ConsumptionDao consumptionDao = new ConsumptionDao();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Account Book</title>
<%@ include file="common/common.jsp" %> 
<link href="${pageContext.request.contextPath}/res/css/borrow.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/res/js/borrow.js"></script>

</head>
<body>
<%@ include file="common/top.jsp"%>

<script language="JavaScript" type="text/JavaScript"> 
	document.onload = setLeftColumn();
</script>

<div class="col-xs-10">
	<form action="expenditure?action=search" method="post">
		<div class="selectAndSearch">
			<select class="select" id="searchType" name="searchType">
				<option selected hidden disabled value="">选择消费类型</option>
				<option value="name">名称</option>
				<option value="date">日期</option>
			</select>
			<input name="key" class="searchInput" placeholder="搜索对象">
			<button class="add-button" type="submit">搜索</button>
		</div>
	</form>
	<div class="total">
		<label class="total-label1">餐饮美食：</label>
		<label class="total-money1"><%=consumptionDao.statisticsType("餐饮美食",user.getId()) %>元</label>
		<label class="total-label2">家居服装：</label>
		<label class="total-money2"><%=consumptionDao.statisticsType("家居服装",user.getId()) %>元</label>
		<label class="total-label2">文化休闲：</label>
		<label class="total-money2"><%=consumptionDao.statisticsType("文化休闲",user.getId()) %>元</label>
		<label class="total-label2">交通出行：</label>
		<label class="total-money2"><%=consumptionDao.statisticsType("交通出行",user.getId()) %>元</label>
		<label class="total-label2">美容美发：</label>
		<label class="total-money2"><%=consumptionDao.statisticsType("美容美发",user.getId()) %>元</label>
	</div>
	<div class="borrowTable">
		<table class="table table-bordered">
			<thead>
			<tr>
				<th>日期</th>
				<th>消费名称</th>
				<th>消费金额</th>
				<th>消费类型</th>
				<th>操作</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${consumptionList}" end="5" var="consumption">
				<tr>
					<td>${consumption.date}</td>
					<td>${consumption.name}</td>
					<td>${consumption.money}</td>
					<td>${consumption.type}</td>
					<td><a href="expenditure?action=del&id=${consumption.id}">删除</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
		
</div>
<%@ include file="common/bottom.jsp"%>