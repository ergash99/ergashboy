<%@ page import="uz.tiu.daily.controllers.admin.student.StudentController" %><%--
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
<%--@elvariable id="item" type="uz.tiu.daily.persistence.Students"--%>
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
                                    Ro'yharga olish
                                </span>
                                </div>
                            </div>
                            <div class="portlet-body">
                                <form class="form-horizontal col-sm-offset-2" id="form_sample_1" action="<%=StudentController.URL_STUDENT_SAVE%>"
                                      enctype="multipart/form-data" method="post">
                                    <input type="hidden" name="id" value="${item.id}">
                                    <div class="">
                                        <div class="fileinput fileinput-new col-sm-offset-3 " data-provides="fileinput">
                                            <div class="fileinput-new thumbnail" style="width: 200px; height: 150px;">
                                                <c:if test="${item.photo!= null}">
                                                    <img src="${url_file_download}${item.photo.fileUrl}" />
                                                </c:if>
                                            </div>
                                            <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"> </div>
                                            <div>
                                                                        <span class="btn default btn-file btn-block">
                                                                            <span class="fileinput-new btn-block"> Tanlash</span>
                                                                            <span class="fileinput-exists btn-block"> <spring:message code="button.change"/> </span>
                                                                            <input type="file" name="file" accept="image/jpg,image/png,image/jpeg,image/gif">
                                                                        </span>
                                                <a href="javascript:;" class=" fileinput-exists btn-block btn red" data-dismiss="fileinput"> <spring:message code="button.delete"/> </a>
                                            </div>
                                        </div>

                                        <div class="form-body">
                                            <div class="form-group form-md-line-input">
                                                <div class="col-md-11">
                                                    <input type="text" class="form-control" value="${item.name}" name="name"
                                                           placeholder="Ismni kiriting">
                                                    <div class="form-control-focus"></div>
                                                </div>

                                            </div>

                                            <div class="form-group form-md-line-input">
                                                <div class="col-md-11">
                                                    <input type="text" class="form-control" name="last-name" value="${item.lastName}"
                                                           placeholder="Familyani kiriting">
                                                    <div class="form-control-focus"></div>
                                                </div>
                                            </div>
                                            <div class="form-group form-md-line-input">
                                                <div class="col-md-11">
                                                    <input type="text" class="form-control" name="midle-name" value="${item.midleName}"
                                                           placeholder="Otasini ismini kiriting">
                                                    <div class="form-control-focus"></div>
                                                </div>
                                            </div>
                                            <div class="form-group form-md-line-input">
                                                <div class="col-md-11">
                                                    <input type="text" class="form-control" name="card-id" value="${item.cardId}"
                                                           placeholder="Id raqamini kiriting">
                                                    <div class="form-control-focus"></div>
                                                </div>
                                            </div>


                                            <div class=" form-md-checkboxes">
                                                <div class="col-md-11 form-group">
                                                    <select class="form-control input-lg" name="department">
                                                       <c:forEach items="${list}" var="department">
                                                           <option value="${department.id}" <c:if test="${department.id == item.department.id }">selected</c:if> >${department.name}</option>
                                                       </c:forEach>
                                                    </select>
                                                </div>

                                                    <div class="col-md-11 form-group">

                                                        <select class="form-control input-lg" name="cours">
                                                            <option value="1" <c:if test="${item.couerse == 1}" >selected</c:if>>1-kurs</option>
                                                            <option value="2" <c:if test="${item.couerse == 2}" >selected</c:if>>2-kurs</option>
                                                            <option value="3" <c:if test="${item.couerse == 3}" >selected</c:if>>3-kurs</option>
                                                            <option value="4" <c:if test="${item.couerse == 4}" >selected</c:if>>4-kurs</option>
                                                        </select>
                                                    </div>
                                                <div class="col-md-11 form-group">

                                                    <select class="form-control input-lg" name="block">
                                                        <option value="U">O'qishni boshlash</option>
                                                        <option value="B">O'qishni to'xtatish</option>
                                                    </select>
                                                </div>
                                                    <div class="form-group col-md-11">
                                                        <div class="input-icon input-icon-lg">
                                                            <i ><img src="../../../static/img/flag-uz.png"></i>
                                                            <input name="phone" class="form-control input-lg" type="text" value="${item.phone}" placeholder="+998">

                                                        </div>
                                                    </div>


                                                </div>
                                            </div>

                                        </div>
                                        <div class="form-actions">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-offset-2">
                                                    <button type="submit" class="btn green btn-lg"><spring:message
                                                            code="button.save"/></button>
                                                    <button type="reset" class="btn default btn-lg"><spring:message
                                                            code="button.cancel"/></button>
                                                </div>
                                            </div>
                                        </div>
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

