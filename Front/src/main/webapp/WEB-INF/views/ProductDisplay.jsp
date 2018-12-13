<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <%@include file="Head.jsp"%>
    
 <h3 align="center">ProductDisplay</h3>
 
 <div class="row text-center text-ig-left">
 <c:forEach items="${listproduct}" var="product">
   <div class="col-lg-3 col-md-4 col-6">
      <a href="<c:url value="/totalproductdisplay/${product.productId}"/>" class="d-block mb-4 h-100">
           <img class="img-fluid img-thumbnail" src="<c:url value="/resources/images/${product.productId}.jpg"/>" alt=" " width="100" height="100" >
           <p>price :${product.price}/-</p>
           <p>stock :${product.stock}/-</p>
      
      </a>
      </div>
 
</c:forEach>
</div>