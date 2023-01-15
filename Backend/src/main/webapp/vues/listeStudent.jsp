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
<h3>Gestion Student</h3>
</center>
<div class="row">
<div class="col-1"></div>
    <div class="col-5">
<form method=get action=studentmc>
<div class=container>
<div class="row mt-4 ">
<div class="col-md-2">
<label for="mc" class="form-label">Mot Cle:</label>
</div>
<div class="col-md-4">
<input type="text" id="mc" class="form-control" name=mc>
</div>
<div class="col-md-3">
<button type="submit" class="btn btn-primary">Chercher</button>
</div> </div> </div> </form></div><div class="col-5">
<form method=get action="filtreclasse">
<div class=container>
<div class="row mt-4 pl-2">

 <label class="form-label">Classe:</label>
 <select  class="form-control" name="classe" onchange="submit() " >
 <option selected hidden value="">Choose here</option>
 <c:forEach items="${classe}" var="cc">
 <option value=${cc.id}>${cc.nom}</option>
 </c:forEach>
 </select>
 
</div> </div> </form></div></div>
<div class="col-md-1""row mt-4 pl-2">
<a href="/formation/ajouterstudent" class="btn btn-success">
 Ajouter</a>
 </div>
<table class="table table-hover">
<tr>
 <th>Id</th><th>photo</th><th>Prenom</th><th>Nom</th><th>CIN</th><th>Role</th><th>email</th><th>telephone</th><th>classe</th><th>Action</th>
</tr>
<c:forEach items="${students}" var="p">
<tr>
<td>${p.id}</td>
<td><c:choose>
<c:when test="${p.photo==''}">
<img src="/image2022/inconnu.jpg" width=50 height="50">
</c:when>
<c:when test="${p.photo!=''}">
<img src="/image2022/${p.photo}" width=50 height="50">
</c:when>
</c:choose>
</td>

<td>${p.prenom}</td>
<td>${p.nom}</td>
<td>${p.cin}</td>
<td>${p.role}</td>
<td>${p.email}</td>
<td>${p.telephone}</td>
<td>${p.classe.nom}</td>
<td><a href="/formation/supprimerstudent/${p.id}"
 class="btn btn-danger">supprimer</a>
 <a href="/formation/modifierstudent/${p.id}" class="btn btn-warning">
 modifier</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>