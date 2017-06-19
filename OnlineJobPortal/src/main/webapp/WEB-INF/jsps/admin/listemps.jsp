<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<spring:url value="/resources/css/mystyle.css" var="style" />
<spring:url value="/logout" var="logoutUrl" />
<spring:url value="/admin/allEmps" var="allEmps" />
<spring:url value="/admin/viewEmp" var="viewEmp" />
<link href="${style}" rel="stylesheet" />
</head>
<body>
<div><H1>Here are the list of Employees</H1></div>

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
<div class="mtitle">Admin > List of All Employers</div>
<div class="bd">
			<table cellspacing="0">
				<tr class="tablehd">
				<td  >Emp Id</td>
				<td >User Name</td>
				<td >Employer Name</td>
				<td >Email</td>
				<td >Phone Number</td>
				<td >Status</td>
				<td></td>
			</tr>

				<c:forEach var="user" items="${users}">
					<tr class="tablebd">
						<td>${user.userid}</td>
						<td><a href="${viewEmp}/${user.username}">${user.username}</a></td>
						<td>${user.name}</td>
						<td>${user.email}</td>
						<td>${user.phone}</td>
						<td>${user.status}</td>
					</tr>
				</c:forEach>

			</table>
		</div>
</div>
</body>
</html>
