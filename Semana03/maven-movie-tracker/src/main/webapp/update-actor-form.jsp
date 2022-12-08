<!DOCTYPE html>
<html>

<head>
	<title>Update Actor</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Actors Tracker</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Update Actor/Actress</h3>
		
		<form action="ActorControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="actorId" value="${THE_ACTOR.id}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><input type="text" name="firstName" 
								   value="${THE_ACTOR.firstName}" /></td>
					</tr>

					<tr>
						<td><label>Last Name:</label></td>
						<td><input type="text" name="lastName" 
								   value="${THE_ACTOR.lastName}" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><input type="text" name="email" 
								   value="${THE_ACTOR.email}" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="ActorControllerServlet">Return to main list</a>
		</p>
	</div>
</body>

</html>











