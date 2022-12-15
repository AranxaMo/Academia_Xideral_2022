<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Movies</title>
	
	<!-- reference our style sheet -->
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>

<body>

	<div id="wrapper" style="background-color: #9DE3ED; color:#023047">
		<div id="header">
			<h2 class="text-center p-4 fw-bold">Movie Relationship Manager</h2>
		</div>
	</div>
		
	<div class="container my-5">
		<div id="content">
			
		<!-- put new button: Add Customer -->
			<input type="button" value="Add Movie"
			onclick="window.location.href='showFormForAdd'; return false;"
		     class="btn btn-outline-primary btn-lg"
			/>
		<!--  add our html table here -->
			<table class="table table-striped centrado mt-3 fs-6">
				<tr class="text-center">
					<th>Title</th>
					<th>Category</th>
					<th>Director</th>
					<th>Rating</th>
					<th>Action</th>
				</tr>
					
				<!-- loop over and print our customers -->
				<c:forEach var="tempMovie" items="${movies}">
					
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/mvc/showFormForUpdate">
						<c:param name="movieId" value="${tempMovie.id}" />
					</c:url>					
	
					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/mvc/delete">
						<c:param name="movieId" value="${tempMovie.id}" />
					</c:url>					
						
					<tr class="text-center">
						<td> ${tempMovie.movieTitle} </td>
						<td> ${tempMovie.movieCategory} </td>
						<td> ${tempMovie.movieDirector} </td>
						<td> ${tempMovie.movieRating} </td>
						<td>
						<!-- display the update link -->
							<a href="${updateLink}" class="btn btn-success">Update</a>
								|
							<a href="${deleteLink}" class="btn btn-danger"
								  onclick="if (!(confirm('Are you sure you want to delete this movie?'))) return false">Delete</a>
						</td>
							
					</tr>
					
				</c:forEach>
							
			</table>
					
		</div>
	</div>

</body>

</html>









