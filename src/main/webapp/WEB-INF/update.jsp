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

	<form action="/Alien Plot/update/${id}" method="POST" id="form2">
		<input type="text" name="cid" id="cid"
			value=<%=request.getAttribute("id")%> hidden>

		<h1>Aliens</h1>
		<table align="center">
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" id="name"
					value=<%=request.getAttribute("name")%> required></td>
			</tr>

			<tr>
				<td>Points:</td>
				<td><input type="text" name="point" id="point"
					value=<%=request.getAttribute("point")%> required /></td>
			</tr>
		</table>
		<br /> <input type="submit" value="Save" name="save" />
		<a href="/AlienPlot/"><input type="submit" value="Back" name="back" /></a>
	</form>
</body>
</html>