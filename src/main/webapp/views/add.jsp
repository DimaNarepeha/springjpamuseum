<%@ page import="static java.lang.System.out" %><%--<%@ page contentType="index/html;charset=UTF-8" language="java" %>--%>

<%@ page import="java.util.List" %>
<%--<%@ page import="com.softserve.academy.entity.GuideEntity" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="ua.home.entity.Guide" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="static java.lang.System.out" %>
<spring:url value="/add" var="added" />

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
        if (request.getAttribute("added") != null&&(Boolean)request.getAttribute("added") == true) {
            out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">=)</span>\n" +
                    "   <h5>User  added!</h5>\n" +
                    "</div>");
        }
        else if(request.getAttribute("added")!=null&&(Boolean)request.getAttribute("added") == false) {
            out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n" +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">=)</span>\n" +
                    "   <h5>Nothing added!</h5>\n" +
                    "</div>");
        }
    %>
    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>Add user</h2>
        </div>
        <form method="post" class="w3-selection w3-light-grey w3-padding">
            <label>Guide FirstName:
                <input type="text" name="firstname" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Guide LastName:
                <input type="text" name="lastname" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <button  class="w3-btn w3-green w3-round-large w3-margin-bottom"  >Submit</button>
        </form>
    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/guess_number'">Back to main</button>
</div>
</body>
</html>