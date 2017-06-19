<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<spring:url value="/resources/css/mystyle.css" var="style" />
<spring:url value="/logout" var="logoutUrl" />
<spring:url value="/jobSeeker/allJobs" var="allJobs" />
<spring:url value="/jobSeeker/viewAppliedJobs" var="viewAppliedJobs" />
<spring:url value="/jobSeeker/viewJob" var="viewjob" />
<link href="${style}" rel="stylesheet" />
</head>
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
<div class="mtitle">List of Available Jobs</div>
<div class="bd">
			<table cellspacing="0">
				<tr class="tablehd">
				
				<td>Job Id</td>
				<td >Job Code</td>
				<td >Job Position</td>
				<td >Location</td>
				<td>Posted By</td>
				<td>Posted Date</td>
				<td>Status</td>
			
			</tr>

				<c:forEach var="job" items="${jobs}">
					<fmt:formatDate pattern="MM/dd/yyyy" value="${job.postedDate}" var="date" />	
			
					<tr class="tablebd">
						<td>${job.jobid}</td>
						<td><a href="${viewjob}/${job.jobid}">${job.code}</a></td>
						<td>${job.position}</td>
						<td>${job.location}</td>
						<td>${job.user.username}</td>
						<td>${date}</td>
						<td>${job.status}</td>
				</tr>

				</c:forEach>

			</table>
		</div>
</div>		
		
</body>

</html>
