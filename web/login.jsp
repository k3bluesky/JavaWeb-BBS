<%@ page contentType="text/html;charset=gbk" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="gbk">
		<title>У԰BBS-��¼</title>
	</head>
	<body bgcolor="beige"></body>
	<div align="center">
		<font size="6" color="skyblue">У԰BBSϵͳ</font>
	</div>
	<p style="background: skyblue">
		>>><a href="index.jsp">��̳��ҳ</a>
	</p>
		<form action="/s/login" method="post">
			<table align="center">
				<tr>
					<td align="right">�û�����</td>
					<td><input type="text" name="uName"/></td>
				</tr>
				<tr>
					<td align="right">���룺</td>
					<td><input type="password" name="uPass"/></td>
				</tr>
			</table>
			<tr>
				<input type="submit" value="��¼">
				<input type="reset" value="����">
			</tr>

		</form>
	</body>
</html>