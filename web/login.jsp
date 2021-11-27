<%@ page contentType="text/html;charset=gbk" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="gbk">
		<title>校园BBS-登录</title>
	</head>
	<body bgcolor="beige"></body>
		<img src="img/123.png" >
		<form action="/s/login" method="post">
			<table>
				<tr>
					<td align="right">用户名：</td>
					<td><input type="text" name="uName"/></td>
				</tr>
				<tr>
					<td align="right">密码：</td>
					<td><input type="text" name="uPass"/></td>
				</tr>
			</table>
			<tr>
				<input type="submit" value="登录">
				<input type="reset" value="重置">
			</tr>

		</form>
	</body>
</html>