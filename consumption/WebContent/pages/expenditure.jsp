<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Account Book</title>
<%@ include file="common/common.jsp" %> 
<link href="${pageContext.request.contextPath}/res/css/inOrOut.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/res/js/expenditure.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/res/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<%@ include file="common/top.jsp"%>
<script language="JavaScript" type="text/JavaScript"> 
	document.onload = setLeftColumn();
</script>
<div class="col-xs-10">
    <form action="expenditure?action=add" method="post">
	<div class="add">
		<label class="add-label">添加消费:</label>
		<select class="add-select" id="type" name="type">
			<option selected hidden disabled value="">选择消费类型</option>
			<option value="餐饮美食">餐饮美食</option>
			<option value="家居服装">家居服装</option>
			<option value="文化休闲">文化休闲</option>
			<option value="交通出行">交通出行</option>、
            <option value="美容美发">美容美发</option>
		</select>
		<input class="add-money" placeholder="金额" id="money" name="money">
		<input class="add-money-remark" placeholder="名称" id="name" name="name">
		<input class="add-money-remark" onClick="WdatePicker({el:this})" placeholder="日期" id="date" name="date" readonly="readonly">
		<button class="add-button" type="submit">添加</button>
		<label class="add-label" style="margin-left: 70px">用户：<%=user.getUsername()%></label>
	</div>
    </form>

		
	<div>
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
						<td>
							<a href="expenditure?action=modify&id=${consumption.id}">修改</a>
							<a href="expenditure?action=del&id=${consumption.id}">删除</a>
						</td>
					</tr>
				</c:forEach>
		    </tbody> 
		</table>
	</div>
		
</div>
<%@ include file="common/bottom.jsp"%>