<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Lista de Actores/Actrices</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Lista de Actores/Actrices</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Agregar Actor"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Correo</th>
					<th>Acción</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempActor" items="${actors}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/actor/showFormForUpdate">
						<c:param name="actorId" value="${tempActor.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/actor/delete">
						<c:param name="actorId" value="${tempActor.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempActor.firstName} </td>
						<td> ${tempActor.lastName} </td>
						<td> ${tempActor.email} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Actualizar</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this actor?'))) return false">Borrar</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









