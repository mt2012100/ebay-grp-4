<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DebitCard Payment</title>
</head>

<body>
<s:form action="debitCardPay.action">
	<s:textfield label="ATM Number" name="atmNumber"/><br>
	<s:textfield label="ATM Pin Number" name="pinNumber" />
	<s:submit label="Pay"/>
</s:form>
</body>
</html>