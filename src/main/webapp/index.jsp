<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página de inicio</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #f7f9fc;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
        }

        header {
            background: linear-gradient(135deg, #007bff, #0056b3);
            color: #fff;
            padding: 1rem 0;
        }

        .navbar-brand {
            font-weight: 600;
            letter-spacing: 0.5px;
        }

        main {
            flex: 1;
            display: flex;
            align-items: center;
            justify-content: center;
            flex-direction: column;
            text-align: center;
            padding: 2rem;
        }

        footer {
            background-color: #e9ecef;
            text-align: center;
            padding: 1rem;
            font-size: 0.9rem;
        }
    </style>
</head>
<body>



<main>
    <div class="container">
        <h1 class="mb-3">¡Bienvenido!</h1>
        <p class="lead">Has iniciado sesión correctamente.</p>
        <p class="text-muted">Aquí podrás acceder a tus asignaturas, profesores y mucho más.</p>

        <div class="mt-4">
            <a href="<%= request.getContextPath()%>/asignaturas/ver" class="btn btn-primary me-2">Ver asignaturas</a>
            <a href="<%= request.getContextPath()%>/profesores/ver" class="btn btn-secondary">Ver profesores</a>
        </div>
    </div>
</main>

<footer>
    <div class="container">
        &copy; Práctica JakartaEE - Paula Suárez
    </div>
</footer>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
