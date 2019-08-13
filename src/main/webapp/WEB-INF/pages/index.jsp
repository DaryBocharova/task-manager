<%--
  Created by IntelliJ IDEA.
  User: DaryBocharova
  Date: 12.08.2019
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="part/header.jsp"/>
<body>

<jsp:include page="part/navigable.jsp"/>
<div class="container theme-showcase" role="main">
    <h3 class="text-muted"><br/></h3>
    <h4 class="text-muted">WELCOME PAGE</h4>
    <div class="jumbotron">
        <div class="row">
            <div class="col-md-12">
                <div class="center-block">
                    <img src="${pageContext.request.contextPath}/resources/images/logo.png"
                         class="img-responsive center-block"
                         alt="Responsive image">
                </div>
            </div>
        </div>
        <!-- Footer -->
    </div>
    <jsp:include page="part/footer.jsp"/>
</body>
</html>