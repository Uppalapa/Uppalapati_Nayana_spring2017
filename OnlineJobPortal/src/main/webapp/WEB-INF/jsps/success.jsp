<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<spring:url value="/resources/css/mystyle.css" var="style" />
<spring:url value="/home" var="home" />
<head>
<link href="${style}" rel="stylesheet" />
<title>Online JobFair Registration</title>
</head>
<body>
	<div>
		<H1>JobFair.com</H1>
	</div>
	<div class="hd">
		<div class="mtitle">JobFair Registration</div>
		<div class="bd">
			<div>
				<div>
					<p>Welcome to Online JobFair Platform.</p>
					<div><p>Dear ${user.username}, You have successfully created
						your profile as ${user.role}.</p></div>
					<div>
						<p>Please <a href="${home}">login</a> to jobfair.com</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
