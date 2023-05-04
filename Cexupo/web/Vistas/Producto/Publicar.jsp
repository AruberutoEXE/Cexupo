<%-- 
    Document   : Publicar
    Created on : 04-may-2023, 20:45:03
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Publica un producto</title>
    </head>
    <body>
        <h1>Publica un nuevo producto y ponlo en venta</h1>
    <s:form action="publicar">
        <s:textfield name="nombre" label="Nombre"></s:textfield>
        <s:textfield name="desc" label="Desc"></s:textfield>
        <s:textfield name="precio" label="Precio"></s:textfield>
        <s:textfield name="hashtag" label="Hashtag"></s:textfield>
        <s:submit name="publicar" value="Publicar"></s:submit>
    </s:form>
    </body>
</html>
