<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>eBay</title>
<!-- <link rel="stylesheet" href="styles/reset.css" /> -->
<link rel="stylesheet" href="styles/foundation/normalize.css" />
<link rel="stylesheet" href="styles/foundation/foundation.css" />
<link rel="stylesheet" href="styles/style.css" />
<!-- <link rel="stylesheet" href="styles/avgrund.css" /> -->
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<!-- <script type="text/javascript" src="js/jquery.avgrund.js"></script> -->

<style type="text/css">
.category-select {
	padding-top: 5px;
	height: 42px;
}

.product-img {
	height: 170px;
	width: 200px;
}

body {
	margin-left: 0px;
	width: 100%;
}

.price-text {
	width: 50px !important;
}

.searchBar {
	margin-left: 10px;
}
</style>
</head>
<body>
	<div>
		<div class="row header-box">
			<tiles:insertAttribute name="header" />
		</div>
		<div class="row body-box">
			<tiles:insertAttribute name="body" />
		</div>

		<div class="row footer-box">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>