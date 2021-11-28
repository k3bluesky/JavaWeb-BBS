<%@ page import="entity.Topic" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.ReplyDao" %>
<%@ page import="dao.BoardDao" %>
<%@ page import="entity.User" %>
<%@ page import="dao.impl.UserDaoImpl" %>
<%@ page import="dao.UserDao" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/4
  Time: 7:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
</head>
<body>
<from>
    <div align="center">
        <font font size="6" color="skyblue">
            校园BBS
        </font>
    </div>
    <%
        int boardId = (int) session.getAttribute("boardId");
        BoardDao boardDao = (BoardDao) session.getAttribute("boardDao");
        List topicList = (List) session.getAttribute("topicList");
        ReplyDao replyDao= (ReplyDao) session.getAttribute("replyDao");
    %>
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
    <p>
        >>><a href="index.jsp">论坛首页</a>>><a href="/s/list?boardId=<%= boardId%>"><%= boardDao.findBoard(boardId).getBoardName()%></a>
    </p>
    <form action="/s/list" method="post">
    <div>
        <input type="submit" value="发表话题" />
    </div>
    </form>
    <div>
        <a href="">上一页</a>|<a href="">下一页</a>
    </div>

    <table border="1" width="500px" cellspacing="0" align="center">
        <tr><th></th></tr>
        <tr><td></td><td>文章</td><td>作者</td><td>回复</td></tr>
        <%
            for (int i = 0;i<topicList.size();i++){
                Topic mainTopic = (Topic) topicList.get(i);
                UserDao findUser = new UserDaoImpl();
                User user = findUser.findUser(mainTopic.getUserId());
        %>
        <tr><td><%=i+1 %></td><td><a href="detail?boardId=<%= boardId%>&topicId=<%= mainTopic.getTopicId()%>"><%=mainTopic.getTitle() %></a></td><td><%= user.getUserName() %></td><td><%=replyDao.findCountReply(mainTopic.getTopicId())%></td></tr>
        <%} %>
    </table>
    <table>
        <td><a href="index.jsp">上一页</a></td><td>|</td><td><a href="index.jsp">下一页</a></td>
    </table>
</from>
</body>
</html>
