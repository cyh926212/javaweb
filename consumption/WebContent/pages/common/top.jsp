<%@ page import="entity.User" %>
<!-- 权限判断，如果未登入，则不能访问会员中心 -->
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=utf-8");
	response.setCharacterEncoding("utf-8");
	User user= (User) session.getAttribute("user");
	if(user==null){
%>
<script language="JavaScript" type="text/javascript">
	alert("未登入，请登入！");
	window.location.href="../index.jsp";
</script>
<%
	}
%>
<div class="container-fluid padding-top15" style="width:1200px">
	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb title">
				<li class="title-li"><span class="title-text">生活消费管理系统</span></li>
			</ol>
		</div>
	</div>
	
	<div class="row">
		<div class="col-xs-2">
			<div class="breadcrumb left-column">
				<a href="../pages/expenditure?action=list">
				<div id="expenditure" class="breadcrumb">
					<div>
						消费
					</div>
				</div>
				</a>
				<a href="../pages/statistics.jsp">
				<div id="borrow" class="breadcrumb">
					<div>
						统计
					</div>
				</div>
				</a>
			</div>
		</div>
		
		<!-- 以下是正文内容-->
