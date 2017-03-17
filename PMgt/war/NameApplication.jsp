<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="com.olvi.pmgt.model.NameModel"%>
<%@ page import="com.olvi.pmgt.dao.Dao"%>

<!DOCTYPE html>


<%@page import="java.util.ArrayList"%>

<html>
<head>
<title>Name Storage</title>
<script src="http://code.jquery.com/jquery-3.2.0.js"
	type="text/javascript"></script>
<script src="js/app-ajax.js" type="text/javascript"></script>

<link rel="stylesheet" type="text/css" href="css/main.css" />
<meta charset="utf-8">
</head>
<body>
	<%
		Dao dao = Dao.INSTANCE;
		List<NameModel> nameModels = new ArrayList<NameModel>();
		nameModels = dao.getNameModels();
	%>
	<div style="width: 100%;">
		<div class="line"></div>
		<div class="topLine">
			<div style="float: left;">
				<img height="20" src="images/name.jpeg" />
			</div>
			<div style="float: left;" class="headline">Names App</div>
		</div>
	</div>
	<br>
	<br>
	<div class="main">
		<div class="headline">Servlet Request: New Name </div>
		<form accept-charset="utf-8">
			<table>
				<tr>
					<td><label for="name">Name</label></td>
					<td><input type="text" name="name" id="name" size="65" /></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input id="submitName"
						type="button" value="Create" /></td>
				</tr>
			</table>
		</form>
	</div>

	<br>
	<div class="headline">JSON response parsing:</div>
	<br>
	<div id="ajaxGetUserServletResponse">Hello:</div>
	<br>
	<br>

	<input type="button" value="Refresh From Database" onClick="window.location.reload()">

	<div style="clear: both;">
		You have a total number of
		<%=nameModels.size()%>
		Names.
		<table>
			<tr>
				<th>IP</th>
				<th>Name</th>
			</tr>

			<%
				for (NameModel todo : nameModels) {
			%>
			<tr>
				<td><%=todo.getIp()%></td>
				<td><%=todo.getName()%></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>