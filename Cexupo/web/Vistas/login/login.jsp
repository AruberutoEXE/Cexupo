<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de login</title>
    </head>
    <body>
        <s:form action="loginCheck" >
            <s:textfield name="username" label="User name"></s:textfield>
            <s:password name="password" label="Password"></s:password>
            <s:submit value="login"></s:submit>
        </s:form>
        <h2><s:property value="message"/></h2>
    </body>
</html>
