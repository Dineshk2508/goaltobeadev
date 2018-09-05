<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/footable.standalone.css"
    rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/js/footable.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/footable.filtering.js"></script>
</head>
<body>
 <input type="text" id="filter"><br><br>
        <!-- data-filter : # + the id of the input text -->
        <!-- data-filter-minimum : the minimum number of characters to search -->
        
<form action="update" method="post">
<input type="submit" value="update" name ="action"/>
	<table class="footable" data-filter="#filter" data-filter-minimum="3">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>email</th>
		</tr>
		<c:forEach items="${users}" var="user" varStatus="us">
			<tr>
				<td><form:checkbox path="users[${us.index}].id" value="${user.id}"/><input type="checkbox" name="id" value="${user.id}"/></td>
				<td><form:input type="hidden" path="users[${us.index}].name"/><input type="text" value="${user.name}" id="name" name="name"/></td>
				<td><form:input type="hidden" path="users[${us.index}].email"/><input type="text" value="${user.email}" id="email" name="email"/></td>
			</tr>
		</c:forEach>
	</table>
	</form>
</body>
<script type="text/javascript">
    
       $(document).ready(function(){
           
           $('.footable').footable();
           
       });
    
    </script>
</html>