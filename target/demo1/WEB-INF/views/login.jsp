<html>
<head>
	<meta charset="utf-8">
    <script>
        function  submit() {
            var username=$("#username").val();
            var password=$("#password").val();
            if(username==""||password==""){
                alert("不能为空");
                return;
            }
            $.ajax({
                url:"/login",
                type:"post",
                dataType:"json",
                timeout:5000,
                data:{"username":username,"password":password},
                success:function (result) {
                    window.location.href="/demo1/index";
                },
                error:function (err) {
                    alert("网络错误");
                }
            });
        }

    </script>


</head>
<body>
	<%--<form action="/demo1/register" method="POST">--%>
		<%--<div>--%>
			<%--<span>account：</span><input type="text" name="username" id="username"><br>--%>
		<%--</div>--%>
		<%--</div>--%>
			<%--<span>password：</span><input type="password" name="password" id="password">--%>
		<%--</div>--%>
		<%--<input type="submit" value="submit" >--%>
	<%--</form>--%>


		<div>
			<span>account：</span><input type="text" name="username" id="username"><br>
		</div>
		</div>
		<span>password：</span><input type="password" name="password" id="password">
		</div>
        <p><button type="submit" onclick="submit()" id="logInButton" class="am-btn am-btn-default">登录</button></p>

</body>
</html>