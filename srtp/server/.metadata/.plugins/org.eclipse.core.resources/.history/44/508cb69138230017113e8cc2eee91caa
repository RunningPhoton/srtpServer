<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
   String basePath = request.getScheme()+"://"+request.getServerName()
         +":"+request.getServerPort()+request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CQDX-OA办公管理系统</title>
<!-- 引入外部的CSS样式文件 -->
<link rel="stylesheet" href="css/dist/css/bootstrap.min.css" />
<style>
body {
	font-family: "微软雅黑";
	font-size: 12px;
}

#header {
	position: fixed;
	width: 100%;
	height: 100px;
	top: 0px;
	left: 0px;
	z-index: 5;
	background-color: lightskyblue;
}

#pageBady {
	position: fixed; /* 固定定位，相对于浏览器窗口定位 */
	top: 0px;
	right: 0px;
	bottom: 0px;
	left: 0px;
	background-color: #B0E2FF;
}

#pageBady #sideBar {
	position: absolute; /* 绝对定位，相对于父级容器定位 */
	width: 15%;
	height: 100%;
	top: 0px;
	left: 0px;
	padding-top: 100px;
	overflow: auto;
}

#sideBar ul {
	position: relative;
	margin: 5px 0px 0px 10px; /*上右下左*/
	width: 180px;
	background-color: #FFF;
}

#sideBar ul li {
	text-align: center;
}

#pageBady #main {
	position: absolute;
	width: 84%;
	height: 100%;
	top: 0px;
	right: 0px;
	background-color: #FFF;
	padding-top: 100px;
}

#footer {
	position: fixed;
	width: 100%;
	height: 5px;
	bottom: 0px;
	left: 0px;
	z-index: 5;
	background-color: lightskyblue
}

.btn-close {
	position: absolute;
	width: 40px;
	height: 40px;
	top: 20px;
	right: 50px;
	border-radius: 40px;
	text-align: center;
	line-height: 40px;
	font-size: 10px;
	color: #F5F5F5;
	background-color: darkred;
	cursor: pointer;
}

.btn-close:hover {
	opacity: 0.5;
}

.userInfo {
	position: absolute;
	width: 200px;
	bottom: 5px;
	right: 20px;
	text-align: right;
}
</style>
<!-- 引入Jquery js库文件 -->
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<!-- JS代码，用于实现网页中动态特效 -->
<script>
		    /**
		     * 展开或关闭菜单
		     * @param {Object} thisz
		     */
			function openOrClose(thisz) {
				//获得当前节点对象的ID
				var id = thisz.id;
				//获得子节点集合
				var subNodes = $("li[parent="+id+"]");
				//判断修改显示隐藏状态
				if(subNodes.css("display")=="none") { //隐藏状态
					subNodes.css("display", "block")
				} else { //显示状态
					subNodes.css("display", "none");
				}
			}
		</script>
</head>
<body>
	<div id="header">
		<img src="img/logo.png" width="100" height="100" />
		<div class="btn-close" onclick="location.href='login.jsp'">注 销</div>
		<div class="userInfo">用户: admin[系统管理员]</div>
	</div>
	<div id="pageBady">
		<div id="sideBar">
			<ul class="nav nav-pills nav-stacked">
				<li id="01" class="active" onclick="openOrClose(this)"><a
					href="javascript:void(0);">个人中心</a></li>
				<li parent="01"><a href="admin/myinfo/message.jsp"
					target="mainFrame">我的资料</a></li>
				<li id="02" class="active" onclick="openOrClose(this)"><a
					href="javascript:void(0);">系统管理</a></li>
				<li parent="02"><a href="user!list.action"
					target="mainFrame">用户管理</a></li>
				<li parent="02"><a href="#">部门管理</a></li>
				<li parent="02"><a href="#">角色管理</a></li>
				<li id="03" class="active" onclick="openOrClose(this)"><a
					href="javascript:void(0);">业务流程</a></li>
				<li parent="03"><a href="#">请假管理</a></li>
				<li parent="03"><a href="#">加班管理</a></li>
			</ul>
		</div>
		<div id="main">
			<!-- 内联框架，网页中嵌套另外一个网页 -->
			<iframe id="mainFrame" name="mainFrame" src="main.html" width="100%"
				height="100%" frameborder="0"></iframe>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>
