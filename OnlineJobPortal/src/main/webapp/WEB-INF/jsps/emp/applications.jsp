<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>

<spring:url value="/logout" var="logoutUrl" />
<spring:url value="/emp/postJob" var="postJob" />
<spring:url value="/emp/allJobs" var="allJobs" />
<spring:url value="/emp/viewReviews" var="viewReviews" />
<spring:url value="/resources/css/mystyle.css" var="style" />
<spring:url value="/emp/viewApplication" var="viewApp" />

<link href="${style}" rel="stylesheet" />
</head>
<body>
<div><H1>JobFair.com</H1></div>
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
<div class="hd">
<div class="mtitle">Employer > List of Candidates</div>
<div class="bd">
			<table cellspacing="0">
				<tr class="tablehd">
				<td>Id</td>
				<td>User Name</td>
				<td>Name</td>
				<td>Email</td>
				<td>Phone Number</td>
				<td>Application Status</td>
			
			</tr>

				<c:forEach var="jobApp" items="${jobApps}">
					<tr class="tablebd">
						<td>${jobApp.jobappid}</td>
						<td><a href="${viewApp}/${jobApp.jobappid}">${jobApp.user.username}</a></td>
						<td>${jobApp.user.name}</td>
						<td>${jobApp.user.email}</td>
						<td>${jobApp.user.phone}</td>
						<td>${jobApp.status}</td>
					</tr>

				</c:forEach>

			</table>
		</div>
</div>		
</body>

</html>
