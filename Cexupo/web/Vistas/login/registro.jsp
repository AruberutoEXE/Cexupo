<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- Optional Bootstrap Theme -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/css?family=Playfair&#43;Display:700,900&amp;display=swap" rel="stylesheet">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de registro</title>
        <link rel="icon" type="image/x-icon" href="/img/favicon.ico">
        <s:head/>
    </head>
    <body>
        <div style='margin: 0;
             position: absolute;
             top: 50%;
             left: 50%;
             -ms-transform: translate(-50%, -50%);
             transform: translate(-50%, -50%);'>
            <s:i18n name="Actions.RegisterUserAction">
                
                <s:form action="signUp">
                    <s:textfield name="username" label="username"/>
                    <s:textfield name="email" label="email"/>
                    <s:password name="password" label="password"/>
                   
                    <s:submit value="sign up"></s:submit>
                </s:form>
                <h2><s:property value="message"/></h2>
            </s:i18n>
                <p class="text-center">Already have an account?
                            <s:a href="/Cexupo/Vistas/login/login.jsp">Sign In!</s:a>
                        </p>
        </div>
        
    </body>
</html>