<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Simple JEE Webapp Example</title>
</head>
<body>
<h1>OLA JSP 2.3</h1>
<h1><a href="<%=request.getContextPath()%>/MyServlet">Meu Servlet</a> </h1>
<h1><a href="<%=request.getContextPath()%>/MyWSServlet">Meu Servlet WS</a> </h1>
</body>
</html>