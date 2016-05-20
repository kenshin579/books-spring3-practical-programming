<%@page contentType="text/html" pageEncoding="euc-kr" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


<%@page import="org.springframework.web.context.WebApplicationContext" %>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
    <title>빈 확인</title>
</head>
<body>
<%
    WebApplicationContext rootContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    WebApplicationContext dispatcherContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext(), "org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcher");
    Object commonLogger = rootContext.getBean("commonLogger");
    Object helloController = dispatcherContext.getBean("helloController");
%>
commonLogger = <%= commonLogger == null ? "존재하지 않음" : "존재함" %> <br/>
helloController = <%= helloController == null ? "존재하지 않음" : "존재함" %> <br/>
</body>
</html>
