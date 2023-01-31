<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
		<form action="PaisesServlet">
			Seleccione continente:
			<select name="continente">
				<%List<String> cont=(List<String>)request.getAttribute("continentes");
				for(String c:cont){%>
					<option value="<%=c%>"><%=c%></option>
				<%}%>
			
			</select>
			<br><br>
			<input type="submit" value="ver paises">
		
		
		</form>
	</center>

</body>
</html>