<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>ATM-登录</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="实训,教育,IT">
<meta name="description" content="轻实训ATM案例">
<meta name="author" content="轻实训">

<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
	<div id="loginContainer" class="login-container">
		<div class="container-left">
			<img src="images/login.jpg">
		</div>
		<div class="container-right">
			<h1>ATM系统登录</h1>
			<form name="loginForm" action="LoginServlet" onsubmit="return login()"
				method="post">
				<div class="input-group">
					<label>用户名：</label> <input type="text" name="username"
						class="input" id="username" placeholder="请输入您的用户名！">
				</div>
				<div class="input-group">
					<label class="letter">密&nbsp;&nbsp;&nbsp;码：</label> <input
						type="password" name="password" class="input" id="passWord"
						placeholder="请输入您的登录密码！">
				</div>
				<div class="login-control">
					<button type="submit" class="">登录</button>
					<button type="reset" class="">重置</button>
					<br>
					<h3 style="color: red">${massage}</h3>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		// 登陆验证函数
		function login() {
			//获取用户输入的用户名
			var username = document.getElementById("username").value;
			//获取用户输入的密码
			var password = document.getElementById("passWord").value;

			//验证用户输入项
			if (username == "") {
				alert("用户名不允许为空！");
				return false;
			} else if (password == "") {
				alert("密码不允许为空！");
				return false;
			}

			return true;
		}
	</script>
</body>

</html>
