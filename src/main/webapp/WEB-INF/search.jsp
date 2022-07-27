<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="demoRest.Alien"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alien Plot</title>
</head>
<body>

	<form method="GET" id="form3">
		<br />
		<table class="t1" align="center">
			<thead>
				<tr class="table-header">
					<th class="column">id
					</td>
					<th class="column">Name
					</td>
					<th class="column">points
					</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${aliens}" var="alien">
					<tr>
						<td class="column">${alien.id}</td>
						<td class="column">${alien.name}</td>
						<td class="column">${alien.points}</td>
						<td class="column"><a
							href="/AlienPlot/getAlien/${alien.id}">Edit</a> <a
							href="/AlienPlot/delete/${alien.id}">delete</a></td>
					</tr>

				</c:forEach>
				</tr>
			</tbody>
		</table>
	</form>
	<a href="/AlienPlot/"><p style="text-align:center"><input type="submit" value="Back" name="back" /></a>
</body>
</html>