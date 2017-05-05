<%@ page import="uz.tiu.daily.controllers.admin.user.UsersController" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>

<spring:url var="url_admin_manager" value="/admin/manager.htm" htmlEscape="true"/>
<spring:url var="url_admin_users" value="/admin/users.htm" htmlEscape="true"/>


<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <security:authorize ifAnyGranted="ROLE_SYSADMIN">
                <li> <a class="navbar-brand" href="${url_admin_users}">User</a></li>
            </security:authorize>

        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">


                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Umumiy <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${url_admin_manager}" >Manager </a></li>


                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">


            </ul>
        </div>
    </div>
</nav>