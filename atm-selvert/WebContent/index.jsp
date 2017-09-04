<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>ATM-首页</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="实训,教育,IT">
<meta name="description" content="轻实训ATM案例">
<meta name="author" content="轻实训">

<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
	<div id="atmMain" class="atm-main">
		<div class="main-left">
			<ul class="menu">
				<li>
					<button type="button" onclick="transfer();">转账</button>
				</li>
				<li>
					<button type="button" onclick="changePassword();">改密</button>
				</li>
				<li>
					<button type="button" onclick="exit();">退出</button>
				</li>
			</ul>
		</div>
		<div class="main-content">
			<h1>欢迎登录实训银行</h1>

		</div>
		<div class="main-right">
			<ul class="menu">
				<li>
					<button type="button" onclick="query();">查询</button>
				</li>
				<li>
					<button type="button" onclick="deposit();">存款</button>
				</li>
				<li>
					<button type="button" onclick="withdraw();">取款</button>
				</li>
			</ul>
		</div>
	</div>
	<script type="text/javascript">
		// 转账
		function transfer() {
			document.location = "transfer.jsp";
		}

		//修改密码
		function changePassword() {
			document.location = "changePassword.jsp";
		}

		function exit() {
			document.location = "LogoutServlet";
		}

		function query() {
			document.location = "QueryServlet";
		}

		function deposit() {
			document.location = "deposit.jsp";
		}

		function withdraw() {
			document.location = "withdraw.jsp";
		}
	</script>
</body>

</html>