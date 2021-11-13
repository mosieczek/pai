<%-- 
    Document   : countryList
    Created on : 9 lis 2021, 12:23:24
    Author     : ihate
--%>

<%@page import="com.mycompany.lab4.CountryBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Country list:</h1>
        <% ArrayList<CountryBean> list =(ArrayList<CountryBean>)session.getAttribute("list");%>

        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Code</th>
                    <th>Population</th>
                    <th>Details</th>
                </tr>
            </thead>
            <tbody>
                <%for(int i = 0; i<list.size(); i++){
                        out.print("<tr>");
                        out.print("<td>" + list.get(i).getName() + "</td>");
                        out.print("<td>" + list.get(i).getCode() + "</td>");
                        out.print("<td>" + list.get(i).getPopulation() + "</td>");
                        //out.print( "<td><a href='/lab4/details.jsp' onclick='" + session.setAttribute("country", list.get(i).getName()) + "'>Details</a></td>" );
                        out.print( "<td><a href='/lab4/DetailsServlet?country=" + list.get(i).getName() + "'>Details</a></td>" );

                        out.print("</tr>");
                        }%>

            </tbody>
        </table>
    </body>
</html>
