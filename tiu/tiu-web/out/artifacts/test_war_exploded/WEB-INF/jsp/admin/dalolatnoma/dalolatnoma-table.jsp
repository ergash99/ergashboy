<%@ page import="uz.tiu.daily.controllers.admin.topshiriq.TopshiriqController" %>
<%@ page import="uz.tiu.daily.controllers.admin.smeta.SmetaController" %>
<%@ page import="uz.tiu.daily.controllers.admin.dalolatnoma.DalolatnomaController" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--@elvariable id="list" type="uz.tiu.daily.persistence.Dalolatnoma"--%>
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
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="dalolatnoma">
            <tr>

                <td><p data-placement="top" data-toggle="tooltip" title="Edit">
                    <a href="<%=DalolatnomaController.URL_DALOLATNOMA_EDIT%>?id=${dalolatnoma.id}" class=" btn blue btn-outline" ><i class="glyphicon glyphicon-pencil"></i> </a></p></td>
                <td><p data-placement="top" data-toggle="tooltip" title="Delete">
                    <a href="#" class="btn red btn-outline" onclick="confirmRemove('${dalolatnom.id}')"><i class="glyphicon glyphicon-trash"></i></a>
                </p></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <jsp:include page="/WEB-INF/jsp/common/pagination.jsp"/>
</div>
<script>
    $(document).ready(function () {
        url_base = '/admin/dalolatnoma';
        div_base = 'dalolatnoma-table';
        console.log(url_base);
    })
</script>
