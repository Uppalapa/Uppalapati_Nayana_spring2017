<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
	<spring:url value="/resources/css/mystyle.css" var="style" />
	<spring:url value="/logout" var="logoutUrl" />
	<spring:url value="/jobSeeker/allJobs" var="allJobs" />
<spring:url value="/jobSeeker/viewAppliedJobs" var="viewAppliedJobs" />
	
	<spring:url value="/jobSeeker/addReview" var="addReview" />
	<spring:url value="/jobSeeker/viewEmpPdf" var="viewEmpPdf" />	
		
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
	<div class="mtitle">JobSeeker > View Employer Profile</div>
	<div class="bd">
		<div>
	<table style="padding-left:10px;">
    <tr class="formtable">
     	<td class="formlabel">User ID :</td>
     	<td>${user.username}</td>
    </tr>
    <tr class="formtable">
     	<td class="formlabel">Name :</td>
     	<td>${user.name}</td>
     </tr>
     <tr class="formtable">
     	<td class="formlabel">Email :</td>
     	<td>${user.email}</td>
     </tr>
     <tr class="formtable">
     	<td class="formlabel">Phone :</td>
     	<td>${user.phone}</td>
     </tr>
     <tr class="formtable">
     	<td class="formlabel">Address :</td>
        <td>${user.address}</td>
     </tr>
    <tr class="formtable">
     	<td class="formlabel">Description :</td>
     	<td>${user.myself}</td>
     </tr>
     <tr class="formtable">
     	<td class="formlabel"></td>
     	<td><a href="${viewEmpPdf}/${user.username}">View in Pdf</a>&nbsp;&nbsp;<a href="${addReview}/${user.username}">Add Review</a> </td>
     </tr>
    </table>
	</div>
	</div>
</div>

</body>
	
	
</html>
