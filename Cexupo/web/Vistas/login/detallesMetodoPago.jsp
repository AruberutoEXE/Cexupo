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
          <%@page contentType="text/html"%>
   
        <!-- Optional Bootstrap Theme -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <link href="https://fonts.googleapis.com/css?family=Playfair&#43;Display:700,900&amp;display=swap" rel="stylesheet">
        <s:head/>
        <link rel="icon" type="image/x-icon" href="/img/favicon.ico">
    </head>
    <body>
    
            <div class="container">
                <div class="card mb-4 box-shadow">
                   
                    <div class="card-body">
                        <p class="card-text">Name: <s:property value = "nombre"/></p>
                         <p class="card-text">Details: <s:property value = "detalles"/></p>
                        
                    </div>
                </div>
            </div>
                    
                <div class="container">
                    <div class="card mb-4 box-shadow">
                        <s:form action="actualizarM">
                            <s:hidden  value="%{id}" name="id" />
                            <s:hidden  value="%{nombre}" name="nombre" />
                            <s:hidden  value="%{detalles}" name="detalles" />
                            
                            <s:submit value="Update"/>
                        </s:form>	
                    </div>
                </div>
          