<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="dao.BoardDao" %>
<%@ page import="dao.TopicDao" %>
<%@ page import="dao.ReplyDao" %>
<%@ page import="entity.Reply" %>
<%@ page import="entity.User" %>
<%@ page import="dao.impl.UserDaoImpl" %>
<%@ page import="dao.UserDao" %>
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
			BoardDao boardDao = (BoardDao) session.getAttribute("boardDao");
			TopicDao topicDao = (TopicDao) session.getAttribute("topicDao");
			int boardId = (int) session.getAttribute("boardId");
			int topicId = (int) session.getAttribute("topicId");
		%>
		>>><a href="index.jsp">论坛首页</a>>><a href="index.jsp"><%= boardDao.findBoard(boardId).getBoardName()%></a>>><a href="detail?boardId=<%= boardId%>&topicId=<%= topicId%>"><%= topicDao.findTopic(topicId).getTitle()%></a>
		<form action="/s/detail" method="post">
			<div>
				<input type="submit" value="回复帖子" />
			</div>
		</form>
	</body>
	<table>
		<tr>
			<td><a href=".html">上一页|</a>
				<a href=".html">下一页</a>
			</td>
		</tr>
	</table>
	<div style="background-color: aliceblue;">
		<font size="" color="skyblue">本页主题：<%= topicDao.findTopic(topicId).getTitle()%></font>
	</div>
	<%
		ReplyDao replyDao = (ReplyDao) session.getAttribute("replyDao");
		List replyList = new ArrayList(replyDao.findListReply(topicId));
		for (int i = 0; i < replyList.size(); i++) {
			Reply reply = (Reply) replyList.get(i);
			UserDao user = new UserDaoImpl();
			User thisUser = user.findUser(reply.getUserId());
	%>
		<table border="1" cellspacing="0" bordercolor="skyblue">
			<tr>
			</tr>
			<tr>
				<td rowspan="4"align="center"><p><%= thisUser.getUserName()%></p><img src="<%= thisUser.getHead()%>" width="100" align="top"><br>注册：<%= thisUser.getRegTime()%></td><td><%= reply.getTitle()%></td><td></td>
			</tr>
			<tr>
				<td><%= reply.getContent()%></td><td></td><td></td>
			</tr>
			<tr>
				<td>发表:[<%= reply.getPublishTime()%>]  最后修改:[<%= reply.getModifyTime()%>]</td><td><a href=".html">[删除]</a>
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
		<%}%>
</html>
