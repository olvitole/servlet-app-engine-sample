<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="com.olvi.pmgt.model.NameModel"%>
<%@ page import="com.olvi.pmgt.entity.NameEntity"%>
<%@ page import="com.olvi.pmgt.dao.Dao"%>
<%@ page import="com.olvi.pmgt.dao.NameEntityDao"%>


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
		// Name Model
		Dao dao = Dao.INSTANCE;
		List<NameModel> nameModels = new ArrayList<NameModel>();
		nameModels = dao.listNameModels();

		// Name Entity
		NameEntityDao directDao = new NameEntityDao();
		List<NameEntity> nameEntities = new ArrayList<NameEntity>();
		nameEntities = directDao.listNameModels();
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
		<div class="headline">Servlet Request: New Name</div>
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
	<input type="button" value="Refresh Database Tables"
		onClick="window.location.reload()">
	<br>

	<div id='parent_div_1'>
		<div id="child_div1" style="clear: both;">
			<h3 class="headline">Name Model</h3>
			<p>
				You have a total number of
				<%=nameModels.size()%>
				Names.
			</p>
			<table>
				<tr>
					<th>IP</th>
					<th>Name</th>
				</tr>

				<%
					for (NameModel nameM : nameModels) {
				%>
				<tr>
					<td><%=nameM.getIp()%></td>
					<td><%=nameM.getName()%></td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
	</div>
	<div id='parent_div_2'>

		<div id="child_div_1" style="clear: both;">
			<h3 class="headline">Name Entity</h3>
			<p>
				You have a total number of
				<%=nameEntities.size()%>
				Names.
			</p>
			<table>
				<tr>
					<th>IP</th>
					<th>Name</th>
				</tr>

				<%
					for (NameEntity nameE : nameEntities) {
				%>
				<tr>
					<td><%=nameE.getIp()%></td>
					<td><%=nameE.getName()%></td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
	</div>
</body>
</html>