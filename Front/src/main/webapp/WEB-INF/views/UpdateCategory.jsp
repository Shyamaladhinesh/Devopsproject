<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<%@include file="Head.jsp" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 align="Center">updateCategoryPage</h3>

<form action=<c:url value="/updateCategory"/> method="post">
<table>
<tr>
	<td>CategoryID</td>
	<td><input type="text"  id="CategoryId" name="CategoryId" value="${category.categoryId}"/></td>
	</tr>
	<tr>
	<td>CategoryName</td>
	<td><input type="text" id="CategoryName" name="CategoryName" value="${category.categoryName}"/></td>
	</tr>
	<tr>
	<td>CategoryDesc</td>
	<td><input type="text" id="categoryDesc" name="categoryDesc" value="${category.categoryDesc}"/></td>
	</tr>  
	<tr>
		
		<td colspan="2"><input type="submit" class="btn btn-danger" value="UpdateCategory"/></td>
	
	</tr>
    </table>
     </form>
    
   </body>
</html>