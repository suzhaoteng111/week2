<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/css/css.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.2.min.js"></script>
</head>
<body>
	<div>
	<form action="list" method="post">
		编号:<input type="text" name="id">
		<input type="submit" value="查询">
	</form>
		<table>
			<tr>	
			<td>编号</td>
			<td>关键字</td>
			<td>描述</td>
			<td>公司名称</td>
			<td>主营产品</td>
			<td>地址</td>
			<td>注册资本</td>
			<td>成立时间</td>
			<td>年检日期</td>
			<td>年检状态</td>
			<td>备注</td>
			<td>操作</td>
			</tr>
			<c:forEach items="${list }" var="l">
				<tr>
					<th>${l.id }</th>
					<th>${l.name }</th>
					<th>${l.ms }</th>
					<th>${l.work }</th>
					<th>${l.cp }</th>
					<th>${l.address }</th>
					<th>${l.money }</th>
					<th>
				<fmt:formatDate value="${l.cdate }" pattern="yyyy-MM-dd"/>
			</th>
			<th>
				<fmt:formatDate value="${l.ndate }" pattern="yyyy-MM-dd"/>
			</th>
					<th>${l.decation }</th>
					<th>${l.bz }</th>
					<th>......</th>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>