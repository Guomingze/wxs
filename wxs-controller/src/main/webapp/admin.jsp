<%--
  Created by IntelliJ IDEA.
  User: MLIY
  Date: 2018/10/27
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<br>
<head>
    <title>$Title$</title>
    <script type="text/javascript" src="statics/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#dj").click(function(){
                var data = {"uname": $("#uname").val(),"upwd": $("#upwd").val()}
                $.ajax({
                    url: "login/admin",
                    data: JSON.stringify(data),
                    contentType: "application/json",
                    datatype: "json",
                    type: "post",
                    success:function(res) {
                        alert(res)
                    }
                });
            });
        });
    </script>
</head>

<br>
用户名:<input type="text" id="uname" name="uname"/></br>
密码:<input type="password" id="upwd" name="upwd" /></<br>>
<input type="submit" id="dj">
</body>
</html>
