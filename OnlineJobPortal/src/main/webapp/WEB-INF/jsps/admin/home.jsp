<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<spring:url value="/resources/css/mystyle.css" var="style" />
<spring:url value="/admin/allEmps" var="allEmps" />
<spring:url value="/logout" var="logoutUrl" />
<link href="${style}" rel="stylesheet" />
<title>JobFair Admin Dashboard</title>
</head>
<body>
<div><H1>Welcome Admin!</H1></div>


<div class="hd">
<div class="mtitle">Admin Dashboard</div>
<div class="menu">
<a href="${allEmps}">List All Employers</a>&nbsp;|

<c:if test="${pageContext.request.userPrincipal.name != null}">
<a href="#" onclick="document.getElementById('logoutForm').submit();">Logout</a></c:if>
</div></div>
<div><form id="logoutForm" action="${logoutUrl}" method="post" name="logoutForm">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>	
		</div>
		
</body>
</html>