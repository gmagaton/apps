<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<title><tiles:insertAttribute name="title" ignore="true" /> - <tiles:insertAttribute name="pageTitle" ignore="true" /></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
<style>
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="bootstrap/js/html5shiv.js"></script>
    <![endif]-->

<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="${pageContext.request.contextPath}/bootstrap/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="${pageContext.request.contextPath}/bootstrap/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="${pageContext.request.contextPath}/bootstrap/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="${pageContext.request.contextPath}/bootstrap/ico/apple-touch-icon-57-precomposed.png">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/bootstrap/ico/favicon.png">
</head>

<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="brand" href="#"><tiles:insertAttribute name="title" ignore="true" /></a>
				<div class="nav-collapse collapse">
					<tiles:insertAttribute name="menu" />
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container">
		<tiles:insertAttribute name="body" />
	</div>
	<!-- /container -->

	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="${pageContext.request.contextPath}/bootstrap/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-transition.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-alert.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-modal.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-dropdown.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-scrollspy.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-tab.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-tooltip.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-popover.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-button.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-collapse.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-carousel.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-typeahead.js"></script>

</body>
</html>