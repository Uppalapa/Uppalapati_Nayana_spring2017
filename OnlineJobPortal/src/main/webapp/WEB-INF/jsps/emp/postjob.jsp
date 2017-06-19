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

<spring:url value="/emp/submitJob" var="submitJob" />
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
<div class="mtitle">Employer > Post a new Job</div>
<div class="bd">
			<div>
	

	<form:form method="Post" action="${submitJob}" modelAttribute="job">
	<div>
	<table style="padding-left:10px;">
     <tr>
     	<td class="formlabel">Job Code :</td>
     	<td><div><form:errors path="code" class="err"/></div>
    			 <form:input path="code" /></td>
    </tr>
      <tr>
     	<td class="formlabel">Job Position :</td>
     	<td><div><form:errors path="position" class="err"/></div>
    			 <form:input path="position" /></td>
    </tr>
     <tr>
     	<td class="formlabel">Job Location :</td>
     	<td><div><form:errors path="location" class="err"/></div>
    			 <form:input path="location" /></td>
    </tr>
     <tr>
     	<td class="formlabel">Primary Skill :</td>
     	<td><div><form:errors path="primaryskill" class="err"/></div>
    			 <form:input path="primaryskill" /></td>
    </tr> 
     <tr>
     	<td class="formlabel">Secondary Skill (optional):</td>
     	<td><form:input path="secondaryskill" /></td>
    </tr> 
     <tr>
     	<td class="formlabel">Other Skills (optional):</td>
     	<td><form:input path="otherskills" /></td>
    </tr> 
 
       <tr>
     	<td class="formlabel">Experience :</td>
     	<td><div><form:errors path="exp" class="err"/></div>
    			 <form:input path="exp" />&nbsp;<span class="txtlabel">yrs</span></td>
    </tr> 
       <tr>
     	<td class="formlabel">Responsibilities :</td>
     	<td><div><form:errors path="responsibilities" class="err"/></div>
     	<form:textarea path="responsibilities" rows="5" cols="50" /></td>
     </tr>
	  <tr>
     	<td class="formlabel">Status :</td>
     	<td><div><form:errors path="status" class="err"/></div>
     	<form:select path="status">
     	    <form:option value="ACTIVE">ACTIVE</form:option>
     	     <form:option value="INACTIVE">INACTIVE</form:option>
     	</form:select></td>
     </tr>
     <tr>
     	<td class="formlabel">   
     	<form:hidden path="jobid"/></td>
     	<td><input type="submit"  value="submit"/></td></tr>
    </table>
	</div>
	
	</form:form>
	
</div>
		</div>
</div>		
</body>	
	
</html>
