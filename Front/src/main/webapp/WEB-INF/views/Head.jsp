<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title> <meta charset="utf-8">


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
<ul class="navbar-nav">

<c:if test="${!sessionScope.loggedIn}">
    
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/login"/>">Login</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/register"/>">Register</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/aboutus"/>">Aboutus</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/contactus"/>">ContactUs</a>
    </li>
</c:if>
    
<c:if test="${!sessionScope.loggedIn}">
    	<c:if test="${sessionScope.role=='ROLE_ADMIN'}">
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/category"/>">Category</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/prod"/>">Product</a>
    </li>
    	</c:if>
    
    	<c:if test="${sessionScope.role=='ROLE_USER'}">
    
           <li class="nav-item">
           <a class="nav-link" href="<c:url value="/productdisplay"/>">Productdisplay</a>
           <a class="nav-link" href="<c:url value="/cart"/>">Cart</a>
           </li>
   		</c:if>
   
   
  <!-- -    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/totalproductdisplay"/>">totalProductdisplay</a>
   </li>- --> 
</c:if>

   </ul>
</div>

<div class="nav navbar-nav navbar-center">
  	<c:if test="${sessionScope.loggedIn}">
  		<div id="userdetail">
  			<font color="white">
  			Welcome ${sessionScope.username}
  			<a href="<c:out value="/perform_logout"/>" class="btn btn-danger">Logout</a>
  			</font>
  		</div>
  	</c:if>


</div>

</nav>
</body>
</html>