<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>员工管理系统</title>
</head>
	<frameset rows="100,*" frameborder="0" border="1">
	   <frame src="${pageContext.request.contextPath}/frame/top.jsp" name="top" />
	   <frameset cols="250,*" id="main" frameborder="0" border="1">
	      <frame src="${pageContext.request.contextPath}/frame/left.jsp" name="left" /> 
	      <frame src="${pageContext.request.contextPath}/frame/right.jsp" name="right" />
	   </frameset>
	</frameset>
</html>