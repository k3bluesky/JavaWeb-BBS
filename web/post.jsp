<%@ page import="dao.BoardDao" %>
<%@ page contentType="text/html;charset=gbk" language="java" %>
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
		<%
			int boardId = (int) session.getAttribute("boardId");
			BoardDao boardDao = (BoardDao) session.getAttribute("boardDao");
		%>
		<p>
			>>><a href="index.jsp">论坛首页</a>>><a href="/s/list?boardId=<%= boardId%>"><%= boardDao.findBoard(boardId).getBoardName()%></a>
		</p>
	<div style="background-color: aliceblue;">
		<font size="" color="skyblue">发表帖子</font>
		</div>
			
		</div>
		<form action="/s/post" method="post">
			<table>
				<tr>
					<td><th>标题</th></td><td><input type="text" name="title"/></td>
				</tr>
				<tr>
					<td><th>内容</th></td><td><textarea rows="5" cols="21" name="content"></textarea></td>
				</tr>
				<tr>
					<td></td><td>（不能大于：1000字）</td>
				</tr>
				<tr>
					<td align="center"><input type="submit" name="提交"></td><td><input type="reset" name="重置"></td>
				</tr>
			</table>
		</form>
	</body>