<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询到的结果</title>
</head>
<body>
	<table border="1" cellspacing="0">
	<tr><th>书名</th><th>作者</th><th>出版</th><th>种类</th><th>总页数</th><td>状态</td></tr>
	<c:forEach var="book" items="${mess}">
	<tr><td>${book.bName }</td><td>${book.writer }</td><td>${book.press }</td><td>${book.sort }</td><td>${book.pageNum }</td><td>${book.state }</td></tr>
	
	</c:forEach>	
	</table>
</body>
</html>