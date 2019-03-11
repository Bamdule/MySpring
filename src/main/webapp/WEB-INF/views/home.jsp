<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style>
            * {
                margin: 0px;
                padding: 0px;
            }
            #top_layout {
                width: 100%;
                height: 100px;
                background-color: #FFFFD2
            }
            #mid_layout{
                width: 100%;
                height: 1000px;
                background-color: #FFF2E6;
                text-align: center
            }
            #bot_layout{
                width: 100%;
                height: 100px;
                background-color: #DAD9FF
            }
        </style>
    </head>
    <body>
        <div id="top_layout">
        </div>
        <div id="mid_layout">
            <form method="GET" action="${pageContext.servletContext.contextPath }/validTest">
                이름 : <input name="name" type="text" value="">
                이메일 : <input id="email" name="email" type="text" value="">
                비밀번호 : <input name="pwd" type="password" value="">
                <fieldset>
                    <legend>성별</legend>
                    <label>여</label> <input type="radio" name="gender" value="female" checked="checked">
                    <label>남</label> <input type="radio" name="gender" value="male">
                </fieldset>
                <input type="submit" value="가입하기">
            </form>
        </div>
        <div id="bot_layout">
        </div>
    </body>
</html>
