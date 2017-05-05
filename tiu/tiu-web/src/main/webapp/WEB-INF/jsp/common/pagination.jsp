<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Saidolim
  Date: 18.03.16
  Time: 23:01
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${pagesList != null}">
    <div class="panel panel-body border-top-teal text-center">
        <ul class="pagination pagination-rounded">

                <%-- Last page symbol "<" --%>
            <c:choose>
                <c:when test="${pageId > 0}">
                    <li onclick="filterSearchPagination(${pageId-1})"><a href="#">&lsaquo;</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="#">&lsaquo;</a></li>
                </c:otherwise>
            </c:choose>

                <%--@elvariable id="pageNum" type="Integer" --%>

            <c:forEach var="pageNum" items="${pagesList}" varStatus="counter">

                <c:set var="classActive" value="" scope="page"/>
                <c:if test="${pageNum == pageId}"><c:set var="classActive" value="class=\"active\"" scope="page"/></c:if>

                <li ${classActive} onclick="filterSearchPagination(${pageNum})"><a href="#">${pageNum+1}</a></li>
            </c:forEach>

                <%-- Last page symbol ">" --%>
            <c:choose>
                <c:when test="${pageId+1 < pages}">
                    <li onclick="filterSearchPagination(${pageId+1})"><a href="#">&rsaquo;</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="#">&rsaquo;</a></li>
                </c:otherwise>
            </c:choose>

        </ul>
    </div>
</c:if>
