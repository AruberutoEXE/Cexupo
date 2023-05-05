<%-- 
    Document   : UsuarioProductosVendidos
    Created on : 05-may-2023, 18:11:25
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tus productos vendidos</title>
    </head>
    <body>
        <h2>Estos son los productos que has vendido</h2>
         <s:iterator value="productosVendidos">
            <s:property value = "nombre"/>
            <s:property value = "precio"/>
            <s:form action="producto">
                <s:hidden name="id" value="%{id}" />
                <s:submit cssClass="btn btn-sm btn-outline-secondary" value="Detalles"/>
            </s:form>
        </s:iterator>
    </body>
</html>