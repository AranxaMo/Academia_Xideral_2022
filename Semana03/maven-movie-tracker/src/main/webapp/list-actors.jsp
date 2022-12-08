<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Actor Tracker</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Actor Tracker</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Student -->
			
			<input type="button" value="Add Actor" 
				   onclick="window.location.href='add-actors-form.html'; return false;"
				   class="add-student-button"
			/>
			
			<table>
			
				<tr>
					<th>Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempActor" items="${LISTA_ACTORES}">
					
					<!-- set up a link for each student -->
					<c:url var="tempLink" value="ActorControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="actorId" value="${tempActor.id}" />
					</c:url>

					<!--  set up a link to delete a student -->
					<c:url var="deleteLink" value="ActorControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="actorId" value="${tempActor.id}" />
					</c:url>
																		
					<tr>
						<td> ${tempActor.firstName} </td>
						<td> ${tempActor.lastName} </td>
						<td> ${tempActor.email} </td>
						<td> 
							<a href="${tempLink}">Update</a> 
							 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">
							Delete</a>	
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
	<script type="text/javascript">
		var str = window.location.href;
		var separado = str.split('?');
		if(separado.length > 1) {
			var result = str.replace(str.split('ActorControllerServlet').pop(),'');
			location.replace(result);
		}
	</script>
</body>


</html>








