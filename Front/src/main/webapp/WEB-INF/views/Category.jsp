<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%@include file="Head.jsp" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 align="Center">CategoryPage</h3>

<form action=<c:url value="/addCategory"/> method="post">

<table align="center">
   <tr>
      <td>Category Name</td>
      <td><input type="text" id="categoryName" name="CategoryName"/></td>
    <tr>
    <tr>
      <td>Category Description</td>
      <td><input type="text" id="categoryDesc" name="categoryDesc"/></td>
    <tr>
     <td colspan="3"><input type="submit" class="btn btn-success" value="AddCategory"/></td>
    </tr>
    
    </table>
    </form>
    
   <table align="center"  border="2">
      <tr>
         <td>Category ID</td>
         <td>Category Name</td>
         <td>Category Desc</td>
         <td>Action</td>
      </tr>
   <c:forEach items="${listcat}" var="category">
   <tr>
      <td>${category.categoryId}</td>
      <td>${category.categoryName}</td>
      <td>${category.categoryDesc}</td>
      <td>
      <div class="container">
            <a href=<c:url value="/UpdateCategory"/> class="btn btn-success" role=button>update</a>  
			<a href=<c:url value="/deleteCategory/${category.categoryId}"/> class="btn btn-success" role=button>Delete</a>  
	   </div>  
	</td>     
     </tr>
   
    </c:forEach> 
    </table> 
    
</body>
</html>