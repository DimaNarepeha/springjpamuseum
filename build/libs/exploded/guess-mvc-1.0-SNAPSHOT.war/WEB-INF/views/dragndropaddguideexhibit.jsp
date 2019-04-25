<%@ page import="ua.home.entity.Author" %>
<%@ page import="ua.home.entity.Exhibit" %>
<%@ page import="ua.home.entity.Guide" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Add new user</title>
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-ui-git.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/buttonToUpdateRelations.js"></script>

    <script src="${pageContext.request.contextPath}/resources/js/dragStuff.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css"
          href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey" id="<%out.println(request.getAttribute("idOldExhibit"));%>">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Super app!</h1>
</div>

<div class="w3-container w3-padding">
    <div class="w3-card-4 container">
        <div class="w3-container w3-center w3-green">
            <h2>Add relations</h2>
        </div>
            <%
                Exhibit exhibit = (Exhibit) request.getAttribute("exhibit");
                List<Guide> currentGuides = (List<Guide>) request.getAttribute("currentGuides");
                List<Guide> guidesInDatabase = (List<Guide>) request.getAttribute("guidesInDatabase");
                if (exhibit != null) {
                    out.println("<table class=\"table connectedSortable\">\n <thead>\n" +
                            "            <tr>\n" +
                            "                <th scope=\\\"col\\\">Exhibit</th>\n" +
                            "                <th scope=\\\"col\\\">Author</th>\n" +
                            "                <th scope=\\\"col\\\">Technique</th>\n" +
                            "                <th scope=\\\"col\\\">Material</th>\n" +
                            "                <th scope=\\\"col\\\">Hall</th>\n" +
                            "            </tr>\n" +
                            "            </thead>");
                    out.println("<tbody class=\"connectedSortable\">");

                    out.println("<tr class=\"w3-hover-sand\">");
                    Iterator iterator=exhibit.getAuthors().iterator();
                    Author author= (Author) iterator.next();
                    out.println("<th scope=\"row\">"
                            + exhibit.getExhibit_name()
                            + "</th><td>" + author.getFirstname() + " "
                            + author.getLastname() + "</td>"
                            + "<td>" + exhibit.getTechnique() + "</td>"
                            + "<td>" + exhibit.getMaterial() + "</td>"
                            + "<td>" + exhibit.getHall() + "</td>");

                    out.println("</tbody>" + "</table><br><br>");
                    out.println("<table id=\"in\" class=\"table\">\n" +
                            "  <thead>\n" +
                            "    <tr><th scope=\"col\">Guides For This Exhibit</th></tr>\n" +
                            "  </thead>");

                    out.println("<tbody  class=\"connectedSortable\">");
                    if(currentGuides!=null&&!currentGuides.isEmpty()){
                        for(Guide entity:currentGuides){
                            out.println("<tr class=\"w3-hover-sand table-success\" id="+entity.getId()+">");
                            out.println("<th scope=\"row\">"
                                    + "</th><td>" + entity.getFirstName() + " "
                                    + entity.getLastName() + "</td>");
                        }
                    }else{
                        out.println("<tr class=\"w3-hover-sand\">");
                        out.println("<th scope=\"row\">"
                                + "</th><td>Empty!</td>");
                    }
                    out.println("</tbody>" + "</table>");
                    out.println("<table  class=\"table \">\n" +
                            "  <thead>\n" +
                            "    <tr>\n" +
                            "      <th scope=\"col\">All other Guides</th>\n" +
                            "    </tr>\n" +
                            "  </thead>");
                    out.println("<tbody class=\"connectedSortable out\">");
                    if(!guidesInDatabase.isEmpty()){
                    for(Guide entity:guidesInDatabase){
                        out.println("<tr class=\"w3-hover-sand table-danger\" id="+entity.getId()+">");
                        out.println("<th scope=\"row\">"
                                + "</th><td>" + entity.getFirstName() + " "
                                + entity.getLastName() + "</td>");
                    }
                }else{
                        out.println("<tr class=\"w3-hover-sand\">");
                        out.println("<th scope=\"row\">"
                                + "</th><td>Empty!</td>");
                }
                    out.println("</tbody>" + "</table>");
                } else out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"
                        +
                        "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                        "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">=)</span>\n" +
                        "   <h5>There are no exhibits yet!</h5>\n" +
                        "</div>");
            %>


            </tbody>

        </table>



        <div class="col text-center">
            <button type="button"class="btn btn-primary btn-lg w3-center " onclick="proceed();">Update</button>
        </div>

</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/'">Back to main</button>
</div>
</body>

</html>