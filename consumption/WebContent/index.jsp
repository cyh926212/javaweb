<%--
  Created by IntelliJ IDEA.
  User: az102
  Date: 2022/5/28
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎您~</title>
    <!-- Main Stylesheet -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/animate.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/templatemo-style.css">
    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/res/js/jquery-1.11.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/res/js/jquery-migrate-1.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/ckeditor/ckeditor.js"></script>
    <link href="${pageContext.request.contextPath}/res/css/inOrOut.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/res/js/expenditure.js"></script>
    <link href="${pageContext.request.contextPath}/res/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/res/jquery/jquery-2.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/res/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/res/css/public.css" rel="stylesheet">
</head>
<body style="background-color: #ffffff">
<div class="container-fluid padding-top15" style="width:1200px">
    <div class="row">
        <div class="col-xs-12">
            <ol class="breadcrumb title">
                <li class="title-li"><span class="title-text">生活消费管理系统</span></li>
            </ol>
        </div>
    </div>
    <div style="margin-right: auto;margin-left: auto;width: 30%;text-align: center;">
        <div class="animated fadeInRight" style="margin-right: auto;margin-left: auto;">
            <form action="user?action=login" method="post" id="loginForm" onsubmit="return dosubmit()">
                <h3 style="border-bottom:1px dashed #999;padding-bottom:10px;">用户登录</h3>
                <br>
                <p class="text-left">用户名:<input type="text" name="username" id="username"/></p>
                <p class="text-left">密 码:<input type="password" name="password" id="password"/></p>
                <p class="text-left"></p>
                <button type="submit" class="button-grey animated fadeInUp">登录</button>
                没有账号？<a class="link-contact" href="register.jsp">注册一个</a>
            </form>
        </div>
    </div>
</div>
</body>
</html>
