<%@ page import="uz.tiu.daily.controllers.admin.test.TestController" %>
<%--
  Created by IntelliJ IDEA.
  User: ERGASHBOY_JAVA
  Date: 22.04.17
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<div >
    <table class="table table-striped table-hover dataTable">
        <thead>
        <tr>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${test}" var="test">
            <tr>

                <td><p data-placement="top" data-toggle="tooltip" title="Edit">
                    <a href="<%=TestController.URL_TEST_EDIT%>?id=${test.id}" class=" btn blue btn-outline" ><i class="glyphicon glyphicon-pencil"></i> </a></p></td>
                <td><p data-placement="top" data-toggle="tooltip" title="Delete">
                    <a href="#" class="btn red btn-outline" onclick="confirmRemove('${test.id}')"><i class="glyphicon glyphicon-trash"></i></a>
                </p></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <jsp:include page="/WEB-INF/jsp/common/pagination.jsp"/>
</div>
<script>
    $(document).ready(function () {
        url_base = '/admin/test';
        div_base = 'test-table';
        console.log(url_base);
    })
</script>
