<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="concrete.*" %> 
    
    <%
      // get inputs
    Concrete concrete = (Concrete)request.getAttribute("concrete");
      
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fry's Concrete Calculator</title>
</head>
<body>
<h1>Fry's Concrete Calculator - Results</h1>

<%= concrete.getConcrete() %>
<p>
    <a href='index.html'>Try another!</a>
  </p>

</body>
</html>