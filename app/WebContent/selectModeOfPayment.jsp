<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Select Mode of Payment</title>
</head>
<body>
	<label>Choose Mode of Payment</label>
	<div class="row">
	<div class="modeOfPayment">
		<a href="debitCardForward.action">Debit Card</a>
	</div><br>
	<div class="modeOfPayment">
		<a href="creditCardForward.action">Credit Card</a>
	</div><br>
	<div class="modeOfPayment">
		<a href="cashOnDeliveryForward.action">Cash on Delivery</a>
	</div>
	</div>
</body>
</html>