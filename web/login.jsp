<%@ page contentType="text/html;charset=gbk" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="gbk">
		<title>校园BBS-登录</title>
	</head>
	<body bgcolor="beige"></body>
	<div align="center">
		<font size="6" color="skyblue">校园BBS系统</font>
	</div>
	<p style="background: skyblue">
		>>><a href="index.jsp">论坛首页</a>
	</p>
		<form action="/s/login" method="post">
			<table align="center">
				<tr>
					<td align="right">用户名：</td>
					<td><input type="text" name="uName"/></td>
				</tr>
				<tr>
					<td align="right">密码：</td>
					<td><input type="password" name="uPass"/></td>
				</tr>
			</table>
			<tr>
				<input type="submit" value="登录">
				<input type="reset" value="重置">
			</tr>

		</form>
	</body>
</html>