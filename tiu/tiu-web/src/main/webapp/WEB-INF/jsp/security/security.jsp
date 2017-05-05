
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="col-lg-offset-3 col-lg-6" style="padding-top: 30px">
    <input type="text" id="check-security" class="form-control" style="font-size: 30px;">
</div>
<div id="check-student">
    <jsp:include page="security-check.jsp"/>
</div>
<script>
    $(document).ready(function () {
        $("#check-security").keyup(function () {
            var idNumber = $("#check-security").val();
            if (idNumber.length > 12){
                $("#check-security").val("")
                $.ajax({
                    url: "/security-check.htm?code="+idNumber,
                    cache: false,
                    type:'GET',
                    success: function (html) {
                        $("#check-student").html(html);
                    }

                });
            }
        })
    })
</script>