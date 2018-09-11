

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style type="text/css">
            div#map_container{
                width:50%;
                height:400px;
            }
        </style>
        <script type="text/javascript"
        src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>


        <script type="text/javascript">
            function loadMap() {
                var latlng = new google.maps.LatLng(47, 28.85);
                var myOptions = {
                    zoom: 8,
                    center: latlng,
                    mapTypeId: google.maps.MapTypeId.ROADMAP
                };
                var map = new google.maps.Map(document.getElementById("map_container"), myOptions);

                var marker = new google.maps.Marker({
                    position: latlng,
                    map: map,
                    title: "my hometown, Malim Nawar!"
                });

            }
        </script>

    </head>
    <body onload="loadMap()">


        <jsp:include page="menu.jspf" />
        <h1>CONTACTE PAGE</h1>

        <div id="map_container"></div>

        <%--

<ul>
<li><a href="home.jsp"> HOME </a> </li>
<li><a href="produse.jsp"> PROUSE </a> </li>
<li><a href="contacte22.jsp"> CONTACTE </a> </li>
</ul>

        --%>
        <%=new Date()%>
    </body>
</html>
