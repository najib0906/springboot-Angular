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
<h3>Gestion Formateur</h3>
</center>
<form method=get action=formateurmc>
<div class=container>
<div class="row mt-4 pl-2">
<div class="col-md-1">
<label for="mc" class="form-label">Mot Cle:</label>
</div>
<div class="col-md-3">
<input type="text" id="mc" class="form-control" name=mc>
</div>
<div class="col-md-3">
<button type="submit" class="btn btn-primary">Chercher</button>
</div> </div> </div> </form>
<div class="col-md-1""row mt-4 pl-2">
<a href="/formation/ajouterformateur" class="btn btn-success">
 Ajouter</a>
 </div>
<table class="table table-hover">
<tr>
 <th>Id</th><th>photo</th><th>Prenom</th><th>Nom</th><th>CIN</th><th>email</th><th>Role</th><th>telephone</th><th>Action</th>
</tr>
<c:forEach items="${formateurs}" var="f">
<tr>
<td>${f.id}</td>
<td><c:choose>
<c:when test="${f.photo==''}">
<img src="/image2022/inconnu.jpg" width=50 height="50">
</c:when>
<c:when test="${f.photo!=''}">
<img src="/image2022/${f.photo}" width=50 height="50">
</c:when>
</c:choose>
</td>

<td>${f.prenom}</td>
<td>${f.nom}</td>
<td>${f.cin}</td>
<td>${f.email}</td>
<td>${f.role}</td>
<td>${f.telephone}</td>

<td><a href="/formation/supprimerformateur/${f.id}"
 class="btn btn-danger">supprimer</a>
 <a href="/formation/modifierformateur/${f.id}" class="btn btn-warning">
 modifier</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>