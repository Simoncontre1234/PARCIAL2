<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
<body><body bgcolor="#52BE80"> 
        <font face="Verdana" size="3.5" color=LightYellow>
        <h1>
              <c:if test="${seminario.id==0}">NUEVO</c:if>
              <c:if test="${seminario.id!=0}">EDITAR</c:if>
              AVISO 
          </h1>

         <form action="Inicio" method="post">            
                <input class="form-control form-control-lg" type="hidden" name="id" value=${seminario.id}>
                <table>
                <tr>
                    <td>Titulo:</td>
                    <td><input type="text" name="titulo" value="${seminario.titulo}"></td>
                </tr>
                <tr>
                    <td>Expositor: </td>
                    <td><input type="text" name="expositor" value="${seminario.expositor}"></td>
                </tr>
                <tr>
                    <td>Fecha: </td>
                    <td><input type="date" name="fecha" value="${seminario.fecha}"></td>

                </tr>
                <tr>
                    <td>Hora: </td>
                    <td><input type="text" name="hora" value="${seminario.hora}"></td>

                </tr>
                <tr>
                    <td>Cupo: </td>
                    <td><input type="text" name="cupo" value="${seminario.cupo}"></td>

                </tr>
                <tr>
                    <td colspan="2"><input class="btn btn-primary btn-lg" type="submit" value="Enviar" ></td>
                </tr>

            </table>
        </form>
    </body>
</html>
