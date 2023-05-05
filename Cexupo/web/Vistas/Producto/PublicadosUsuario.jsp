<%-- 
    Document   : PublicadosUsuario
    Created on : 05-may-2023, 18:06:40
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
        <h1>Estos son los productos que has publicado</h1>
        <s:action name="listPubliUser" namespace="/producto" executeResult="true" />
        <s:action name="listVendidosUser" namespace="/producto" executeResult="true" />
    </body>
</html>
