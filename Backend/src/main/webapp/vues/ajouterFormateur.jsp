<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
rel="stylesheet"
integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
crossorigin="anonymous">
<script
src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
crossorigin="anonymous"></script>
</script>
<body>
<%@include file="navbar.html" %>
<br>
<br>
<br>
<c:if test="${message!=null}">
<div class="alert alert-success" role="alert">
<c:out value="${message}"></c:out>
${formateur=null}
</div>
</c:if>
<div class=container>
<div class="card m-5 p-2">
 <div class="card-header"><h2>Ajouter Formateur</h2></div>
<div class="card-body">
<form action="/formation/saveformateur" method=post enctype="multipart/form-data">

 <div class="mb-3 mt-3">
 <label for="prenom" class="form-label">prenom:</label>
 <input type=text class="form-control" id="prenom" name="prenom" value="${formateur.prenom}">
 </div>
 <div class="mb-3">
 <label for="nom" class="form-label">nom:</label>
 <input type="text" class="form-control" id="nom" name="nom" value="${formateur.nom}">
 </div>
 <div class="mb-3">
 <label for="cin" class="form-label">Cin:</label>
 <input type="text" class="form-control" id="cin" name="cin" value="${formateur.cin}">
 </div>
  <div class="mb-3">
 <label for="tel" class="form-label">Telephone:</label>
 <input type="number" class="form-control" id="telephone" name="telephone" value="${formateur.telephone}">
 </div>

  <div class="mb-3">
 <label for="email" class="form-label">Email:</label>
 <input type="email" class="form-control" id="email" name="email" value="${formateur.email}">
 </div>

 <div class="mb-3"> 
 <input type=hidden name=photo value="${formateur.photo}">
<label class="form-label">Photos</label> <input type="file"
name="file" accept="image/png,image/jpeg" class=form-control />
 </div>
 <input type=hidden name=id value="${formateur.id}">
  <input type=hidden name=role value="Formateur">
 <button type="submit" class="btn btn-primary" >Save</button>
</form></div> </div></div></body>
</html>