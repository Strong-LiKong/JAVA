<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>ATM-查询</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="实训,教育,IT">
<meta name="description" content="轻实训ATM案例">
<meta name="author" content="轻实训">

<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body >
	<div id="atmMain" class="atm-main">
		<div class="main-left">
			<ul class="menu">
				<li>
					<button type="button" onclick="returnMain();">返回</button>
				</li>
			</ul>
		</div>
		
		<div class="main-content">
			<h3>当前账户余额</h3>
			<h2>${balance}</h2>
		</div>
		
		<div class="main-right"></div>
	</div>

	<script src="js/common.js" type="text/javascript"></script>

</body>

</html>