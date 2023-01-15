<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste Formation</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<%@include file="navbar.html"%>
<br><br><br><center>
<h3>Gestion Formation</h3>
</center>
<div class="col-md-1""row mt-4 pl-2">
<a href="/formation/ajouterformation" class="btn btn-success">
 Ajouter</a>
 </div>
<table class="table table-hover">
<tr>
 <th>Id</th><th>Nom</th><th>Action</th>
</tr>
<c:forEach items="${formations}" var="p">
<tr>
<td>${p.id}</td>
<td>${p.nom}</td>

<td><a href="/formation/supprimerformation/${p.id}"
 class="btn btn-danger">supprimer</a>
 <a href="/formation/modifierformation/${p.id}" class="btn btn-warning">
 modifier</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>