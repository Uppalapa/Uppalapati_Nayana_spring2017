<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
	<spring:url value="/resources/css/mystyle.css" var="style" />
	<spring:url value="/logout" var="logoutUrl" />
	<spring:url value="/admin/allEmps" var="allEmps" />
	<spring:url value="/admin/updateEmp" var="updateEmp" />
	<link href="${style}" rel="stylesheet" />
	
	</head>
<body>
<div><H1>Activate/Deactivate Employees</H1></div>

<div class="hd">
<div class="mtitle">Admin Dashboard</div>
<div class="menu">
<a href="${allEmps}">List All Employers</a>&nbsp;|

<c:if test="${pageContext.request.userPrincipal.name != null}">
<a href="#" onclick="document.getElementById('logoutForm').submit();">Logout</a></c:if>
</div>
</div>
<div><form id="logoutForm" action="${logoutUrl}" method="post" name="logoutForm">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>	
</div>

<div class="hd">
<div class="mtitle">Activate / Deactivate Employer</div>
<div class="bd">
			<div>
	<form:form method="Post" action="${updateEmp}" modelAttribute="user">
	<table style="padding-left:10px;">
     <tr class="formtable">
     	<td class="formlabel">User ID :</td>
     	<td >${user.username}</td>
    </tr>
     <tr class="formtable">
     	<td class="formlabel">Employer Name :</td>
     	<td>${user.name}</td>
     </tr>
     <tr class="formtable">
     	<td class="formlabel">Employer Email :</td>
     	<td>${user.email}</td>
     </tr>
      <tr class="formtable">
     	<td class="formlabel">Phone Number:</td>
     	<td>${user.phone}</td>
     </tr>
     <tr class="formtable">
     	<td class="formlabel">Address :</td>
        <td>${user.address}</td>
     </tr>
     <tr class="formtable">
     	<td class="formlabel">About Employer :</td>
     	<td>${user.myself}</td>
     </tr>
    <tr class="formtable">
     	<td class="formlabel">Status :</td>
     	<td>
     	<form:select path="status">
     	    <form:option value="ACTIVE">ACTIVE</form:option>
     	     <form:option value="INACTIVE">INACTIVE</form:option>
     	</form:select></td>
     </tr>
     <tr class="formtable">
     	<td class="formlabel">   
     	<form:hidden path="userid"/></td>
     	<td><input type="submit"  value="Update"/></td>
     </tr>
     </table>
     </form:form>
	</div>
		</div>
</div>
</body>
	
	
</html>
