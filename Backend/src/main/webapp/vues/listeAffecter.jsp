<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<%@include file="navbar.html"%>
<br><br><br><center>
<h3>Gestion Affectation Formation To Formateur</h3>
</center>

 


<div class="row">
<div class="col-2"></div>
    <div class="col-4">
<form method=get action="filtreformateur">
<div class=container>
<div class="row mt-4 pl-2">
<div class="mb-3">
 <label class="form-label">Formateur:</label>
 <select  class="form-control" name="formateur" onchange="submit() " >
 <option selected hidden value="">Choose here</option>
 <c:forEach items="${formateur}" var="cc">
 <option value=${cc.id}>${cc.nom} ${cc.prenom}</option>
 </c:forEach>
 </select>
 </div> 
</div> </div> </form></div>

</div>
<div class="col-md-1""row mt-4 pl-2">
<a href="/formation/affecterformation" class="btn btn-success">
 Ajouter</a>
 </div>
<table class="table table-hover">
<tr>
 <th>Id</th><th>nom de Formation</th>
</tr>

<c:forEach items="${formation}" var="p">
<tr>
<td>${p.id}</td>
<td>${p.nom}</td>


<td><a href="/formation/desaffecterformation/${formateurr.id}/${p.id}"
 class="btn btn-danger">Desaffecter</a>
</tr>
</c:forEach>

</table>
</body>
</html>