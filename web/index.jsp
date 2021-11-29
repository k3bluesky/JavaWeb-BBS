<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/10/13
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="dao.BoardDao" %>
<%@ page import="dao.impl.BoardDaoImpl" %>
<%@ page import="entity.Board" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>首页</title>
</head>
<body bgcolor="beige">
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
<table border="1" width="500px" cellspacing="0" align="center">
    <tr>
        <td align="leftz"><a href="reg.jsp">论坛</a></td>
        <td></td>
        <td align="left">主题</td>
        <td align="left">最后发表</td>
    </tr>
    <tr>
            <%

            Map mapBoard=(Map) session.getAttribute("mapBoard");
			List listMainBoard=(List) session.getAttribute("listMainBoard");
			for (int i = 0;i<listMainBoard.size();i++){
			Board mainBoard = (Board) listMainBoard.get(i);
			%>
    <tr>
        <td><%= mainBoard.getBoardName() %></td>
    <td></td>
    <td></td>
    <td></td>
    </tr>
    <%
        List listSonBoard = (List) mapBoard.get(mainBoard.getBoardId());
        for (int j = 0; j < listSonBoard.size(); j++) {
            Board sonBoard = (Board) listSonBoard.get(j);
    %>
    <!--子版块-->
    <tr>
        <td></td>
        <td><a href="list?boardId=<%= sonBoard.getBoardId()%>"/> <%= sonBoard.getBoardName() %></td>
        <td></td>
        <td></td>
    </tr>
    <%}%>
    <%}%>
</table>
<hr color="aquamarine" width="80%" size="2" align="right" />
</body>
</html>
