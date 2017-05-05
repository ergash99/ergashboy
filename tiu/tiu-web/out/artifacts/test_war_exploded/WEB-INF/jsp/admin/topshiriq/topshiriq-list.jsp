<%--
  Created by IntelliJ IDEA.
  User: ERGASHBOY_JAVA
  Date: 21.04.17
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="uz.tiu.daily.controllers.admin.topshiriq.TopshiriqController" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<div class="adminbody">
    <div class="table_border">

        <div class="breadcrumb-wrapper" style="float: left;">
            <h2 class="mainTitle no-margin" style="margin-left: 50px">Топшириклар </h2>
        </div>
        <div class="panel-body">
            <div class="text-right">
                <a type="button" class="btn green-haze btn-outline sbold uppercase"
                   href="<%=TopshiriqController.URL_TOPSHIRIQ_EDIT%>"  ><spring:message code="button.add"/> </a>
            </div>
        </div>


        <!-- start: STRIPED ROWS -->
        <div class="container-fluid container-fullw">
            <div class="row">
                <div class="col-md-12">
                    <div id="users-table">
                        <div class="panel panel-white">

                        </div>
                        <div class="panel panel-white">
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <jsp:include page="topshiriq-table.jsp"/>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

