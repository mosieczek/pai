<%-- 
    Document   : viewAll
    Created on : 23 lis 2021, 10:32:32
    Author     : ihate
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
        <h1>Lista pracowników</h1>
        <table border>
            <tr> 
                <th>Id</th> 
                <th>Nazwisko</th> 
                <th>Pensja</th> 
                <th>Firma</th>
                <th>Edytuj</th> 
                <th>Usuń</th>
            </tr>
            <c:forEach var="pr" items="${list}">
            <tr>
                <td> ${pr.id} </td>
                <td> ${pr.nazwisko} </td>
                <td> ${pr.pensja} </td>
                <td> ${pr.firma} </td>
                <td><a href="edit/${pr.id}"> Edytuj </a></td>
                <td><a href="delete/${pr.id}"> Usuń </a></td>
            </tr>
            </c:forEach>
        </table>
        <br/>
        <a href="addForm">Dodaj nowego pracownika</a>
        </div>
     </body>

</html>
