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
			<font size="6" color="skyblue">У԰BBSϵͳ</font>
		</div>
		<%
		if(session.getAttribute("user")==null){
		%>
		<div>
			����δ<a href="login.jsp">��¼</a>|<a href="reg.jsp">ע��</a>
		</div>
		<%
		} else{
		%>
		<div style="text-align: left">
			${sessionScope.user.userName},��ӭ�㣡
		</div>
		<% }%>
		<%
			int boardId = (int) session.getAttribute("boardId");
			BoardDao boardDao = (BoardDao) session.getAttribute("boardDao");
		%>
		<p>
			>>><a href="index.jsp">��̳��ҳ</a>>><a href="/s/list?boardId=<%= boardId%>"><%= boardDao.findBoard(boardId).getBoardName()%></a>
		</p>
	<div style="background-color: aliceblue;">
		<font size="" color="skyblue">��������</font>
		</div>
			
		</div>
		<form action="/s/post" method="post">
			<table>
				<tr>
					<td><th>����</th></td><td><input type="text" name="title"/></td>
				</tr>
				<tr>
					<td><th>����</th></td><td><textarea rows="5" cols="21" name="content"></textarea></td>
				</tr>
				<tr>
					<td></td><td>�����ܴ��ڣ�1000�֣�</td>
				</tr>
				<tr>
					<td align="center"><input type="submit" name="�ύ"></td><td><input type="reset" name="����"></td>
				</tr>
			</table>
		</form>
	</body>