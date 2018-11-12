<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.suam.bean.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Compra Não Realizada</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />
	<br>
	<br>
	<h3>O assento ${assentoJaComprado} já foi comprado!</h3> 
</body>
</html>



