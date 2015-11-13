<%! int day = 3; %>
<!DOCTYPE html>
<html>
<head>
	<title>SWITCH...CASE Example</title>
</head>
<body>
<%
switch(day) {
case 0:
	out.println("It\'s Sunday.");
	break;
case 1:
	out.println("It\'s Monday.");
	break;
case 2:
	out.println("It\'s Tuesday.");
	break;
case 3:
	out.println("It\'s Wendesday.");
	break;
case 4:
	out.println("It\'s Thurday.");
	break;
case 5:
	out.println("It\'s Friday.");
	break;
default:
	out.println("It\'s Saturday.");
	break;
}
%>
</body>
</html>