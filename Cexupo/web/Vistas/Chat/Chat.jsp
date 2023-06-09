
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
        <div class="container">
            <header class="blog-header py-3">
                <div class="bg-dark rounded row flex-nowrap justify-content-between align-items-center">

                    <div class="col-4 text-center">
                        <h1 class="text-white">Cexupo</h1>

                    </div>
                    <div class="col-4 d-flex justify-content-end align-items-right">
                        <s:form action="listarChatsUser">
                            <s:submit cssClass="btn btn-sm btn-outline-secondary" value="Back to chats"></s:submit>
                        </s:form>
                    </div>                
                </div>
            </header>
            <main role="main">
            <section class="jumbotron text-center">
                <div class="container bg-dark p-3">
                    <h1 class="jumbotron-heading text-white"><s:property value="product.nombre"/></h1>
                </div>
            </section>

            <div class="album py-5 ">
                <div class="container">
                    <s:iterator value="mensajes">
                        <div class="card mb-4 box-shadow">
                            <div class="card-body">
                                <p class="card-text"><s:property value = "idUsuario"/></p>
                                <p class="card-text"><s:property value = "contenido"/></p>
                            </div>
                            <s:if test="%{#session.username==idUsuario}">
                            <s:form method="POST" action="editarM">
                                <s:hidden name="idMensaje" value="%{id}" />
                                <s:submit cssClass="btn btn-sm btn-outline-secondary" value="Edit"/>
                            </s:form>
                            <s:form method="POST" action="eliminarM">
                                <s:hidden name="idMensaje" value="%{id}" />
                                <s:submit cssClass="btn btn-sm btn-outline-secondary" value="Delete"/>
                            </s:form>
                            </s:if>
                        </div>
                    </s:iterator>
                </div>
            </div>
        </main>


        <footer class="blog-footer jumbotron text-center bg-dark">
            <br>
            <s:form method="POST" action="enviarM">
                <s:hidden name="producto" value="%{producto}" />
                <s:textfield size="145" name="contenidoMensaje"/>
                <s:submit cssClass="btn btn-sm btn-outline-secondary" value="Send"/>
            </s:form>
                <br>
    </footer>
        </div>          

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