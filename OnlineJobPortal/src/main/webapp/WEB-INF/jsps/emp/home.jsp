<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<spring:url value="/resources/css/mystyle.css" var="style" />

<spring:url value="/logout" var="logoutUrl" />
<spring:url value="/emp/postJob" var="postJob" />
<spring:url value="/emp/allJobs" var="allJobs" />
<spring:url value="/emp/viewReviews" var="viewReviews" />
<link href="${style}" rel="stylesheet" />
<title>JobFair Employer Dashboard</title>
</head>
<body>
<div><H1>Employer Successfully logged in!</H1></div>

<div class="hd">
<div class="mtitle">Employer Dashboard</div>
<div class="menu">
<a href="${postJob}">Post a Job</a>&nbsp;|
<a href="${allJobs}">My Posted Jobs</a>&nbsp;|
<a href="${viewReviews}">Reviews</a>&nbsp;|
<c:if test="${pageContext.request.userPrincipal.name != null}">
<a href="#" onclick="document.getElementById('logoutForm').submit();">Logout</a></c:if>
</div></div>
<div><form id="logoutForm" action="${logoutUrl}" method="post" name="logoutForm">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>	
		</div>
		
</body>
</html>