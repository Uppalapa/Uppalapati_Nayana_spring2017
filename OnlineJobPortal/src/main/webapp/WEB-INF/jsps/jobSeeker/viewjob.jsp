<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<spring:url value="/resources/css/mystyle.css" var="style" />
<spring:url value="/logout" var="logoutUrl" />
<spring:url value="/jobSeeker/allJobs" var="allJobs" />
<spring:url value="/jobSeeker/viewAppliedJobs" var="viewAppliedJobs" />
<spring:url value="/jobSeeker/applyJob" var="applyJob" />
<spring:url value="/jobSeeker/viewProfile" var="viewProfile" />
<link href="${style}" rel="stylesheet" />
</head>
<body>
<div>
	<H1>JobFair.com</H1>
</div>

<div class="hd">
	<div class="mtitle">JobSeeker Dashboard</div>
	<div class="menu">
		<a href="${allJobs}">Search Job</a>&nbsp;| <a
			href="${viewAppliedJobs}">Applied Jobs</a>&nbsp;|
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<a href="#" onclick="document.getElementById('logoutForm').submit();">Logout</a>
		</c:if>
	</div>
</div>
<div>
	<form id="logoutForm" action="${logoutUrl}" method="post"
		name="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
</div>
<div class="hd">
	<div class="mtitle">JobSeeker > View Job Post</div>
	<div class="bd">
		<div>

			<form:form method="Post" action="${applyJob}" modelAttribute="job">
				<div>
					<table style="padding-left: 10px;">
						<tr class="formtable">
							<td class="formlabel">Posted By :</td>
							<td><a href="${viewProfile}/${job.user.username}">${job.user.username}</a></td>
						</tr>
						<tr class="formtable">
							<td class="formlabel">Job Code :</td>
							<td>${job.code}</td>
						</tr>
						<tr class="formtable">
							<td class="formlabel">Job Position :</td>
							<td>${job.position}</td>
						</tr>
						<tr class="formtable">
							<td class="formlabel">Job Location :</td>
							<td>${job.location}</td>
						</tr>
						<tr class="formtable">
							<td class="formlabel">Primary Skill :</td>
							<td>${job.primaryskill}</td>
						</tr>
						<tr class="formtable">
							<td class="formlabel">Secondary Skill :</td>
							<td>${job.secondaryskill}</td>
						</tr>
						<tr class="formtable">
							<td class="formlabel">Other Skills :</td>
							<td>${job.otherskills}</td>
						</tr>
						<tr class="formtable">
							<td class="formlabel">Experience :</td>
							<td>${job.exp}&nbsp;yrs</td>
						</tr>
						   <tr class="formtable">
     						<td class="formlabel">Responsibilities :</td>
     						<td>${job.responsibilities}</td>
    					 </tr>
 						<tr class="formtable">
							<td class="formlabel"><form:hidden path="jobid" /></td>
							<td>
							<c:choose>
							   	<c:when test="${job.jobApplyStatus == 'APPLIED'}">
			                       <b class="err">You already applied for this Job.</b>
								</c:when>
							    <c:otherwise>
							   		<input type="submit" value="Apply" />
							    </c:otherwise>
							 </c:choose>
							</td>
						</tr>
					</table>
				</div>

			</form:form>

		</div>
	</div>
</div>

</body>

</html>
