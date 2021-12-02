<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="utf-8" %>
<html>
	<head>
		<meta charset="utf-8">
		<!DOCTYPE html>
		<title>用户注册</title>
	</head>
<body>
<form action="/s/reg" method="post">
		<div align="center">
			<font size="6" color="skyblue">校园BBS系统</font>
		</div>
	<div  style="width: 1300px;height: 30px;background-color: slateblue">
		<p>>><a href="/s/index"> 论坛首页 </a></p>
	</div>
		<div align="center" style="width: 1300px; height:800px ;background-color: skyblue">
			<table>
				<tr>
					<td align="right">用户名：</td>
					<td><input type="text" name="uName"/></td>
				</tr>
				<tr>
					<td align="right">密码：</td>
					<td><input type="password" name="uPass"/></td>
				</tr>
				<tr>
					<td align="right">确认密码：</td>
					<td><input type="password" name="rePass"/></td>
				</tr>
				<tr>
					<td align="right">性别：</td>
					<td>男<input type="radio" name="sex" checked="checked" id="1" value="1"/>
						女<input type="radio" name="sex" id="0" value="0"/></td>
				</tr>
				</table>
				<table bgcolor="skyblue">
					<tr>请选择头像</tr>
					<tr>
						<td><input type="radio" name="img" id="1.jpg" value="1.gif"/><img width="100" src="1.gif"></td>
						<td><input type="radio" name="img" id="2.jpg" value="2.gif"/><img width="100" src="2.gif"></td>
						<td><input type="radio" name="img" id="3.jpg" value="3.gif"/><img width="100" src="3.gif"></td>
						<td><input type="radio" name="img" id="4.jpg" value="4.gif"/><img width="100" src="4.gif"></td>
						<td><input type="radio" name="img" id="5.jpg" value="5.gif"/><img width="100" src="5.gif"></td>
					</tr>
					<tr>
						<td><input type="radio" name="img" id="6.jpg" value="6.gif"/><img width="100" src="6.gif"></td>
						<td><input type="radio" name="img" id="7.jpg" value="7.gif"/><img width="100" src="7.gif"></td>
						<td><input type="radio" name="img" id="8.jpg" value="8.gif"/><img width="100" src="8.gif"></td>
						<td><input type="radio" name="img" id="9.jpg" value="9.gif"/><img width="100" src="9.gif"></td>
						<td><input type="radio" name="img" id="10.jpg" value="10.gif"/><img width="100" src="10.gif"></td>
					</tr>
					<tr>
						<td><input type="radio" name="img" id="11.jpg" value="11.gif"/><img width="100" src="11.gif"></td>
						<td><input type="radio" name="img" id="12.jpg" value="12.gif"/><img width="100" src="12.gif"></td>
						<td><input type="radio" name="img" id="13.jpg" value="13.gif"/><img width="100" src="13.gif"></td>
						<td><input type="radio" name="img" id="14.jpg" value="14.gif"/><img width="100" src="14.gif"></td>
						<td><input type="radio" name="img" id="15.jpg" value="15.gif"/><img width="100" src="15.gif"></td>
					</tr>
					</table>
					<tr>
						<input type="submit" value="注册"><a href="login.jsp"><input type="button" value="返回登录"></a>
					</tr>
					
		</div>
	</form>
	</body>
</html>
