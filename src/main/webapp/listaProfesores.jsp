<%@ page import="es.daw.demo.model.Profesor" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Listado de Profesores</title>
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

<div class="container mt-5">
    <div class="card shadow-sm">
        <div class="card-header bg-primary text-white d-flex justify-content-between align-items-center">
            <h3 class="mb-0">Listado de Profesores</h3>
            <a href="<%=request.getContextPath()%>/profesores/crear"  class="btn btn-success btn-sm">
                <i class="bi bi-plus-lg"></i> Agregar Profesor
            </a>
        </div>

        <div class="card-body">
            <!-- 🔍 Formulario de filtrado -->
            <form action="/profesores/ver" method="get" class="row g-2 mb-3">
                <div class="col-md-6">
                    <input type="text" name="nombre" class="form-control" placeholder="Filtrar por nombre...">
                </div>
                <div class="col-md-2">
                    <button type="submit" class="btn btn-outline-primary w-100">
                        <i class="bi bi-search"></i> Buscar
                    </button>
                </div>
            </form>

            <table class="table table-hover align-middle">
                <thead class="table-light">
                <tr>
                    <th>Nombre</th>
                    <th>Apellidos</th>
                    <th>Email</th>
                    <th>Asignaturas</th>
                    <th class="text-center">Acciones</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Profesor> profesores = (List<Profesor>) request.getAttribute("profesores");
                    if (profesores != null && !profesores.isEmpty()) {
                        for (Profesor profesor : profesores) {
                %>
                <tr>
                    <td><%= profesor.getNombre() %></td>
                    <td><%= profesor.getApellidos() %></td>
                    <td><%= profesor.getEmail() %></td>
                    <td class="text-center">
                        <div class="d-flex justify-content-center gap-2">
                            <!-- Botón Editar -->
                            <form action="<%=request.getContextPath()%>/profesores/editar" method="get" class="d-inline">
                                <input type="hidden" name="id" value="<%= profesor.getId() %>">
                                <button type="submit" class="btn btn-warning btn-sm">
                                    <i class="bi bi-pencil-square"></i>
                                </button>
                            </form>

                            <!-- Botón Eliminar -->
                            <form action="<%=request.getContextPath()%>/profesores/borrar" method="post"
                                  onsubmit="return confirm('¿Seguro que deseas borrar este profesor?');"
                                  class="d-inline">
                                <input type="hidden" name="id" value="<%= profesor.getId() %>">
                                <button type="submit" class="btn btn-danger btn-sm">
                                    <i class="bi bi-trash"></i>
                                </button>
                            </form>
                        </div>
                    </td>
                </tr>
                <%
                    }
                } else {
                %>
                <tr>
                    <td colspan="4" class="text-center text-muted">No hay profesores registrados.</td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
