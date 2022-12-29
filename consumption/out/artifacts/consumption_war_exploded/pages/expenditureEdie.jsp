<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Account Book</title>
    <%@ include file="common/common.jsp" %>
    <link href="${pageContext.request.contextPath}/res/css/inOrOut.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/res/js/expenditure.js"></script>
    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/res/My97DatePicker/WdatePicker.js"></script>
	<script  type="text/javascript">
		function judgeUpdate()
		{
			if(confirm("确定要修改吗？"))
			{
				document.getElementById('myForm').submit();
			}else {
				return;
			}
		}
	</script>
</head>
<body>
<%@ include file="common/top.jsp" %>
<script language="JavaScript" type="text/JavaScript">
    document.onload = setLeftColumn();
</script>
<div class="col-xs-10">
    <div>
        <form id="myForm" action="expenditure?action=modifyAfter" method="post">
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
                <tr>
                    <input type="hidden" name="id" value="${consumption.id}"/>
                    <input type="hidden" name="userId" value="${consumption.userId}"/>
                    <td><input type="text" onClick="WdatePicker({el:this})" name="date" value="${consumption.date}"/>
                    </td>
                    <td><input type="text" name="name" value="${consumption.name}"/></td>
                    <td><input type="text" name="money" value="${consumption.money}"/></td>
                    <td><input type="text" name="type" value="${consumption.type}"/></td>
                    <td>
						<a href="javascript:judgeUpdate()">修改</a>
                    </td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>

</div>
<%@ include file="common/bottom.jsp" %>