<%@ page import="java.util.List" %>
<%@ page import="ua.home.entity.Exhibit" %>
<%@ page import="ua.home.entity.Author" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Exhibits list</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/resources/js/buttonToSelectToBeUpdated.js"></script>
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Super app!</h1>
</div>

<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>Exhibits</h2>
        </div>
        <%
            List<Exhibit> names = (List<Exhibit>) request.getAttribute("exhibits");

            if (names != null && !names.isEmpty()) {
                out.println("<table class=\"table\">\n" +
                        "  <thead>\n" +
                        "    <tr>\n" +
                        "      <th scope=\"col\">Exhibit</th>\n" +
                        "      <th scope=\"col\">Author</th>\n" +
                        "      <th scope=\"col\">Technique</th>\n" +
                        "      <th scope=\"col\">Material</th>\n" +
                        "      <th scope=\"col\">Hall</th>\n" +
                        "    </tr>\n" +
                        "  </thead>");
                out.println("<tbody>");
                for (Exhibit exhibit : names) {
                    Iterator iterator=exhibit.getAuthors().iterator();
                    Author author=((Author)iterator.next());
                    out.println("<tr class=\"w3-hover-sand\">");
                    out.println("<th scope=\"row\">"
                            + exhibit.getExhibit_name()
                            + "</th><td>" + author.getFirstname() + " "
                            + author.getLastname() + "</td>"
                            + "<td>" + exhibit.getTechnique() + "</td>"
                            + "<td>" + exhibit.getMaterial() + "</td>"
                            + "<td>" + exhibit.getHall() + "</td>");
                    out.println("<td><button id=\"" + exhibit.getId() + "\" type=\"button\"class=\"btn btn-primary\" onclick=\"proceed(this.id);\">Update</button></td>");
                }
                out.println("</tbody>" + "</table>");
            } else out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"
                    +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">=)</span>\n" +
                    "   <h5>There are no exhibits yet!</h5>\n" +
                    "</div>");
        %>
    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>

