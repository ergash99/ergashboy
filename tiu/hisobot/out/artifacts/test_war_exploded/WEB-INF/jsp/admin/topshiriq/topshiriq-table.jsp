<%@ page import="uz.tiu.daily.controllers.admin.topshiriq.TopshiriqController" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--@elvariable id="topshiriq" type="uz.tiu.daily.persistence.Topshiriq"--%>
<%--
  Created by IntelliJ IDEA.
  User: ERGASHBOY_JAVA
  Date: 21.04.17
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<div >
    <table class="table table-striped  table-hover dataTable">
        <thead>
        <tr>

            <th>Топширик<br>тури </th>
            <th>Дастур<br>номи</th>
            <th>Ташаббусчи<br>тузилма</th>
            <th>Келишилган<br>булинма</th>
            <th>Асос</th>
            <th>Мазмун</th>
            <th>Торширик<br>холати</th>
            <th>Буюртма<br>Раками:</th>
            <th>Буюртма<br>холати</th>
            <th>Сана</th>
            <th>Файл</th>

            <th><spring:message code="button.change"/></th>
            <th><spring:message code="button.delete"/> </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="topshiriq">
            <tr>
                <%--<td>${topshiriq.id}</td>&ndash;%&gt;--%>
                <td>${topshiriq.topshiriq_turi.name}</td>
                    <td>${topshiriq.dm_aat.name} </td>
                    <td>${topshiriq.tashabbuschi_tuzilma.name}</td>
                    <td>${topshiriq.kelishilgan_bulinmalar.name}</td>
                    <td>${topshiriq.asos}</td>
                <td>${topshiriq.mazmuni}</td>
                <td>${topshiriq.topshiriq_holati.name}</td>
                <td>${topshiriq.buyurtma_raqami}</td>

                <td>${topshiriq.buyurtma_holati.name}</td>
                <td>${topshiriq.sana}</td>
                <td>${topshiriq.buyurtma_file}</td>

                <td><p data-placement="top" data-toggle="tooltip" title="Edit">
                    <a href="<%=TopshiriqController.URL_TOPSHIRIQ_EDIT%>?id=${topshiriq.id}" class=" btn blue btn-outline" ><i class="glyphicon glyphicon-pencil"></i> </a></p></td>
                <td><p data-placement="top" data-toggle="tooltip" title="Delete">
                    <a href="#" class="btn red btn-outline" onclick="confirmRemove('${topshiriq.id}')"><i class="glyphicon glyphicon-trash"></i></a>
                </p></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <jsp:include page="/WEB-INF/jsp/common/pagination.jsp"/>
</div>
<script>
    $(document).ready(function () {
        url_base = '/admin/topshiriq';
        div_base = 'topshiriq-table';
        console.log(url_base);
    })
</script>
