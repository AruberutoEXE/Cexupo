<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.84.0">
        <title>Perfil Usuario</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib prefix="s" uri="/struts-tags" %>
        <!-- Optional Bootstrap Theme -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <link href="https://fonts.googleapis.com/css?family=Playfair&#43;Display:700,900&amp;display=swap" rel="stylesheet">
        
        <link rel="icon" type="image/x-icon" href="/img/favicon.ico">
    </head>
    <body>

        
          <h1>User: <s:property value="%{#session.username}"></s:property></h1>
          <h2>Métodos de pago:</h2>
        <h2>Shipping Address:</h2>
          
          
          <table border="1">
              <tbody>
                  <tr>
                      <td>
                      <s:iterator>
                          <s:action name="GetDireccionesUser" namespace="/login" executeResult="true" />
                      </s:iterator>
                          
                      </td>
                  </tr>
                  <tr>
                      <td>
                          <s:i18n name="Actions.RegisterDirAction">
                
                <s:form action="signUp">
                    <s:textfield name="Address" label="direccion"/>
                    <s:textfield name="postal code" label="cp"/>
                    <s:password name="name address" label="nombre"/>
                   
                    <s:submit value="create shipping address"></s:submit>
                </s:form>
                <h2><s:property value="message"/></h2>
            </s:i18n>
                      </td>  
                  </tr>
              </tbody>
          </table>
          <h4>Eliminar cuenta</h4>
    </body>
</html>
