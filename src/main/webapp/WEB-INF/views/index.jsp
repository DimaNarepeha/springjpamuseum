<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/resources/images/1.jpeg" var="a" />
<spring:url value="/resources/images/2.jpg" var="b" />
<spring:url value="/resources/images/3.jpg" var="c" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Super app!</title>
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css"
          href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-light-green w3-opacity w3-right-align">
    <h1 align="center">Basic crud operations</h1>
</div>

<div class="w3-container  w3-center">
    <div class="w3-bar w3-pale-red w3-padding-large w3-padding-24">
        <button class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='/list'">List guides</button>
        <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/add'">Add guide</button>
        <button class="w3-btn w3-hover-orange w3-round-large" onclick="location.href='/delete'">Delete guide</button>
        <button class="w3-btn w3-hover-pink w3-round-large" onclick="location.href='/update'">Update guide</button>
    </div>

    <div class="w3-bar w3-light-blue w3-padding-large w3-padding-24">
        <button class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='/listExhibit'">List exhibits</button>
        <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/addExhibit'">Add exhibit</button>
        <button class="w3-btn w3-hover-orange w3-round-large" onclick="location.href='/deleteExhibit'">Delete exhibit</button>
        <button class="w3-btn w3-hover-pink w3-round-large" onclick="location.href='/updateExhibitList'">Update exhibit</button>
    </div>
    <div class="w3-bar w3-yellow w3-padding-large w3-padding-24">
        <button class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='/find'">Find responsible for exhibits</button>
        <button class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='/updateRelation'">Add responsible</button>
    </div>

<div class="bd-example">
    <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
            <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="${a}" class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5>First slide</h5>
                    <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                    <!--<button class="btn btn-info btn-lg">Shop Now</button>-->
                </div>
            </div>
            <div class="carousel-item">
                <img src=""${b}"" class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Second slide</h5>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                    <!--<button class="btn btn-info btn-lg">Shop Now</button>-->
                </div>
            </div>
            <div class="carousel-item">
                <img src="${b}" class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Third slide</h5>
                    <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
                    <!--<button class="btn btn-info btn-lg">Shop Now</button>-->
                </div>
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>

</div>



</body>
</html>