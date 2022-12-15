<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Movie</title>
	<!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>

<body>
	<div id="wrapper" style="background-color: #9DE3ED; color:#023047">
		<div id="header">
			<h2 class="text-center p-4 fw-bold">Movie Relationship Manager</h2>
		</div>
	</div>

	<div class="container my-5 col-lg-4">
		<h3>Save Movie</h3>
	
		<form:form action="saveMovie" modelAttribute="movie" method="POST" class="form">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					<div class="mb-3">
                        <label for="title" class="form-label">Title:</label>
                        <form:input path="movieTitle" class="form-control" id="title"/>
                    </div>
					<div class="mb-3">
                        <label for="category" class="form-label">Category:</label>
                        <form:input path="movieCategory" class="form-control" id="category"/>
                    </div>
					<div class="mb-3">
                        <label for="director" class="form-label">Director:</label>
                        <form:input path="movieDirector" class="form-control" id="director"/>
                    </div>
                    <div class="mb-3">
                        <label for="rating" class="form-label">Rating:</label>
                        <form:input path="movieRating" class="form-control" id="rating"/>
                    </div>
					<div class="mb-3 text-center">
                        <label class="form-label"></label>
                        <input type="submit" value="Save" class="btn btn-primary btn-lg col-lg-4" />
                    </div>
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/mvc/movies" class="btn btn-link btn-lg">Back to List</a>
		</p>
	
	</div>

</body>

</html>










