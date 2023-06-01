<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.84.0">
        <title>Cexupo </title>
       
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib prefix="s" uri="/struts-tags" %>
        <!-- Optional Bootstrap Theme -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <link href="https://fonts.googleapis.com/css?family=Playfair&#43;Display:700,900&amp;display=swap" rel="stylesheet">
        <s:head/>
        <link rel="icon" type="image/x-icon" href="/img/favicon.ico">
    </head>
    <body>
        <main role="main">
            <div class="album py-5 ">
                <div class="container">
                    <s:iterator value="direcciones">
                        <div class="card mb-4 box-shadow">
                           
                            <div class="card-body">
                                <p class="card-text">Shipping address: <s:property value = "direccion"/></p>
                                <p class="card-text">Postal code: <s:property value = "cp"/></p>
                                <p class="card-text">Name: <s:property value = "nombre"/></p>
                            </div>
                            <s:form method="POST" action="modificarDir">
                                <s:hidden name="id" value="%{id}" />
                                <s:submit cssClass="btn btn-sm btn-outline-secondary" value="Modify"/>
                            </s:form>
                            <s:form method="POST" action="Deletedir">
                                <s:hidden name="id" value="%{id}" />
                                <s:submit cssClass="btn btn-sm btn-outline-secondary" value="Delete"/>
                            </s:form>
                        </div>
                    </s:iterator>
                </div>
            </div>
        </main>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../assets/js/vendor/popper.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <script src="../../assets/js/vendor/holder.min.js"></script>
</body>
</html>
