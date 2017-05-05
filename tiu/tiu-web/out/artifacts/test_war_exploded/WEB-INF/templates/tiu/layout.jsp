
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:url var="url_ctx" value="/" htmlEscape="true" scope="session"/>
<spring:url var="url_images" value="/static/img" htmlEscape="true" scope="session"/>
<spring:url var="url_js" value="/static/js" htmlEscape="true" scope="session"/>
<spring:url var="url_css" value="/static/css" htmlEscape="true" scope="session"/>
<spring:url var="url_pages" value="/static/pages" htmlEscape="true" scope="session"/>

<html>
<head>
    <meta charset="UTF-8">
    <title>Hisobot</title>
    <link href="../../../static/plugin/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="../../../static/plugin/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
    <link href="../../../static/plugin/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="../../../static/css/uniform.default.css" rel="stylesheet" type="text/css"/>
    <link href="../../../static/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
    <!-- END GLOBAL MANDATORY STYLES -->

    <link href="../../../static/css/morris.css" rel="stylesheet" type="text/css"/>

    <!-- BEGIN THEME GLOBAL STYLES -->
    <link href="../../../static/css/components-md.min.css" rel="stylesheet" id="style_components" type="text/css"/>
    <link href="../../../static/css/plugins-md.min.css" rel="stylesheet" type="text/css"/>
    <!-- END THEME GLOBAL STYLES -->
    <!-- BEGIN THEME LAYOUT STYLES -->
    <link href="../../../static/css/layout.min.css" rel="stylesheet" type="text/css"/>
    <link href="../../../static/css/default.min.css" rel="stylesheet" type="text/css" id="style_color"/>
    <link href="../../../static/css/custom.min.css" rel="stylesheet" type="text/css"/>
    <link href="../../../static/plugin/bootstrap-select/css/bootstrap-select.css" rel="stylesheet" type="text/css"/>
    <link href="../../../static/plugin/bootstrap-fileinput/bootstrap-fileinput.css" rel="stylesheet" type="text/css"/>
    <link href="../../../static/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="../../../static/plugin/bootstrap-daterangepicker/daterangepicker.min.css" rel="stylesheet" type="text/css"/>
    <link href="../../../static/plugin/bootstrap-datepicker/css/bootstrap-datepicker3.min.css" rel="stylesheet" type="text/css"/>


    <!-- END THEME LAYOUT STYLES -->
    <link rel="shortcut icon" href="favicon.ico"/>

    <script src="../../../static/js/jquery.min.js" type="text/javascript"></script>
    <script src="../../../static/plugin/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="../../../static/js/js.cookie.min.js" type="text/javascript"></script>
    <script src="../../../static/js/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
    <script src="../../../static/js/jquery.slimscroll.min.js" type="text/javascript"></script>
    <script src="../../../static/js/jquery.blockui.min.js" type="text/javascript"></script>
    <script src="../../../static/js/jquery.uniform.min.js" type="text/javascript"></script>
    <script src="../../../static/js/bootstrap-switch.min.js" type="text/javascript"></script>
    <script src="../../../static/plugin/bootstrap-select/js/bootstrap-select.js" type="text/javascript"></script>
    <script src="../../../static/plugin/bootstrap-fileinput/bootstrap-fileinput.js" type="text/javascript"></script>
    <!-- END CORE PLUGINS -->
    <!-- BEGIN PAGE LEVEL PLUGINS -->
    <script src="../../../static/js/moment.min.js" type="text/javascript"></script>
    <script src="../../../static/js/morris.min.js" type="text/javascript"></script>

    <script src="../../../static/js/app.min.js" type="text/javascript"></script>
    <script src="../../../static/js/components-bootstrap-select.js" type="text/javascript"></script>
    <!-- END THEME GLOBAL SCRIPTS -->
    <!-- BEGIN PAGE LEVEL SCRIPTS -->
    <script src="../../../static/js/dashboard.min.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL SCRIPTS -->
    <!-- BEGIN THEME LAYOUT SCRIPTS -->
    <script src="../../../static/js/layout.min.js" type="text/javascript"></script>
    <script src="../../../static/js/demo.min.js" type="text/javascript"></script>
    <script src="../../../static/js/quick-sidebar.min.js" type="text/javascript"></script>
    <script src="../../../static/js/main.js" type="text/javascript"></script>
    <script src="../../../static/js/bootbox.js" type="text/javascript"></script>
    <script src="../../../static/plugin/bootstrap-daterangepicker/daterangepicker.min.js" type="text/javascript"></script>
    <script src="../../../static/plugin/bootstrap-datepicker/js/bootstrap-datepicker.js" type="text/javascript"></script>
    <script src="../../../static/js/components-date-time-pickers.min.js" type="text/javascript"></script>

    <tiles:insertAttribute name="heads" ignore="true"/>

</head>
<body class="page-container-bg-solid page-boxed page-md">

<tiles:insertAttribute name="sidebar"/>
<%--<div data-ng-include=" '/static//views/partials/sidebar.html' "></div>--%>


<tiles:insertAttribute name="page-top" ignore="true"/>

<div>
    <tiles:insertAttribute name="header"/>
    <div class="page-container">
        <!-- BEGIN CONTENT -->
        <div class="page-content-wrapper">
            <div class="page-head">
                <div class="container">
                    <div class="page-toolbar">

                    </div>
                </div>
            </div>
            <div class="page- content">
                <tiles:insertAttribute name="content"/>
            </div>
        </div>
    </div>
</div>
<tiles:insertAttribute name="footer"/>

</body>
</html>