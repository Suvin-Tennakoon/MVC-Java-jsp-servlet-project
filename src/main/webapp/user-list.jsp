<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>UserList</title>
</head>
<body>

<br><br>
<div class="container">
<nav class="navbar navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand">ALL USERS</a>
    <form class="d-flex">
      <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-light" type="submit">Search</button>
    </form>
  </div>
</nav>

<br/><br/>
<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">Country</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  
  <tbody>
  
    <c:forEach var="user" items="${users}">
  	<tr>
  		<td><c:out value="${user.id}"/></td>
  		<td><c:out value="${user.name}"/></td>
  		<td><c:out value="${user.country}"/></td>
  		<td>
  		<a href="edit?id=<c:out value='${user.id}'/>">Edit</a>
  		<a href="delete?id=<c:out value='${user.id}'/>">Delete</a>
  		</td>
  	</tr>  
  </c:forEach>
  
  </tbody>
 
</table>

<a href="<%=request.getContextPath()%>/new"><button type="button" class="btn btn-primary" >Add</button></a>

</div>

</body>
</html>