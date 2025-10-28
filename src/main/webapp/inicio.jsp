<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio de sesión</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: linear-gradient(135deg, #4A90E2, #007AFF);
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .login-card {
            background: #fff;
            padding: 2rem;
            border-radius: 1rem;
            box-shadow: 0 4px 10px rgba(0,0,0,0.15);
            width: 100%;
            max-width: 380px;
        }
        .login-card h3 {
            text-align: center;
            margin-bottom: 1.5rem;
        }
    </style>
</head>
<body>

<div class="login-card">
    <h3>Iniciar Sesión</h3>

    <!-- Mostrar mensaje de error si existe -->
    <%
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
    <div class="alert alert-danger text-center" role="alert">
        <%= error %>
    </div>
    <% } %>

    <!-- Formulario -->
    <form action="login" method="post">
        <div class="mb-3">
            <label for="email" class="form-label">Correo electrónico</label>
            <input type="email" class="form-control" id="email" name="email" required placeholder="usuario@instituto.es">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Contraseña</label>
            <input type="password" class="form-control" id="password" name="password" required placeholder="********">
        </div>
        <div class="d-grid">
            <button type="submit" class="btn btn-primary">Entrar</button>
        </div>
    </form>

</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
