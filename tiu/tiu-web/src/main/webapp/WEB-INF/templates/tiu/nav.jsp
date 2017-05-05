
<%@ page import="uz.tiu.daily.controllers.admin.topshiriq.TopshiriqController" %>
<%@ page import="uz.tiu.daily.controllers.admin.test.TestController" %>
<%@ page import="uz.tiu.daily.controllers.admin.dalolatnoma.DalolatnomaController" %>
<%@ page import="uz.tiu.daily.controllers.admin.smeta.SmetaController" %>
<%@ page import="uz.tiu.daily.controllers.admin.reestr.ReestrController" %>
<%@ page import="uz.tiu.daily.controllers.admin.Hisobot.HisobotController" %>
<!DOCTYPE html>
<html style="width: 100%">
<head>
    <link rel="stylesheet" href="../../../static/vendor/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="../../../static/css/theme.css">
    <link rel="stylesheet" href="../../../static/css/theme-elements.css">
    <link rel="stylesheet" href="../../../static/css/theme-blog.css">
    <link rel="stylesheet" href="../../../static/css/skins/default.css">
    <link rel="stylesheet" href="../../../static/css/custom.css">
</head>
<div style="background-color: #ffff00;"  >
<header id="header">

    <div  style="margin-top: -10px" >

        <img id="logo" src="../../../static/img/logo.jpg" alt="logo" class="logo-default" style="width: 100%; height: 13%">

        <button class="btn btn-responsive-nav btn-inverse" data-toggle="collapse" data-target=".nav-main-collapse">
            <i>menu</i>
        </button>
    </div>
    <div class="navbar-collapse nav-main-collapse collapse" style="background-color: #0044cc;width: 100%;">
        <div class="container">

        <div class="container"style="background-color: #0044cc;width: 100%;">
            <nav class="nav-main mega-menu" >

                <ul class="nav nav-pills nav-main" id="mainMenu"  >
                    <div class="search" >
                        <form id="searchForm" action="page-search-results.html" method="get">
                            <div class="input-group" >
                                <input style="margin-left: -20px" type="text" class="form-control search" name="q" id="q" placeholder="izlash..." required >
								<span class="input-group-btn">
									<button class="btn btn-default" type="submit"><i class="fa fa-search" ></i></button>
								</span>
                            </div>
                        </form>

                    </div>

                <ul id="menu" style="background-color: #0c91e5;width: 100%;">
                                <li><a href="<%=TopshiriqController.URL_TOPSHIRIQ%>">Topshiriq</a></li>
                                <li><a href="<%=SmetaController.URL_SMETA%>">Smeta</a></li>
                                <li><a href="<%=DalolatnomaController.URL_DALOLATNOMA%>">Dalolatnoma</a></li>
                                <li><a href="<%=TestController.URL_TEST%>">Test natijasi</a></li>
                                <li><a href="<%=ReestrController.URL_REESTR%>">reestr</a></li>
                                <li><a href="">Admin</a></li>
                                <li><a href="<%=HisobotController.URL_HISOBOT%>">Hisobotlar</a></li>
                            </ul>
                            <style>
                    #menu {
                        width: 52%;
                        margin:10px 280px 0 -260px;
                        border: 1px solid #222;
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
                        padding: 2px 10px;
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
        </nav></div>
        </div>
    </header>




</div>
<script src="../../../static/vendor/jquery/jquery.js"></script>

<script src="../../../static/vendor/bootstrap/bootstrap.js"></script>
<script src="../../../static/vendor/common/common.js"></script>
<script src="../../../static/js/theme.js"></script>

<script src="../../../static/js/custom.js"></script>

<script src="../../../static/js/theme.init.js"></script>

</body>
</html>