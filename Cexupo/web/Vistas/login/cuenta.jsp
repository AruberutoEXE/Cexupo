<%-- 
    Document   : cuenta
    Created on : 28-may-2023, 16:56:15
    Author     : agarc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cuenta datos usuario</title>
    </head>
    <body>
        <h1>Usuario: <s:property value="session['username']"></s:property></h1>
    </body>
</html>
