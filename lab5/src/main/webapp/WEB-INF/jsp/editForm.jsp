<%-- 
    Document   : editForm
    Created on : 23 lis 2021, 10:32:22
    Author     : ihate
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pracownicy</title>
    </head>
    <body>
        <div>
            <h1>Edytuj dane pracownika</h1>
            <form:form method="post" action="editsave"> 
                <table > 
                    <tr> 
                        <td> <form:hidden path="id" /> ${pr.id}</td>
                    </tr> 
                    <tr> 
                        <td>Nazwisko : </td> 
                        <td> <form:input path="nazwisko" /> ${pr.nazwisko}</td>
                    </tr> 
                    <tr> 
                        <td>Pensja :</td> 
                        <td> <form:input path="pensja" /> ${pr.pensja}</td>
                    </tr> 
                    <tr> 
                        <td>Firma :</td> 
                        <td> <form:input path="firma" /> ${pr.firma} </td>
                    </tr> 
                    <tr> 
                        <td> </td> 
                        <td> <input type="submit" value="Zapisz" /> </td> 
                    </tr> 
                </table> 
            </form:form>
        </div>
    </body>
</html>
