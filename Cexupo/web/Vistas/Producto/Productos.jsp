<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
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
                        
                        <s:a cssClass="btn btn-sm btn-outline-secondary" href="/Cexupo/Vistas/login/registro.jsp">Sign up</s:a>
                      

                    </div>

                </div>
            </header>

            <div class="nav-scroller py-1 mb-2 bg-secondary  rounded-pill p-3">
                <nav class="nav d-flex justify-content-between">
                    <a class="p-2 link-secondary text-white bg-dark rounded-pill" href="/Cexupo/index.jsp">Search</a>
                    <s:if test="%{#session.username!=null}">
                    <a class="p-2 link-secondary text-white bg-dark rounded-pill" href="/Cexupo/Vistas/Producto/PublicadosUsuario.jsp">Your Products</a>
                    <div class="p-2 link-secondary text-white bg-dark rounded-pill" ><s:a action="ventas">Shipments</s:a></div>
                    
                    <a class="p-2 link-secondary text-white bg-dark rounded-pill" href="/Cexupo/Vistas/login/cuenta.jsp">Account</a>
                    </s:if>
                    <s:else>
                    <a class="p-2 link-secondary text-white bg-dark rounded-pill" href="/Cexupo/Vistas/login/login.jsp">Your Products</a>
                    <a class="p-2 link-secondary text-white bg-dark rounded-pill" href="/Cexupo/Vistas/login/login.jsp">Shipments</a>
                    <a class="p-2 link-secondary text-white bg-dark rounded-pill" href="/Cexupo/Vistas/login/login.jsp">Account</a>
                    </s:else>
                </nav>
                
                
            </div>
        </div>


        <main role="main">

            <section class="jumbotron text-center">
                <div class="container bg-dark p-3">
                    <h1 class="jumbotron-heading text-white">find what you're looking for</h1>
                    <p class="lead text-secondary">If someone sell it, we have it</p>

                </div>
            </section>

            <div class="album py-5 ">
                <div class="container">
                    <s:iterator value="productos">
                        <div class="card mb-4 box-shadow">
                            <!--<img class="card-img-top" src="img/Galeria/tahu.png" alt="Card image cap">-->
                            <div class="card-body">
                                <p class="card-text"><s:property value = "nombre"/></p>
                                <p class="card-text"><s:property value = "precio"/></p>
                            </div>
                            <s:form method="POST" action="producto">
                                <s:hidden name="id" value="%{id}" />
                                <s:submit cssClass="btn btn-sm btn-outline-secondary" value="Details"/>
                            </s:form>
                        </div>
                    </s:iterator>
                </div>
            </div>
        </main>


        <footer class="blog-footer jumbotron text-center bg-dark">
            <p>
            <h2><a class=" bg-sand" href="#">Back to top</a></h2>
        </p>
    </footer>

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