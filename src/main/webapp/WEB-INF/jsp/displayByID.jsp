<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>display</title>
</head>
<body>
 
<table>
<%--  <c:forEach items="${restaurantList}" var="item"> --%>
   <tr>
     <td>"${restaurantList.name}"</td>
     <td>"${restaurantList.id}"</td>
     <td>"${restaurantList.rating}"</td>
     <td>"${restaurantList.location}"</td>
     <td>"${restaurantList.cuisine}"</td>
     <td><a href = "/" >home</td>
     
   </tr>
 <%-- </c:forEach> --%>
</table>
</body>
</html>