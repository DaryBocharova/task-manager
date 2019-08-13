<%@ page import="ru.bocharova.tm.util.FieldConst" %>
<%@ page import="ru.bocharova.tm.model.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: DaryBocharova
  Date: 12.08.2019
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <c:set var="hiddenForUser" value="hidden"/>
            <c:set var="hiddenForNotLoginUser" value="hidden"/>
            <c:set var="hiddenForLoginUser" value=""/>
            <c:set var="loggedUser" value="<%=(User) request.getSession().getAttribute(FieldConst.USER)%>"/>

            <c:if test="${loggedUser!=null}">
                <div hidden>
                        ${hiddenForNotLoginUser=""}
                        ${hiddenForLoginUser="hidden"}
                    <c:if test="${loggedUser.getRole()==Role.ADMIN}">
                        ${hiddenForUser=""}
                    </c:if>
                </div>
            </c:if>
            <a class="navbar-brand"
               href="${pageContext.request.contextPath}"><span class="glyphicon glyphicon-home"></span></a>
            <a ${hiddenForNotLoginUser} class="navbar-brand"
                                        href="${pageContext.request.contextPath}/project/list">Projects</a>
            <a ${hiddenForNotLoginUser} class="navbar-brand"
                                        href="${pageContext.request.contextPath}/task/list">Tasks</a>
            <a ${hiddenForUser} class="navbar-brand" href="${pageContext.request.contextPath}/user/list">Users</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">

            <div ${hiddenForNotLoginUser}
                    class="navbar-form navbar-right">
                <button class="btn btn-primary"
                        onclick="postToUrl(
                                '${pageContext.request.contextPath}/user/edit',
                                {'<%=FieldConst.USER_ID%>':'${loggedUser.getId()}'},
                                'GET');">
                    PROFILE
                </button>
                <button class="btn btn-danger"
                        onclick="postToUrl(
                                '${pageContext.request.contextPath}/user/logout',
                                '',
                                'POST');">

                    LOG OUT
                </button>
            </div>

            <form ${hiddenForLoginUser} method="POST"
                                        action="${pageContext.request.contextPath}/user/login"
                                        class="navbar-form navbar-right">
                <a onclick="postToUrl(
                        '${pageContext.request.contextPath}/user/register',
                        '',
                        'GET');">Sign Up</a>
                <div class="form-group">
                    <input type="text" placeholder="Login" name="<%=FieldConst.LOGIN%>" class="form-control">
                </div>
                <div class="form-group">
                    <input type="password" placeholder="Password" name="<%=FieldConst.PASSWORD%>" class="form-control">
                </div>
                <button type="submit" class="btn btn-success">Sign In</button>

            </form>
        </div><!--/.navbar-collapse -->
    </div>
</nav>