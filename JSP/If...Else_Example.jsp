<%! int day = 3; %>
<!DOCTYPE html>
<html>
<head>
	<title>IF...ELSE Example</title>
</head>
<body>
<% if (day == 1 | day == 7) { %>
	<p> Today is weekend</p>
<% } else { %>
	<p> Today id not weekend</p>
<% } %>
</body>
</html>