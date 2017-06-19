<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
<spring:url value="/resources/css/mystyle.css" var="style" />

<spring:url value="/logout" var="logoutUrl" />
<spring:url value="/jobSeeker/allJobs" var="allJobs" />
<spring:url value="/jobSeeker/viewAppliedJobs" var="viewAppliedJobs" />

<link href="${style}" rel="stylesheet" />
	</head>
	<body>
	<body>
<div><H1>JobFair.com</H1></div>

<div class="hd">
<div class="mtitle">JobSeeker Dashboard</div>
<div class="menu">
<a href="${allJobs}">Search Job</a>&nbsp;|
<a href="${viewAppliedJobs}">Applied Jobs</a>&nbsp;|
<c:if test="${pageContext.request.userPrincipal.name != null}">
<a href="#" onclick="document.getElementById('logoutForm').submit();">Logout</a></c:if>
</div></div>
<div><form id="logoutForm" action="${logoutUrl}" method="post" name="logoutForm">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>	
		</div>
<div class="hd">
<div class="mtitle">Message</div>
<div class="bd">
		<div>
		${message}
		
		</div>	
		</div>
</div>		
		
</body>
	<div>
		
	</div>
	

	</body>
</html>
