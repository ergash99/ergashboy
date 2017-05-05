
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--@elvariable id="item" type="uz.tiu.daily.persistence.Daily"--%>
<spring:url var="url_file_download" value="/file/download/" htmlEscape="true" scope="session"/>
<div class="adminbody" style="background-image: url(../../../static/img/fon.jpg);)">
    <div class="table_border">


        <div class="breadcrumb-wrapper" >
            <%--<div class="col-lg-8 col-lg-offset-5" >--%>

                <%--<h2 class="mainTitle no-margin" style="color:#0044cc;font-size: 400%" >Talaba </h2>--%>
            <%--</div>--%>
        </div>


        <!-- start: STRIPED ROWS -->
        <div class="container-fluid container-fullw">
            <div class="row">
                <div class="col-md-12">
                    <div id="users-table">
                        <div class="panel panel-white">

                        </div>
                        <div >
                            <div class="panel-body">
                                <div class="table-responsive" style="margin-top: 1px">
                                    <div class="col-lg-12" >
                                        <div  class="col-lg-5" >

                                            <img style="background-image: url(../../../static/img/talaba1.png); width: 340px;height: 333px;" class="img-thumbnail" style="max-height: 50%;max-width:100%;margin-left: 200px;" alt="Talaba rasmi" src="${url_file_download}${item.students.photo.fileUrl}" />



                                   </div>
                                        <div class="col-lg-2"style="font-size: 400%; color:#6a5422">
                                            Ismi:<br>
                                            Familiyasi<br>
                                            Sharifi:<br>
                                            Yunalishi:

                                        </div>

                                             <div class="col-lg-5" class="well well-sm" style="color:#181b1f;text-shadow:  1px 1px 2px black, 0 0 25px #fffaf5, 0 0 5px darkblue;">
                                  <h1 style="font-size: 400%;margin-left: 100px;">
                                   ${item.students.name}<br>

                                  ${item.students.lastName}<br>
                                      ${item.students.midleName}<br></h1>
                                                 <h1 style=" color:#181b1f;font-size: 800%;text-shadow: 1px 1px 2px black, 0 0 25px #fffaf5, 0 0 5px darkblue;margin-left: 100px;">
                                     ${item.students.department.name}-

                                   ${item.students.couerse}
                                   </h1>
                                                 </div>


                                    </div>
                                </div>
                            </div>
                        </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div >
