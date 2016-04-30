<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>Sistema de gestión de TFGs</p>
    <c:if test="${user != null}">
        <c:out value="${user}" />
    </c:if>
<p>Puedes pulsar el siguiente enlace para salir
<a href="<c:url value="${url}"/>"><c:out value="${urlLinktext}"/></a></p>

<c:forEach items="${tfgs}" var="tfg">
        <tr>
            <td><c:out value="${tfg.autor}" /></td>
            <td><c:out value="${tfg.titulo}" /></td>
            <td><c:out value="${tfg.resumen}" /></td>
            <td><c:out value="${tfg.tutor}" /></td>
            <td><c:out value="${tfg.estado}" /></td>
        </tr>
    </c:forEach>

<c:if test="${not empty user and empty tfg and empty tfgs}">
Alumno: esta es una solicitud de TFG
	<form action="/nuevoTFG" method="post" acceptcharset="utf-8">
			<input type="text" name="titulo" id="titulo" maxLength="255"
				size="20" required placeholder="Titulo" />
			<input type="text"
				name="resumen" id="resumen" maxLength="255" required size="20"
				placeholder="resumen" />
			<input type="text" name="tutor" id="tutor"
				maxLength="255" required size="20" placeholder="tutor" />
			<input type="submit" value="Solicitud" />
		</form>
	</c:if>



</body>

</html>