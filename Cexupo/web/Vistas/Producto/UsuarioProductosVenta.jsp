<%-- 
    Document   : UsuarioProductosVenta
    Created on : 05-may-2023, 18:00:32
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cexupo</title>
    </head>
    <body>
        <h2>Products for sale</h2>
        <s:if test="%{productosPublicados!=null}">
        <s:iterator value="productosPublicados">
            <s:property value = "nombre"/>
            <s:property value = "precio"/>
            <s:form action="producto">
                <s:hidden name="id" value="%{id}" />
                <s:submit cssClass="btn btn-sm btn-outline-secondary" value="Details"/>
            </s:form>
        </s:iterator>
        </s:if>
        <s:else>
            <p>You are yet to publish a product for sale</p>
        </s:else>
    </body>
</html>
