<%@ page import="uz.tiu.daily.controllers.admin.student.StudentController" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--@elvariable id="student" type="uz.tiu.daily.persistence.Students"--%>


<div >
    <table class="table table-striped table-hover dataTable">
        <thead>
        <tr>

            <th><spring:message code="admin.name"/> </th>
            <th>Yo'nalihi</th>
            <th>Kursi</th>
            <th>Dekanat</th>
            <th><spring:message code="button.change"/> </th>
            <th><spring:message code="button.delete"/> </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="student">
            <tr>

                <td>${student.name} &nbsp; ${student.lastName} &nbsp; ${student.midleName} </td>
                <td>${student.department.name}</td>
                <td>${student.couerse}</td>
                <td>${student.department.managers.name}</td>
                <td><p data-placement="top" data-toggle="tooltip" title="Edit">
                    <a href="<%=StudentController.URL_STUDENT_EDIT%>?id=${student.id}" class=" btn blue btn-outline" ><i class="glyphicon glyphicon-pencil"></i> </a></p></td>
                <td><p data-placement="top" data-toggle="tooltip" title="Delete">
                    <a href="#" class="btn red btn-outline" onclick="confirmRemove('${student.id}')"><i class="glyphicon glyphicon-trash"></i></a>
                </p></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <jsp:include page="/WEB-INF/jsp/common/pagination.jsp"/>
</div>
<script>
    $(document).ready(function () {
        url_base = '/admin/student';
        div_base = 'student-table';
        console.log(url_base);
    })
</script>