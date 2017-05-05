<%@ page import="uz.tiu.daily.controllers.admin.user.UsersController" %>
<%--<%@ page import="uz.tiu.daily.controllers.admin.student.StudentController" %>--%>
<%@ page import="uz.tiu.daily.controllers.admin.topshiriq.TopshiriqController" %>
<%@ page import="uz.tiu.daily.controllers.admin.smeta.SmetaController" %>
<%@ page import="uz.tiu.daily.controllers.admin.dalolatnoma.DalolatnomaController" %>
<%@ page import="uz.tiu.daily.controllers.admin.test.TestController" %>
<%@ page import="uz.tiu.daily.controllers.admin.reestr.ReestrController" %>

<%@ page import="uz.tiu.daily.controllers.admin.Hisobot.HisobotController" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="page-header">

    <body>
    <img id="logo" src="../../../static/img/logo.png" alt="logo" class="logo-default" style="width: 100%;">
    <ul id="menu">
        <li><a href="<%=TopshiriqController.URL_TOPSHIRIQ%>">Toпширик</a></li>
        <li><a href="<%=SmetaController.URL_SMETA%>">Смета</a></li>
        <li><a href="<%=DalolatnomaController.URL_DALOLATNOMA%>">Далолатнома</a></li>
        <li><a href="<%=TestController.URL_TEST%>">Тест Натижаси</a></li>
        <li><a href="<%=ReestrController.URL_REESTR%>">Реестр</a></li>
        <li><a href="">Админ</a></li>
        <li><a href="<%=HisobotController.URL_HISOBOT%>">Хисоботлар</a></li>
    </ul>

    </body>
    <style>

        body{
            background-image:url("/static/img/body-bg.jpg");

        }
        #menu {
            width: 72%;
            margin:0 260px  auto;
            border: 1px solid #222;
            background-image:url("/static/img/abs.png");
            

            -moz-border-radius: 6px;
            -webkit-border-radius: 6px;
            border-radius: 6px;
            -moz-box-shadow: 0 1px 1px #777, 0 1px 0 #666 inset;
            -webkit-box-shadow: 0 1px 1px #777, 0 1px 0 #666 inset;
            box-shadow: 0 1px 1px #777, 0 1px 0 #666 inset;
        }




        #menu:after {
            content: "";
            display: table;
        }
        #menu:after {
            clear: both;
        }
        #menu li {

            float: left;
            border-right: 1px solid #0b9997;
            -moz-box-shadow: 1px 0 0 #309909;
            -webkit-box-shadow: 1px 0 0 #444;
            box-shadow: 1px 0 0 #08440e;
            position: relative;
        }
        #menu p{
            font-size: 30px;
        }

        #menu a {
            float: left;
            font-size: 200%;
            padding: 12px 30px;
            color: #000000;
            text-transform: uppercase;
            font: bold 12px Arial, Helvetica;
            text-decoration: none;
            text-shadow: 0 1px 0 #000;
        }

        #menu li:hover > a {
            color: #fafafa;
        }


    </style>

    
</div>

