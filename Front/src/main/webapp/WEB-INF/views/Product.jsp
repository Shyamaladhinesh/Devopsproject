    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@include file="Head.jsp" %>
<html>
<form:form action="InsertProduct" modelAttribute="prod" method="post" enctype="multipart/form-data">
<table align="center" class="table table-responsive">

<tr>
  <td>ProductName</td>
  <td><form:input path="productName"/></td>
</tr>

<tr>
  <td>ProductDesc</td>
  <td><form:input path="productDesc"/></td>
</tr>

<tr>
			<td>ProductImage</td>
			<td><form:input type="file" path="pimage" /></td>
		</tr>
		
<tr>
  <td>Price</td>
  <td><form:input path="price"/></td>
</tr>

<tr>
  <td>Stock</td>
  <td><form:input path="stock"/></td>
</tr>

<tr>
  <td>category</td>
  <td><form:select path="CategoryId">
   <form:option value="0" label="...selection list..."/>
   <form:options items="${categorylist}"/>
   </form:select>
   </td>
</tr>

<tr>
  <td>supplier</td>
  <td><form:input path="supplierId" /></td>
    </tr>


<tr>
    <td colspan="2"><input type="submit"class="btn btn-primary" value="insert"/></td>
</tr>

</table>

</form:form>

<table align="center" border="2">
<tr>
         <td>Product Id</td>
         <td>Product Name</td>
         <td>CategoryId</td>
         <td>Price</td>
         <td>SupplierId</td>
      </tr>

 <c:forEach items="${listproduct}" var="product">
<tr>
  <td>${product.productId}</td>
  <td>${product.productName}</td>
  <td>${product.categoryId}</td>
  <td>${product.price}</td>
  <td>${product.supplierId}</td>
 <td>
 <div class="container">
  <a href=<c:url value="/editProduct/${product.productId}"/> class="btn btn-info" role="button">Edit</a>
   <a href=<c:url value="/deleteProduct/${product.productId}"/> class="btn btn-info" role="button">Delete</a>

 </div>
  <td>
 </tr> 

 
   </c:forEach> 
</table>
</body>
</html>