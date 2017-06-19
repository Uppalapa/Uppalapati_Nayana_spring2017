<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<spring:url value="/resources/css/mystyle.css" var="style" />
<link href="${style}" rel="stylesheet" />
</head>
<body>
	<div>
		<H1>JobFair.com</H1>
	</div>
	<div class="hd">
		<div class="mtitle">JobFair Registration</div>
		<div class="bd">
			<div>
				<form:form method="Post" action="registerSubmit"
					modelAttribute="user">

					<table style="padding-left: 10px;">
						<tr>
							<td class="formlabel">userId :</td>
							<td><div>
									<form:errors path="username" class="err" />
								</div> <form:input path="username" /></td>
						</tr>
						<tr>
							<td class="formlabel">pwd :</td>
							<td><div>
									<form:errors path="pwd" class="err" />
								</div> <form:password path="pwd" /></td>
						</tr>
						<tr>
							<td class="formlabel">name :</td>
							<td><div>
									<form:errors path="name" class="err" />
								</div> <form:input path="name" /></td>
						</tr>
						<tr>
							<td class="formlabel">email :</td>
							<td><div>
									<form:errors path="email" class="err" />
								</div> <form:input path="email" /></td>
						</tr>
						<tr>
							<td class="formlabel">Phone :</td>
							<td><div>
									<form:errors path="phone" class="err" />
								</div> <form:input path="phone" /></td>
						</tr>

						<tr>
							<td class="formlabel">address :</td>
							<td><div>
									<form:errors path="address" class="err" />
								</div> <form:textarea path="address" rows="5" cols="50" /></td>
						</tr>
						<tr>
							<td class="formlabel">Register As :</td>
							<td><div>
									<form:errors path="role" class="err" />
								</div> <form:select path="role">
									<form:options items="${model.roles}" />
								</form:select></td>
						</tr>
						<tr>
							<td class="formlabel">Describe Myself :</td>
							<td><div>
									<form:errors path="myself" class="err" />
								</div> <form:textarea path="myself" rows="5" cols="50" /></td>
						</tr>
						<tr>
							<td class="formlabel"></td>
							<td><input type="submit" value="submit" /></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
