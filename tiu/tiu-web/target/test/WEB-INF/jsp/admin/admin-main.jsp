
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--@elvariable id="daily" type="uz.tiu.daily.persistence.Daily"--%>
<div class="adminbody">
    <div class="table_border">

        <div class="breadcrumb-wrapper" style="float: left;">
            <h2 class="mainTitle no-margin" style="margin-left: 50px">Holat</h2>
        </div>


        <!-- start: STRIPED ROWS -->
        <div class="container-fluid container-fullw">
            <div class="row">
                <div class="col-md-12">
                    <div id="users-table">
                        <div class="panel panel-white">

                        </div>
                        <div class="panel panel-white">
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <div class="col-md-12">

                                    </div>

                                    <table class="table table-bordered table-striped table-hover dataTable">
                                        <thead>

                                        </thead>
                                        <tbody>

                                        </tbody>
                                    </table>
                                    <jsp:include page="/WEB-INF/jsp/common/pagination.jsp"/>
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
<script>
    $(document).ready(function () {
        url_base = '/index';
        div_base = 'users-table';
        console.log(url_base);
    })
</script>