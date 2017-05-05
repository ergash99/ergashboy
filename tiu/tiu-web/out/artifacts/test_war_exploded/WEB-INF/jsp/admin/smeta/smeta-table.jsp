<%@ page import="uz.tiu.daily.controllers.admin.topshiriq.TopshiriqController" %>
<%@ page import="uz.tiu.daily.controllers.admin.smeta.SmetaController" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--@elvariable id="smeta" type="uz.tiu.daily.persistence.Smeta"--%>
<%--
  Created by IntelliJ IDEA.
  User: ERGASHBOY_JAVA
  Date: 21.04.17
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<div >
    <table class="table table-striped table-hover dataTable">
        <thead>
        <tr>

            <th>ДМ ва ААТ<br>номи </th>
            <th>Буюртма<br>раками</th>
            <th>Буюртма<br>санаси</th>
            <th>Смета<br>раками</th>
            <th>Смета<br>санаси</th>
            <th>Смета<br>холати</th>
            <th>Ишни бошлаш<br>санаси</th>
            <th>Аванс утказилган<br>сана</th>
            <th>Иш жами<br>суммаси</th>


            <th><spring:message code="button.change"/></th>
            <th><spring:message code="button.delete"/> </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${smeta}" var="smeta">
            <tr>
                    <%--<td>${topshiriq.id}</td>&ndash;%&gt;--%>
                <td>${smeta.dm_aat.name}</td>
                <td>${smeta.buyurtma_raqami} </td>
                <td>${smeta.buyurtma_sanasi}</td>
                <td>${smeta.smeta_raqami}</td>
                <td>${smeta.smeta_sanasi}</td>
                <td>${smeta.smeta_holati.name}</td>
                <td>${smeta.ishni_boshlash_sanasi}</td>
                <td>${smeta.avans_sanasi}</td>
                <td>${smeta.ish_summasi}</td>
                <td><p data-placement="top" data-toggle="tooltip" title="Edit">
                    <a href="<%=SmetaController.URL_SMETA_EDIT%>?id=${smeta.id}" class=" btn blue btn-outline" ><i class="glyphicon glyphicon-pencil"></i> </a></p></td>
                <td><p data-placement="top" data-toggle="tooltip" title="Delete">
                    <a href="#" class="btn red btn-outline" onclick="confirmRemove('${smeta.id}')"><i class="glyphicon glyphicon-trash"></i></a>
                </p></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <jsp:include page="/WEB-INF/jsp/common/pagination.jsp"/>
</div>
<script>
    $(document).ready(function () {
        url_base = '/admin/smeta';
        div_base = 'smeta-table';
        console.log(url_base);
    })
</script>
