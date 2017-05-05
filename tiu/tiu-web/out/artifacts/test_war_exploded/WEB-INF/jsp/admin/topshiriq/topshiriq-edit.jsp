<%@ page import="uz.tiu.daily.persistence.Topshiriq" %>
<%@ page import="uz.tiu.daily.controllers.admin.topshiriq.TopshiriqController" %>
<%--
  Created by IntelliJ IDEA.
  User: Gayratjon Rayimjonov
  Date: 2/5/17
  Time: 6:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="span" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--@elvariable id="item" type="uz.tiu.daily.persistence.Topshiriq"--%>
<spring:url var="url_file_download" value="/file/download/" htmlEscape="true" scope="session"/>
<div class="page-container">
    <div class="page-content-wrapper">
        <div class="page-content">
            <div class="container">
                <div class="row">
                    <div class="col-md-8 col-sm-offset-2">
                        <div class="portlet light portlet-fit portlet-form bordered">
                            <div class="portlet-title">
                                <div class="caption col-sm-offset-5" >
                                    <i class=" icon-layers font-green"></i>
                                    <span class="caption-subject font-green sbold uppercase">
                                    Topshiriqni qo`shish
                                </span>
                                </div>
                            </div>
                            <div class="portlet-body">
                                <form class="form-horizontal col-sm-offset-2" id="form_sample_1" action="<%=TopshiriqController.URL_TOPSHIRIQ_SAVE%>"
                                      enctype="multipart/form-data" method="post">
                                    <input type="hidden" name="id" value="${item.id}">
                                    <div class="">
                                        <div class="form-body">
                                            <div class="form-group form-md-line-input">
                                                <div class="col-md-11">
                                                    <div class="form-control-focus"></div>
                                                </div>
                                            </div>
                                            <div class=" form-md-checkboxes">

                                                <div class="col-md-11 form-group">
                                                    Topshiriq turini tanlang
                                                    <select class="form-control input-lg" name="topshiriq_turi">
                                                        <c:forEach items="${topshriq_turi}" var="topshriq_turi">
                                                            <option value="${topshriq_turi.id}" <c:if test="${topshriq_turi.id == item.topshriq_turi.id }">selected</c:if> >${topshriq_turi.name}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div><br>

                                                <div class="col-md-11 form-group">
                                                    DM NOMI
                                                    <select class="form-control input-lg" name="dm_aat">
                                                        <c:forEach items="${dm_aats}" var="dm_aats">
                                                            <option value="${dm_aats.id}" <c:if test="${dm_aats.id == item.dm_aats.id }">selected</c:if> >${dm_aats.name}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="col-md-11 form-group">
                                                    Tashabbuschi tuzilma
                                                    <select class="form-control input-lg" name="tashabbuschi_tuzilma">
                                                        <c:forEach items="${tashabbuschi_tuzilmas}" var="tashabbuschi_tuzilmas">
                                                            <option value="${tashabbuschi_tuzilmas.id}" <c:if test="${tashabbuschi_tuzilmas.id == item.tashabbuschi_tuzilmas.id }">selected</c:if> >${tashabbuschi_tuzilmas.name}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="col-md-11 form-group">
                                                    Kelishilgan bulinma
                                                    <select class="form-control input-lg" name="kelishilgan_bulinmalar">
                                                        <c:forEach items="${kelishilgan_bulinmalars}" var="kelishilgan_bulinmalars">
                                                            <option value="${kelishilgan_bulinmalars.id}" <c:if test="${kelishilgan_bulinmalars.id == item.kelishilgan_bulinmalars.id }">selected</c:if> >${kelishilgan_bulinmalars.name}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="col-md-11 form-group">
                                                    Buyurtma holati
                                                    <select class="form-control input-lg" name="buyurtma_holati">
                                                        <c:forEach items="${buyurtma_holatis}" var="buyurtma_holatis">
                                                            <option value="${buyurtma_holatis.id}" <c:if test="${buyurtma_holatis.id == item.buyurtma_holatis.id }">selected</c:if> >${buyurtma_holatis.name}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="col-md-11 form-group">
                                                    Topshiriq holati
                                                    <select class="form-control input-lg" name="topshiriq_holati">
                                                        <c:forEach items="${topshiriq_holatis}" var="topshiriq_holatis">
                                                            <option value="${topshiriq_holatis.id}" <c:if test="${topshiriq_holatis.id == item.topshiriq_holatis.id }">selected</c:if> >${topshiriq_holatis.name}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    <div class="form-actions">
                                        <div class="row">
                                        </div>
                                    </div>
                            </div>
                                    <div class="form-group form-md-line-input">
                                        <div class="col-md-11">
                                            <input type="text" class="form-control" name="buyurtma_raqami" value="${item.buyurtma_raqami}"
                                                   placeholder="Buyurtma raqamini kiriting">
                                            <div class="form-control-focus"></div>
                                        </div>
                                    </div>
                                    <div class="form-group form-md-line-input">
                                        <div class="col-md-11">
                                            <input type="text" class="form-control" name="mazmuni" value="${item.mazmuni}"
                                                   placeholder="Mazmunni kiriting">
                                            <div class="form-control-focus"></div>
                                        </div>
                                    </div>
                                    <div class="form-group form-md-line-input">
                                        <div class="col-md-11">
                                            <input type="text" class="form-control" name="sana" value="${item.sana}"
                                                   placeholder="Sanani kiriting">
                                            <div class="form-control-focus"></div>
                                        </div>
                                    </div>

                                    <div class="form-group form-md-line-input">
                                        <div class="col-md-11">
                                            <input type="text" class="form-control" name="asos" value="${item.asos}"
                                                   placeholder="Asosni kiriting">
                                            <div class="form-control-focus"></div>
                                        </div>
                                    </div>




                                    <div class="col-md-12 col-sm-offset-2">
                                        <button type="submit" class="btn green btn-lg"><spring:message
                                                code="button.save"/></button>
                                        <button type="reset" class="btn default btn-lg"><spring:message
                                                code="button.cancel"/></button>
                                    </div>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

