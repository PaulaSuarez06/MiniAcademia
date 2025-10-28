<%@ page import="es.daw.demo.model.Profesor" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
    >
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css"
            rel="stylesheet"
    >
</head>
<body class="bg-light">

<%
    Profesor profesor = (Profesor) request.getAttribute("profesores");
    boolean esEdicion = profesor != null;

    String titulo = esEdicion ? "Modificar Profesor" : "Crear Profesor";
    String accion = esEdicion ? "/profesores/editar" : "/profesores/crear";
%>


<div class="container mt-5">
    <div class="card shadow-sm">
        <div class="card-header bg-warning text-dark d-flex justify-content-between align-items-center">
            <h3 class="mb-0"><i class="bi bi-pencil-square"></i> <%=titulo%>></h3>
            <a href="/profesores/ver" class="btn btn-outline-secondary btn-sm">
                <i class="bi bi-arrow-left"></i> Volver al listado
            </a>
        </div>

        <div class="card-body">
            <form action=<%=accion%>> method="post" class="needs-validation" novalidate>
                <!-- Campo oculto para el ID -->
                <input type="hidden" name="id" value="">

                <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre</label>
                    <input type="text"
                           class="form-control"
                           id="nombre"
                           name="nombre"
                           placeholder="Introduce el nombre"
                           required>
                </div>

                <div class="mb-3">
                    <label for="apellidos" class="form-label">Apellidos</label>
                    <input type="text"
                           class="form-control"
                           id="apellidos"
                           name="apellidos"
                           placeholder="Introduce los apellidos"
                           required>
                </div>

                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email"
                           class="form-control"
                           id="email"
                           name="email"
                           placeholder="Introduce el correo electrónico"
                           required>
                </div>

                <div class="d-flex justify-content-between mt-4">
                    <button type="submit" class="btn btn-primary">
                        <i class="bi bi-save"></i> Guardar Cambios
                    </button>
                    <button type="reset" class="btn btn-outline-secondary">
                        <i class="bi bi-arrow-clockwise"></i> Restablecer
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
