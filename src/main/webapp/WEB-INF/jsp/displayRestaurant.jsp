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
 <c:forEach items="${restaurantList}" var="item">
   <tr>
     <td><c:out value="${item.name}" /></td>
     <td><c:out value="${item.id}" /></td>
     <td><c:out value="${item.rating}" /></td>
     <td><c:out value="${item.location}" /></td>
     <td><c:out value="${item.cuisine}" /></td>
     <td><a href = "/${item.id}" >Delete</td>
     <td><a href = "/restaurantUpdate" >Update</td>
     <td><a href = "/" >Home</td>
     
   </tr>
 </c:forEach>
</table>
</body>
</html>