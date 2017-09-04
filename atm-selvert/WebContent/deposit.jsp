<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>ATM-存款</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="实训,教育,IT">
<meta name="description" content="轻实训ATM案例">
<meta name="author" content="轻实训">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
	<div id="atmMain" class="atm-main">
		<form action="DepositServlet" method="post"
			onsubmit="return validateDeposit();">
			<div class="main-left">
				<ul class="menu">
					<li>
						<button type="button" onclick="returnMain();">返回</button>
					</li>
				</ul>
			</div>
			<div class="main-content">
				<h3>请输入存款金额：</h3>
				<input id="depositAmount" type="text" name="depositAmount" value=""
					placeholder="存款金额">
					<br><br><br>
					<h3 style="color: green;">${depositAccount}<br>${depositBalance}</h3>
			</div>
			<div class="main-right">
				<ul class="menu">
					<li>
						<button type="submit">确认</button>
					</li>
				</ul>
			</div>
		</form>
	</div>
	<script src="js/common.js" type="text/javascript"></script>
	<script type="text/javascript">
		//页面元素加载完成后，执行 window.onload 事件
		window.onload = function() {
			document.getElementById("depositAmount").focus();
		}

		// 验证存款金额有效性
		function validateDeposit() {
			//获取页面中输入的存款金额
			var inputDepositAmount = document.getElementById("depositAmount").value;

			//存款金额不允许为空
			if (inputDepositAmount.trim() == "") {
				alert("请输入存款金额！");

				document.getElementById("depositAmount").value = "";
				document.getElementById("depositAmount").focus();
				return false;
			}

			//存款金额必须为数字
			if (isNaN(inputDepositAmount)) {
				alert("请输入有效的存款金额！");

				document.getElementById("depositAmount").value = "";
				document.getElementById("depositAmount").focus();
				return false;
			}

			//存款金额必须为100的整数倍
			if (inputDepositAmount % 100 != 0) {
				alert("存款金额必须为100的整数倍！");

				document.getElementById("depositAmount").value = "";
				document.getElementById("depositAmount").focus();
				return false;
			}

			//存款金额必须小于1000元
			if (parseInt(inputDepositAmount) > 1000) {
				alert("存款金额必须小于或等于1000元！");

				document.getElementById("depositAmount").value = "";
				document.getElementById("depositAmount").focus();
				return false;
			}
			return true;
		}
	</script>
</body>

</html>