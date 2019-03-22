
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<div id="content">
    <div id="login_layout">


        <div id="top_login">
            <div style="height: 50%;"></div>
            <div style="height: 50%;" id="main_title">Login Page</div>
        </div>
        <div id="mid_login">
            <sec:authorize access="isAnonymous()">
                <form id="loginForm" action="<c:url value='/login' />" method="post" style="width: 100%; height: 100%; text-align: center;">
                    <input type="hidden" id="loginFlag" value="${param.error}"/>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />


                    <div style="margin : 0 auto; width: 50%; text-align: center;">
                        <input type="text" id="account" name="account" class="form-control" placeholder="아이디">
                        <input type="password" name="password" class="form-control" placeholder="비밀번호" style="margin-top: 10px;">
                        <div style="margin-top: 10px;">
                            <button type="submit" form="loginForm" class="btn btn-primary">Login</button>
                        </div>
                        <div style="margin-top: 10px;">
                            <button type="button" class="btn btn-success">Sign Up</button>
                        </div>
                        
                    </div>

                </form>
                <div style="color: red;">
                    ${msg}
                </div>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <div>
                    이미 로그인 되어 있습니다.
                </div>
            </sec:authorize>
        </div>
        <div id="bot_login">
        </div>
    </div>
</div>
