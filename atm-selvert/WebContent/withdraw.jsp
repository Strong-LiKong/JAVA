<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>ATM-取款</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="实训,教育,IT">
<meta name="description" content="轻实训ATM案例">
<meta name="author" content="轻实训">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
	<div id="atmMain" class="atm-main">
		<form action="WithdrawServlet" method="post"
			onsubmit="return validateWithdraw();">
			<div class="main-left">
				<ul class="menu">
					<li>
						<button type="button" onclick="returnMain();">返回</button>
					</li>
				</ul>
			</div>
			<div class="main-content">
				<h3>请输入取款金额：</h3>
				<input id="withdrawAmount" type="text" name="withdrawAmount"
					value="" placeholder="取款金额"> <br>
				<br>
				<br>
				<br>
				<h3 style="color: green">${withdrawBalance}<br>${withdrawAmount}</h3>
				<h3 style="color: red">${massage}</h3>
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
			document.getElementById("withdrawAmount").focus();
		}

		// 验证取款金额有效性
		function validateWithdraw() {
			//获取页面中输入的取款金额
			var inputWithdrawAmount = document.getElementById("withdrawAmount").value;

			//取款金额不允许为空
			if (inputWithdrawAmount.trim() == "") {
				alert("请输入取款金额！");

				document.getElementById("withdrawAmount").value = "";
				document.getElementById("withdrawAmount").focus();
				return false;
			}

			//取款金额必须为数字
			if (isNaN(inputWithdrawAmount)) {
				alert("请输入有效的取款金额！");

				document.getElementById("withdrawAmount").value = "";
				document.getElementById("withdrawAmount").focus();
				return false;
			}

			//取款金额必须为100的整数倍
			if (inputWithdrawAmount % 100 != 0) {
				alert("取款金额必须为100的整数倍！");

				document.getElementById("withdrawAmount").value = "";
				document.getElementById("withdrawAmount").focus();
				return false;
			}

			//取款金额必须小于1000元
			if (parseInt(inputWithdrawAmount) > 1000) {
				alert("取款金额必须小于或等于1000元！");

				document.getElementById("withdrawAmount").value = "";
				document.getElementById("withdrawAmount").focus();
				return false;
			}
			return true;
		}
	</script>
</body>

</html>