<%@ page import="uz.tiu.daily.controllers.admin.user.UsersController" %><%--
  Created by IntelliJ IDEA.
  User: gayartjon
  Date: 1/29/17
  Time: 9:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--@elvariable id="user" type="uz.tiu.daily.persistence.User"--%>

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="portlet light bordered">
                <div class="portlet-title">
                    <div class="caption font-green">
                        <div class="caption font-green">
                            <i class="fa fa-user font-green"></i>
                            <span class="caption-subject bold uppercase">Bo'limlarni qo'shish</span>
                        </div>
                    </div>

                </div>
                <div class="portlet-body form">
                    <form action="/admin/users-save.htm">
                        <input type="hidden" name="id" value="${user.id}">
                        <div class="form-body">
                            <div class="form-group form-md-line-input form-md-floating-label has-success">
                                <input class="form-control" id="name-user" value="${user.name}" name="name" type="text">
                                <label for="name-user">Ismi</label>
                            </div>
                            <div class="form-group form-md-line-input form-md-floating-label has-success">
                                <input class="form-control" id="last-name" value="${user.surName}" name="last-name" type="text">
                                <label for="last-name">Familya</label>
                            </div>
                            <div class="form-group form-md-line-input form-md-floating-label has-success">
                                <input class="form-control" id="midle-name" name="midle-name" value="${user.middleName}" type="text">
                                <label for="midle-name">Otasini ismi</label>
                            </div>
                            <div class="form-group form-md-line-input form-md-floating-label has-success">
                                <input class="form-control" id="login-user" name="login" type="text" value="${user.login}">
                                <c:if test="${error == null}"><label for="login-user">Login</label></c:if>
                                <c:if test="${error != null}"><label for="login-user"><span style="color: red"> ${error}</span></label></c:if>

                            </div>
                            <div class="form-group form-md-line-input form-md-floating-label has-success">
                                <input class="form-control" id="pass" name="pass" type="password">
                                <label for="pass">Parol</label>
                            </div>
                            <div>
                                <select class="bs-select form-control" name="managers-id" data-size="8">
                                    <option></option>
                                    <c:forEach items="${list}" var="managers">
                                        <option value="${managers.id}" <c:if test="${managers.id == user.managers.id}">selected</c:if>>${managers.name}</option>
                                    </c:forEach>

                                </select>
                            </div>

                        </div>
                        <div class="col-lg-offset-10">
                            <a class="btn blue btn-outline" href="<%=UsersController.URL_USERS%>">Chiqish</a>
                            <button type="submit" class="btn green-haze btn-outline">Saqlash</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
