<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.84.0">
        <title>Cexupo</title>
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
                        <a class="link-secondary col-2" href="#" aria-label="Search">
                            <svg xmlns="http://www.w3.org/2000/svg" width="20"fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" role="img" viewBox="0 0 24 24"><title>Search</title><circle cx="10.5" cy="10.5" r="7.5"/><path d="M21 21l-5.2-5.2"/></svg>
                        </a>
                        <s:form method="POST" action="login">
                            <s:submit cssClass="btn btn-sm btn-outline-secondary" value="Sign up">Sign up</s:submit>
                        </s:form>

                    </div>

                </div>
            </header>

            <div class="nav-scroller py-1 mb-2 bg-secondary  rounded-pill p-3">
                <nav class="nav d-flex justify-content-between">
                    <a class="p-2 link-secondary text-white bg-dark rounded-pill" href="/Cexupo/index.jsp">Search</a>
                    <s:if test="%{#session.username!=null}">
                        <a class="p-2 link-secondary text-white bg-dark rounded-pill" href="/Cexupo/Vistas/Producto/PublicadosUsuario.jsp">Your Products</a>
                        <a class="p-2 link-secondary text-white bg-dark rounded-pill" href="#">Shipments</a>
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



            <div class="container">
                <div class="card mb-4 box-shadow">
                    <img class="card-img-top" src="img/Galeria/tahu.png" alt="Card image cap">
                    <div class="card-body">
                        <p class="card-text"><s:property value = "nombre"/></p>
                        <p class="card-text"><s:property value = "precio"/></p>
                        <p class="card-text"><s:property value = "descripcion "/></p>
                        <p class="card-text"><s:property value = "estado"/></p>
                        <p class="card-text"><s:property value = "hastag"/></p>
                        <p class="card-text"><s:property value = "id_usuario"/></p>
                        <p class="card-text"><s:property value = "direccion"  />
                        <p class="card-text"><s:property value = "transporte" />
                        <p class="card-text"><s:property value = "pago" />
                    </div>
                </div>
            </div>
            <s:if test="%{editable}">
                <div class="container">
                    <div class="card mb-4 box-shadow">
                        <s:form action="eliminarVenta">
                            <s:hidden  value="%{id}" name="id" />
                            <s:submit value="Cancelar compra"/>
                        </s:form>	
                    </div>
                </div>
                <div class="container">
                    <div class="card mb-4 box-shadow">
                        <s:form action="modificarVenta">
                            <s:select label="Direción"  list="direcciones" name="direccion"  listKey="dirid"/>
                            <s:select label="Transporte"list="transportes" name="transporte" listKey ="tranid"/>
                            <s:select label="Metodo de pago"list="pagos"   name="pago"  listKey="pagosid"/>
                            <s:hidden  value="%{idProducto}"               name="id" />
                            <s:submit value ="Actualizar" label="Actualizar"/>
                        </s:form>	
                    </div>
                </div>
            </s:if>    
            <s:else>        
                <p class="card-text">Tu pedido ya está en camino</p>
                <s:if test="%{hayReview}">
                    <p class="card-text"><s:property value = "estrellas"/></p>
                    <p class="card-text"><s:property value = "comentario"/></p>
                    <s:form action="eliminarReview">
                    <s:hidden  value="%{idVenta}" name="id" />
                    <s:submit value ="eliminar" label="eliminar"/>
                </s:form>
                </s:if> 
                <s:form action="dejarReview">
                    <s:textfield label="Puntuación" type="number" name="puntuacion" min="1" max="5" step="1"/>
                    <s:textfield name="comentario" label="Comentario"/>
                    <s:hidden  value="%{idVenta}" name="id" />
                    <s:submit value ="Actualizar" label="Actualizar"/>
                </s:form>

            </s:else>

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