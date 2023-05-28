<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcomee <s:property value="%{#session.username}"></s:property></title>
    </head>
    <body>
       <s:action name="productos" namespace="/producto" executeResult="true" /> 
    </body>
</html>
