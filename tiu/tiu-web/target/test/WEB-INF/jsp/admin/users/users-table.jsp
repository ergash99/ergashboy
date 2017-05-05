<%@ page import="uz.tiu.daily.controllers.admin.user.UsersController" %><%--
  Created by IntelliJ IDEA.
  User: Gayrat
  Date: 31.10.2016
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--@elvariable id="user" type="uz.tiu.daily.persistence.User"--%>
<spring:url var="url_admin_user_edit" value="/admin/users-edit.htm" htmlEscape="true"/>

<div >
<table class="table table-striped table-hover dataTable">
<thead>
<tr>
    <th>id</th>
    <th><spring:message code="admin.name"/> </th>
    <th><spring:message code="admin.login"/> </th>

    <th>Dekanat</th>
    <th><spring:message code="button.change"/> </th>
    <th><spring:message code="button.delete"/> </th>
</tr>
</thead>
<tbody>
<c:forEach items="${users}" var="user">
    <tr>
        <td>${user.id}</td>
        <td>${user.name} &nbsp; ${user.surName} &nbsp; ${user.middleName} </td>
        <td>${user.login}</td>
        <td>${user.managers.name}</td>
        <td><p data-placement="top" data-toggle="tooltip" title="Edit">
            <a href="<%=UsersController.URL_USERS_EDIT%>?id=${user.id}" class=" btn blue btn-outline" ><i class="glyphicon glyphicon-pencil"></i> </a></p></td>
        <td><p data-placement="top" data-toggle="tooltip" title="Delete">
                <a href="#" class="btn red btn-outline" onclick="confirmRemove('${user.id}')"><i class="glyphicon glyphicon-trash"></i></a>
        </p></td>
    </tr>
</c:forEach>
</tbody>
</table>
    <jsp:include page="/WEB-INF/jsp/common/pagination.jsp"/>
</div>
<script>
    $(document).ready(function () {
        url_base = '/admin/users';
        div_base = 'users-table';
        console.log(url_base);
    })
</script>
