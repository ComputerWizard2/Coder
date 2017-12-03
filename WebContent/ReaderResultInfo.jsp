<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 align="left" >用户信息</h3>
    <table align="center"  width="1000" border="1">            		
        <tr>
			<td align="center" bgcolor="yellow">
				<h1>用户信息</h1>
			</td>
		</tr>
    </table>    
	<table align="center" width="1000" border="1" height="120"  bgcolor="white" cellpadding="1" cellspacing="1">
		
		<tr align="center" bgcolor="#e1ffc1">
			<td><b>类      别</b></td>		 
			<td><b>用户名</b></td>
			<td><b>性别</b></td>
			<td><b>年龄</b></td>
			<td><b>班级/部门</b></td>
			<td><b>学号/工号</b></td>
			<td><b>电话号码</b></td>
			<td><b>借阅数量</b></td>
			<td><b>可借数量</b></td>
			<td><b>密码</b></td>
			<td><b>修改</b></td>
			
			
			
		</tr>
		
			<tr align="center" bgcolor="white">
				<td>${readerByName.rSort}</td>
				<td>${readerByName.rName}</td>
				<td>${readerByName.rSex}</td>
				<td>${readerByName.rAge}</td>				
				<td>${readerByName.rClass}</td>
				<td>${readerByName.rNo}</td>
				<td>${readerByName.rPhoneNum}</td>
				<td>${readerByName.lendNum}</td>
				<td>${readerByName.canLendNum}</td>
				<td>${readerByName.passWord}</td>
				<td><button  onclick="a()">修改用户信息</button></td>
			</tr>			
		<script type="text/javascript">
	
			function a(){
				
				location.href="updateReaderInfo.jsp?NAME=${readerByName.rName}&RNO=${readerByName.rNo}&RSORT=${readerByName.rSort}&RSEX=${readerByName.rSex} "
				
			}
</script>

</body>
</html>