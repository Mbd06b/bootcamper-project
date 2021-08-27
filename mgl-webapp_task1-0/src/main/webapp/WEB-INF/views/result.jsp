<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>

    <head>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>Mist Library Task 1- Synch</title>
        <style type="text/css">
            body {
            	background-image:
            		url('https://ak6.picdn.net/shutterstock/videos/1024598666/thumb/1.jpg');
            	background-repeat: no-repeat;
            	background-size: cover;
            }
        </style>
    </head>

    <body>
        <nav id="MistLibrary-navbar" class="navbar navbar-expand-md navbar-dark bg-dark">
            <a class="navbar-brand" href="${pageContext.request.contextPath}">
			<img src="resources/static/images/MGLlogo.png" width="90" height="60" alt="">
		</a>
            <a class="nav-item nav-link" href="games">Games</a>
            <a class="nav-item nav-link" href="review">Review</a>
        </nav>
        <br>
        <h2 class="text-light">Submitted Review Information</h2>
        <table class="table table-dark text-light">
            <tr>
                <td>ReviewBody</td>
                <td>
                    <p>${submittedReview.reviewBody}</p>
                </td>
            </tr>
            <tr>
                <td>Author</td>
                <td>
                    <p>${submittedReview.author}</p>
                </td>
            </tr>
            <tr>
                <td>Rating</td>
                <td>
                    <p>${submittedReview.rating}</p>
                </td>
            </tr>
        </table>
    </body>
    <script type="text/javascript"></script>

    </html>