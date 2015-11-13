<%@ page import="java.io.*,java.util.*" %>
<!-- When tomcat was shutdowned, the counts recount  -->
<html>
<head>
<title>Applcation object in JSP</title>
</head>
<body>
<%
    Integer hitsCount = 
      (Integer)application.getAttribute("hitCounter");
    if( hitsCount ==null || hitsCount == 0 ){
       /* 第一次访问 */
       out.println("Welcome to my website!");
       hitsCount = 1;
    }else{
       /* 返回访问值 */
       out.println("Welcome back to my website!");
       hitsCount += 1;
    }
    application.setAttribute("hitCounter", hitsCount);
%>
<center>
<p>Total number of visits: <%= hitsCount%></p>
</center>
</body>
</html>
