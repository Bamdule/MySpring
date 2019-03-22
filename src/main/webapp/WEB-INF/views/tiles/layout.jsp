<%-- 
    Document   : layout
    Created on : 2019. 3. 20, 오후 4:47:42
    Author     : MW
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bamdule</title>
        <script src="${pageContext.request.contextPath}<tiles:insertAttribute name="contentJs"/>"></script>
        <script src="${pageContext.request.contextPath}/resources/js/common.js"></script>

        <!--        js lib-->
        <script src="${pageContext.request.contextPath}/resources/js/lib/jquery-3.3.1.min.js"></script>
        <script src="https://npmcdn.com/tether@1.2.4/dist/js/tether.min.js"></script>
        <script src="https://npmcdn.com/bootstrap@4.0.0-alpha.5/dist/js/bootstrap.min.js"></script>

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}<tiles:insertAttribute name="contentCss"/>" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/common/common_design.css" />

        <!--        css lib-->
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />

    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <tiles:insertAttribute name="header" />
            </div> 
            <div id="main">
                <tiles:insertAttribute name="content" />
            </div>   
            <div id="footer">
                <tiles:insertAttribute name="footer" />
            </div> 
        </div>
    </body>
</html>
