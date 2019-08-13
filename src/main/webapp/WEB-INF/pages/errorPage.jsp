<%--
  Created by IntelliJ IDEA.
  User: DaryBocharova
  Date: 12.08.2019
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Collection" %>
<%@ page import="ru.bocharova.tm.model.entity.Project" %>
<%@ page import="ru.bocharova.tm.util.FieldConst" %>
<%@ page import="ru.bocharova.tm.util.DateFormatter" %>
<%@ page import="org.jetbrains.annotations.NotNull" %>
<html>
<jsp:include page="/WEB-INF/jsp/fragment/header.jsp"/>
<body>
<jsp:include page="/WEB-INF/jsp/fragment/navigableBar.jsp"/>
<div class="container theme-showcase" role="main">
    <div class="header">
        <h3 class="text-muted"><br/></h3>
        <h4 class="text-muted">ERROR PAGE</h4>
    </div>
    <div class="jumbotron">
        <div class="row">
            <div class="col-md-12">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Status</th>
                        <th>Description</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${errorCode}</td>
                        <td>${errorMessage}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <!-- Footer -->
    <jsp:include page="/WEB-INF/jsp/fragment/footer.jsp"/>
</div>
</body>
</html>
