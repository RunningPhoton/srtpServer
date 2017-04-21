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
<title>test_index</title>
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
<!-- JS代码，用于实现网页中动态特效 -->
</head>
<body>

</body>
</html>
