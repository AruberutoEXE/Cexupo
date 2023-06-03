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
        <s:head/>
    </head>
    <body>
        <div class="card mb-4 box-shadow">
                        <h2>New Shipping Address:</h2>
                        <s:i18n name="Actions.CreateDireccion">
                        <s:form action="publicarD" validate="true">
                            <s:textfield label="Address" name="direccion"/>
                            <s:textfield type="number" name="cp" label="Postal code"/>
                            <s:textfield label="name address" name="nombreD"/>
                            <s:submit name="crear" value="Create"></s:submit>
                        </s:form>
                        <h2><s:property value="message"/></h2>
                            </s:i18n>
                    </div>
    </body>
</html>
