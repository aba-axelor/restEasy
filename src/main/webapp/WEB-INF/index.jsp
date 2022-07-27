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
<body align="center">
	
	<form action="/Alien Plot/insert" method="POST" id="form2" >

		<h1>Aliens</h1>
		<table align="center">
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" id="name"
					value="${alien.name}" required></td>
			</tr>

			<tr>
				<td>Points:</td>
				<td><input type="text" name="points" id="points"
					value="${alien.points}" minlength="10" required /></td>
			</tr>
		</table>
		<br /> <input type="submit" value="Add Alien" name="save" />
	</form>
	<br />
	<br />

	<form action="/AlienPlot/search" method="GET" id="form4">
		Name: <input type="text" name="name" id="name" required> <input
			type="submit" value="Search" />
	</form>
	<br />
	<form method="GET" id="form3">
		<br />
		<table class="t1" align="center">
			<thead>
				<tr class="table-header">
					<th class="column">id</td>
					<th class="column">Name</td>
					<th class="column">phone No</td>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${aliens}" var="alien">
					<tr>
						<td class="column" >${alien.id}</td>
						<td class="column" >${alien.name}</td>
						<td class="column" >${alien.points}</td>
						<td class="column" ><a
							href="/AlienPlot/updateAlien/${alien.id}">Edit</a> <a
							href="/Alienplot/delete/${alien.id}">delete</a></td>
					</tr>

				</c:forEach>
				</tr>
			</tbody>
		</table>

	</form>
	<br />
	<br />

</body>
</html>
