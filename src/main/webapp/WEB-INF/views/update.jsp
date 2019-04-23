<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="static java.lang.System.out" %>
<%--<%@ page import="com.softserve.academy.entity.GuideEntity" %>--%>
<%@ page import="java.util.List" %>
<%@ page import="ua.home.entity.Guide" %><%--<%@ page contentType="index/html;charset=UTF-8" language="java" %>--%>
<%--<spring:url value="/update"/>--%>
<spring:url value="/update" var="updated"  />

<html>
<head>
    <title>Add new user</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Super app!</h1>
</div>

<div class="w3-container w3-padding">

    <%
        List<Guide> names = (List<Guide>) request.getAttribute("guides");

        if (names != null && !names.isEmpty()) {
            out.println("<ul class=\"w3-ul\">");
            for (Guide s : names) {
                out.println("<li class=\"w3-hover-sand\">"+s.getId()+"." + s.getFirstName() + s.getLastName() + "</li>");
            }
            out.println("</ul>");

        } else out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"
                +
                "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">=)</span>\n" +
                "   <h5>There are no users yet!</h5>\n" +
                "</div>");
    %>
    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>Update guide</h2>
        </div>
        <form method="post" class="w3-selection w3-light-grey w3-padding">
            <label>Enter guide's id:
                <input type="text" name="id" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Guide FirstName:
                <input type="text" name="first" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Guide LastName:
                <input type="text" name="last" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <button  class="w3-btn w3-green w3-round-large w3-margin-bottom"  >Submit</button>
        </form>
    </div>
</div>
<%
    if (request.getAttribute("result") != null && request.getAttribute("result").equals(true)) {
        out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +
                "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">=)</span>\n" +
                "   <h5>User  updated!</h5>\n" +
                "</div>");
    }
    else if(request.getAttribute("result") != null && request.getAttribute("result").equals(false)) out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"
            +
            "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
            "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">=)</span>\n" +
            "   <h5>Nothing was updated!</h5>\n" +
            "</div>");
%>
<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='../..'">Back to main</button>
</div>
</body>
</html>