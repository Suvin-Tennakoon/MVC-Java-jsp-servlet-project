<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>UserForm</title>
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
<br/>

<c:if test="${user != null}">
	<form action="update" method="post">
</c:if>

<c:if test="${user == null}">
	<form action="insert" method="post">
</c:if>

<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Name</label>
  <input type="text" class="form-control" name="name" value="<c:out value='${user.name}' />" id="exampleFormControlInput1" placeholder="name@example.com">
</div>
<br/>
<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Country</label>
  <input type="text" class="form-control" name="country" value="<c:out value='${user.country }' />" id="exampleFormControlInput1" placeholder="name@example.com">
</div>
<div class="mb-3">
  
  <input type="hidden" class="form-control" name="id" value="<c:out value='${user.id }' />" id="exampleFormControlInput1" placeholder="name@example.com">
</div>

<button type="submit" class="btn btn-primary">Enter</button>

</div>

</body>
</html>