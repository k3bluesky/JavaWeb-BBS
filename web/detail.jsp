<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
	</head>
	<body>
		<div align="center">
			<font size="6" color="skyblue">校园BBS系统</font>
		</div>
		<%
			if(session.getAttribute("user")==null){
		%>
		<div>
			您尚未<a href="login.jsp">登录</a>|<a href="reg.jsp">注册</a>
		</div>
		<%
		} else{
		%>
		<div style="text-align: left">
			${sessionScope.user.userName},欢迎你！
		</div>
		<% }%>
		>>><a href="index.jsp">论坛首页</a>>><a href="index.jsp"><%= boardDao.findBoard(boardId).getBoardName()%></a>
		<p><button type="button">回复帖子</button> <button type="button">发表话题</button></p>
	</body>
	<table>
		<tr>
			<td><a href=".html">上一页|</a>
				<a href=".html">下一页</a>
			</td>
		</tr>
	</table>
	<div style="background-color: aliceblue;">
		<font size="" color="skyblue">本页主题：灌水</font>
	</div>
		<table border="1" cellspacing="0" bordercolor="skiblue">
			<tr>
			</tr>
			<tr>
				<td rowspan="4"align="center"><p>7</p><img src="img/1%20(11).jpg" width="100" align="top"><br>注册：2007-07-27</td><td>灌水</td><td></td>
			</tr>
			<tr>
				<td>rt</td><td></td><td></td>
			</tr>
			<tr>
				<td>发表:[2007-07-30 08:37]  最后修改:[2007-07-30 8:37]</td><td><a href=".html">[删除]</a>
					<a href=".html">[修改]</a></td><td></td>
			</tr>
			<tr>
				<td></td><td></td><td></td>
			</tr>
		</table >
			<tr>
				<td></td><td></td><td></td>
			</tr>
		</table>
		
</html>
