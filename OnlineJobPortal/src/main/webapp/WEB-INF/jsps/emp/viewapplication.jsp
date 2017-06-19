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
<div class="mtitle">Employer > View Job Application</div>
<div class="bd">
	<div>
	<form:form method="Post" action="" modelAttribute="jobApp">
	<div>
	<table style="padding-left:20px;">
     <tr class="formtable">
     	<td class="formlabel">Job Code :</td>
     	<td>${jobApp.job.code}</td>
     </tr>
     <tr class="formtable">
     	<td class="formlabel">Job Position :</td>
     	<td>${jobApp.job.position}</td>
     </tr>
       <tr class="formtable">
     	<td class="formlabel">Job Location :</td>
     	<td>${jobApp.job.location}</td>
    </tr>
     <tr class="formtable">
     	<td class="formlabel">Primary Skill :</td>
     	<td>${jobApp.job.primaryskill}</td>
    </tr> 
     <tr class="formtable">
     	<td class="formlabel">Applicant :</td>
     	<td>${jobApp.user.username}</td>
     </tr>
     <tr class="formtable">
     	<td class="formlabel">Email :</td>
     	<td>${jobApp.user.email}</td>
     </tr>
     <tr class="formtable">
     	<td class="formlabel">Address :</td>
        <td>${jobApp.user.address}</td>
     </tr>
     <tr class="formtable">
     	<td class="formlabel">Description :</td>
     	<td>${jobApp.user.myself}</td>
     </tr>
    </table>
	</div>
	</form:form>

	
</div>
		</div>
</div>		
</body>	
	
	
</html>
