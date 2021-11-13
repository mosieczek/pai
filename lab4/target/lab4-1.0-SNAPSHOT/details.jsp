<%-- 
    Document   : details
    Created on : 9 lis 2021, 13:16:28
    Author     : ihate
--%>

<%@page import="com.mycompany.lab4.DetailsBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Szczegóły</h1>
        <% ArrayList<DetailsBean> list =(ArrayList<DetailsBean>)session.getAttribute("list");%>
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Code</th>
                    <th>Population</th>
                    <th>Continent</th>
                    <th>Region</th>
                    <th>Surface Area</th>
                    <th>Indep Year</th>
                    <th>Life Expectancy</th>
                    <th>GNP</th>
                    <th>GNPOld</th>
                    <th>Local Name</th>
                    <th>Government Form</th>
                    <th>HeadOfState</th>
                    <th>Capital</th>
                    <th>Code2</th>
                </tr>
            </thead>
            <tbody>
                <%for(int i = 0; i<list.size(); i++){
                        out.print("<tr>");
                        out.print("<td>" + list.get(i).getName() + "</td>");
                        out.print("<td>" + list.get(i).getCode() + "</td>");
                        out.print("<td>" + list.get(i).getPopulation() + "</td>");
                        out.print("<td>" + list.get(i).getContinent() + "</td>");
                        out.print("<td>" + list.get(i).getRegion() + "</td>");
                        out.print("<td>" + list.get(i).getSurfacearea() + "</td>");
                        out.print("<td>" + list.get(i).getIdepyear() + "</td>");
                        out.print("<td>" + list.get(i).getLifeexpactancy() + "</td>");
                        out.print("<td>" + list.get(i).getGnp() + "</td>");
                        out.print("<td>" + list.get(i).getGnpoid() + "</td>");
                        out.print("<td>" + list.get(i).getLocalname() + "</td>");
                        out.print("<td>" + list.get(i).getGovernmentform() + "</td>");
                        out.print("<td>" + list.get(i).getHeadofstate() + "</td>");
                        out.print("<td>" + list.get(i).getCapital() + "</td>");
                        out.print("<td>" + list.get(i).getCode2() + "</td>");
                        out.print("</tr>");
                        }%>

            </tbody>
        </table>


            </tbody>
        <h1><a href="/lab4/ListServlet">Wróć do listy państw</a></h1>
        
    </body>
</html>
