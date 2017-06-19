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

<spring:url value="/emp/viewJob" var="viewjob" />
<spring:url value="/emp/viewApplicants" var="viewApps" />

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
<div class="mtitle">Employer > Review Ratings</div>
<div class="bd">
			<table cellspacing="0">
				<tr class="tablehd">
				<td>Review Id</td>
				<td>Interview</td>
				<td>Salary</td>
				<td >Work Life Balance</td>
				<td >Reviewed by</td>
			
			</tr>

				<c:forEach var="review" items="${reviews}">
					<tr class="tablebd">
						<td>${review.reviewid}</td>
						<td>${review.interviewrating}</td>
						<td>${review.salaryrating}</td>
						<td>${review.worklifebalance}</td>
						<td>${review.userreviewed.username}</td>
					</tr>

				</c:forEach>

			</table>
		</div>
</div>		
</body>
	
</html>
