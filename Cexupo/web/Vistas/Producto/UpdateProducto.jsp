<%-- 
    Document   : UpdateProducto
    Created on : 18-may-2023, 20:39:50
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Actualice la información del producto</h1>
    <s:form action="updateP">
        <s:hidden  value="%{id}" name="id" />
        <s:textfield name="nombre" label="Nombre"></s:textfield>
        <s:textfield name="descripcion" label="Descripción"></s:textfield>
        <s:textfield name="precio" label="Precio"></s:textfield>
        <s:textfield name="estado" label="Estado"></s:textfield>
        <s:textfield name="hastag" label="Hashtag"></s:textfield>
        <s:submit name="update" value="Actualizar"></s:submit>
    </s:form>
    </body>
</html>
