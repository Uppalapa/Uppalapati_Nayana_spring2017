<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
	<spring:url value="/resources/css/mystyle.css" var="style" />
<spring:url value="/logout" var="logoutUrl" />
<spring:url value="/jobSeeker/allJobs" var="allJobs" />
<spring:url value="/jobSeeker/viewAppliedJobs" var="viewAppliedJobs" />
	<spring:url value="/jobSeeker/submitReview" var="submitReview" />
		
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
	<div class="mtitle">JobSeeker > Add Review</div>
	<div class="bd">
		<div>
		<form:form method="Post" action="${submitReview}" modelAttribute="review">
	<table style="padding-left:10px;">
    <tr class="formtable">
     	<td class="formlabel">Employer :</td>
     	<td>${review.empUserName}<form:hidden path="empUserName"/></td>
    </tr>
    <tr class="formtable">
     	<td class="formlabel">Interview Rating :</td>
     	<td><div><form:errors path="interviewrating" class="err"/></div>
    			 <form:input path="interviewrating" /></td>
     </tr>
     <tr class="formtable">
     	<td class="formlabel">Salary Rating :</td>
     		<td><div><form:errors path="salaryrating" class="err"/></div>
    			 <form:input path="salaryrating" /></td>
     </tr>
     <tr class="formtable">
     	<td class="formlabel">Work Life Balance :</td>
     	<td><div><form:errors path="worklifebalance" class="err"/></div>
    			 <form:input path="worklifebalance" /></td>
     </tr>
      <tr>
     	<td class="formlabel">comments :</td>
     	<td><div><form:errors path="comments" class="err"/></div>
     	<form:textarea path="comments" rows="5" cols="50" /></td>
     </tr>
    <tr>
     	<td class="formlabel">   
     	<form:hidden path="reviewon"/></td>
     	<td><input type="submit"  value="Add Review"/></td></tr>
    </table>
    </form:form>
	</div>
	</div>
</div>

</body>
	
	
</html>
