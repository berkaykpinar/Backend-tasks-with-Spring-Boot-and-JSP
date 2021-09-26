<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" src="/apparel/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/apparel/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/apparel/js/jquery.slicknav.min.js"></script>
<script type="text/javascript" src="/apparel/js/owl.carousel.min.js"></script>
<script type="text/javascript" src="/apparel/js/jquery.nicescroll.min.js"></script>
<script type="text/javascript" src="/apparel/js/jquery.zoom.min.js"></script>
<script type="text/javascript" src="/apparel/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="/apparel/js/main.js"></script>

<input type="hidden" id="crsftoken" value="'?'+${_csrf.parameterName}+'='+${_csrf.token}+'"/>
<input type="hidden" id="csrf" value="${_csrf.token}"/>

<script type="text/javascript">
    $(document).ready(function () {
        $("#sendAjaxBtn").click(function () {
            $.ajax({
                url: "/apparel/kampanyalar/addFeedbackAjax",
                type: "POST",
                data: {name: $("#name").val(), surname: $("#surname").val(), message: $("#message").val(), _csrf: $("#csrf").val() },
                success: function (data) {
                    alert(data);
                }
            });
        });
    });
    $(document).ready(function () {
        $("#addToCartWithAjax").click(function () {
            $.ajax({
                url: "/cart/detail/addToCart",
                type: "POST",
                data: {name: $("#name").val(), _csrf: $("#csrf").val() },
                success: function (data) {
                    alert(data);
                }
            });
        });
    });
</script>