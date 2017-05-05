<%@ page import="uz.tiu.daily.persistence.Topshiriq" %>
<%@ page import="uz.tiu.daily.controllers.admin.topshiriq.TopshiriqController" %>
<%@ page import="uz.tiu.daily.controllers.admin.smeta.SmetaController" %>
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
<%--@elvariable id="smeta" type="uz.tiu.daily.persistence.Smeta"--%>
<%--@elvariable id="topshiriq" type="uz.tiu.daily.persistence.Topshiriq"--%>
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
                                    Smeta qo`shish
                                </span>
                                </div>
                            </div>
                            <div class="portlet-body">
                                <form class="form-horizontal col-sm-offset-2" id="form_sample_1" action="<%=SmetaController.URL_SMETA_SAVE%>"
                                      enctype="multipart/form-data" method="post">
                                    <input type="hidden" name="id" value="${smeta.id}">
                                    <div class="">
                                        <div class="form-body">
                                            <div class="form-group form-md-line-input">
                                                <div class="col-md-11">
                                                    <div class="form-control-focus"></div>
                                                </div>
                                            </div>
                                            <div class=" form-md-checkboxes">

                                                <%--<div class="col-md-11 form-group">--%>
                                                    <%--Buyurtmani tanlang--%>
                                                    <%--<select class="form-control input-lg" name="buyurtma_raqami">--%>
                                                        <%--<c:forEach items="${buyurtma_raqami}" var="buyurtma_raqami">--%>
                                                            <%--<option value="${buyurtma_raqami.id}" <c:if test="${buyurtma_raqami.id == topshiriq.buyurtma_raqami}">selected</c:if> >${buyurtma_raqami.name}</option>--%>
                                                        <%--</c:forEach>--%>
                                                    <%--</select>--%>
                                                <%--</div><br>--%>

                                                <div class="col-md-11 form-group">
                                                    DM NOMI
                                                    <select class="form-control input-lg" name="dm_aat">
                                                        <c:forEach items="${dm_aat}" var="dm_aat">
                                                            <option value="${dm_aat.id}" <c:if test="${dm_aat.id == smeta.dm_aat.id }">selected</c:if> >${dm_aat.name}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="col-md-11 form-group">
                                                    Smeta holati
                                                    <select class="form-control input-lg" name="smeta_holati">
                                                        <c:forEach items="${smeta_holati}" var="smeta_holati">
                                                            <option value="${smeta_holati.id}" <c:if test="${smeta_holati.id == item.smeta_holati.id }">selected</c:if> >${smeta_holati.name}</option>
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
                                            <input type="text" class="form-control" name="smeta_raqami" value="${smeta.smeta_raqami}"
                                                   placeholder="Smeta raqamini kiriting">
                                            <div class="form-control-focus"></div>
                                        </div>
                                    </div>
                                    <div class="form-group form-md-line-input">
                                        <div class="col-md-11">
                                            <input type="text" class="form-control" name="buyurtma_sanasi" value="${smeta.buyurtma_sanasi}"
                                                   placeholder="Buyurtma sanasini kiriting">
                                            <div class="form-control-focus"></div>
                                        </div>
                                    </div>
                                    <div class="form-group form-md-line-input">
                                        <div class="col-md-11">
                                            <input type="text" class="form-control" name="smeta_sanasi" value="${item.smeta_sanasi}"
                                                   placeholder="Smeta sanasini kiriting">
                                            <div class="form-control-focus"></div>
                                        </div>
                                    </div>
                                    <div class="form-group form-md-line-input">
                                        <div class="col-md-11">
                                            <input type="text" class="form-control" name="ishni_boshlash_sanasi" value="${smeta.ishni_boshlash_sanasi}"
                                                   placeholder="Ishni boshlash  sanasini kiriting">
                                            <div class="form-control-focus"></div>
                                        </div>
                                    </div>

                                    <div class="form-group form-md-line-input">
                                        <div class="col-md-11">
                                            <input type="text" class="form-control" name="avans_sanasi" value="${smeta.avans_sanasi}"
                                                   placeholder="15% avans utkazilgan sanasini kiriting">
                                            <div class="form-control-focus"></div>
                                        </div>
                                    </div>

                                    <div class="form-group form-md-line-input">
                                        <div class="col-md-11">
                                            <input type="text" class="form-control" name="ish_summasi" value="${smeta.ish_summasi}"
                                                   placeholder="Ishlar jami summasini kiriting">
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

