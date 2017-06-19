<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
      
      <spring:url value="/resources/css/mystyle.css" var="style" />
      
   	<spring:url value="/login" var="login" />
      
    <head>
    <link href="${style}" rel="stylesheet" />
	
        <title>Online JobFair Login</title>
    </head>
    <body>
    <div><H1>JobFair.com</H1></div>
<div class="hd">
<div class="mtitle">JobFair Login</div>
<div class="bd">
			<div>
	

	 <c:if test="${not empty error}"><div class="err">${error}</div></c:if>
	<c:if test="${not empty message}"><div >${message}</div><br/></c:if>

	<form name='login' action="${login}" method='POST'>
		<table>
			<tr>
				<td class="formlabel">UserName:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td class="formlabel">Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td class="formlabel"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /></td>
				<td><input name="submit" type="submit" value="submit" /></td>
			</tr>
			
		</table>
		
	</form>
	
</div>
		</div>
</div>		
</body>	
    
</html>