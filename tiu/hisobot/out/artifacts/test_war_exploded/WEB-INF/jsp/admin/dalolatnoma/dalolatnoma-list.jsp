<%--
  Created by IntelliJ IDEA.
  User: ERGASHBOY_JAVA
  Date: 22.04.17
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="uz.tiu.daily.controllers.admin.dalolatnoma.DalolatnomaController" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<div class="adminbody">
    <div class="table_border">

        <div class="breadcrumb-wrapper" style="float: left;">
            <h2 class="mainTitle no-margin" style="margin-left: 50px">Dalolatnomalar </h2>
        </div>
        <div class="panel-body">
            <div class="text-right">
                <a type="button" class="btn green-haze btn-outline sbold uppercase"
                   href="<%=DalolatnomaController.URL_DALOLATNOMA_EDIT%>"  ><spring:message code="button.add"/> </a>
            </div>
        </div>


        <!-- start: STRIPED ROWS -->

    </div>
</div>


