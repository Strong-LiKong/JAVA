<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>ATM-转账</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="实训,教育,IT">
<meta name="description" content="轻实训ATM案例">
<meta name="author" content="轻实训">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
	<div id="atmMain" class="atm-main">
		<form action="TransferSelvert" method="post"
			onsubmit="return validateTransfer();">
			<div class="main-left">
				<ul class="menu">
					<li>
						<button type="button" onclick="returnMain();">返回</button>
					</li>
				</ul>
			</div>
			<div class="main-content">
				<h3>请输入转入账户名：</h3>
				<input id="targetAccountName" type="text" name="targetAccountName"
					value="" placeholder="转入账户...">
				<h3>请输入转账金额：</h3>
				<input id="transferAmount" type="text" name="transferAmount"
					value="" placeholder="转账金额..."> <br> <br> <br>
				<br>
				<h3 style="color: red">${massage}</h3>
				<h3 style="color: green">${massage1}</h3>
				<h3 style="color: green">${massage2}</h3>
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
			document.getElementById("targetAccountName").focus();
		}

		// 验证转账金额有效性
		function validateTransfer() {
			//获取页面中输入的转入账户名
			var inputTargetAccountName = document
					.getElementById("targetAccountName").value;

			//转入账户名不允许为空
			if (inputTargetAccountName.trim() == "") {
				alert("请输入转入账户名！");

				document.getElementById("targetAccountName").value = "";
				document.getElementById("targetAccountName").focus();
				return false;
			}

			//获取页面中输入的转账金额
			var inputTransferAmount = document.getElementById("transferAmount").value;

			//转账金额不允许为空
			if (inputTransferAmount.trim() == "") {
				alert("请输入转账金额！");

				document.getElementById("transferAmount").value = "";
				document.getElementById("transferAmount").focus();
				return false;
			}

			//转账金额必须为数字
			if (isNaN(inputTransferAmount)) {
				alert("请输入有效的转账金额！");

				document.getElementById("transferAmount").value = "";
				document.getElementById("transferAmount").focus();
				return false;
			}

			//转账金额必须为100的整数倍
			if (inputTransferAmount % 100 != 0) {
				alert("转账金额必须为100的整数倍！");

				document.getElementById("transferAmount").value = "";
				document.getElementById("transferAmount").focus();
				return false;
			}

			//转账金额必须小于1000元
			if (parseInt(inputTransferAmount) > 1000) {
				alert("转账金额必须小于或等于1000元！");

				document.getElementById("transferAmount").value = "";
				document.getElementById("transferAmount").focus();
				return false;
			}
			return true;
		}
	</script>
</body>

</html>