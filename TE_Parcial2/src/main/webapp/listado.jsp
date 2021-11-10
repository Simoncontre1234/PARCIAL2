<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
   <div style="text-align:center"> 
      <font face="Verdana"> 
      <fieldset style="border: ridge #C0392B  1px;"> 
          <legend>SEGUNDO PARCIAL TEM-742</legend> 
          <p>Nombres: Joel Simon Coarite Contreras</p> 
          <p>Carnet: 8485085 LP</p> 
      </fieldset> 
      </font> 
  </div> 
</head>
<body><body bgcolor="#52BE80"> 
        <font face="Verdana" size="3.5" color=LightYellow>
    <h1>Registro de Seminarios</h1>
    <p><a href="Inicio?action=add">Nuevo</a></p>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>TITULO</th>
                <th>EXPOSITOR</th>
                <th>FECHA</th>
                <th>HORA</th>
                <th>CUPO</th>
                <th colspan="2">ACCIONES</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${seminarios}">
            <tr>
                <td>${item.id}</td>
                <td>${item.titulo}</td>
                <td>${item.expositor}</td>
                <td>${item.fecha}</td>
                <td>${item.hora}</td>
                <td>${item.cupo}</td>
                <td><a href="Inicio?action=edit&id=${item.id}">Editar</a></td>
                <td><a href="Inicio?action=delete&id=${item.id}" onclick="return(confirm('¿Está seguro de eliminar?'))">Eliminar</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
