package es.daw.demo.controllers;


import es.daw.demo.model.Asignatura;
import es.daw.demo.model.Profesor;
import es.daw.demo.repository.AsignaturaDAO;
import es.daw.demo.repository.GenericDAO;
import es.daw.demo.repository.ProfesorDAO;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/profesores/ver")
public class ListarProfesores extends HttpServlet {

    private GenericDAO<Profesor, Integer> profesorDAO;
    private GenericDAO<Asignatura, Integer> asignaturaDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            profesorDAO = new ProfesorDAO();
            asignaturaDAO = new AsignaturaDAO();
        } catch (SQLException e) {
            throw new ServletException("Error inicializando el DAO", e);
        }
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // --- Gestión de la cookie ---
        int visitas = 0;
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("visitasProfesores".equals(c.getName())) {
                    visitas = Integer.parseInt(c.getValue());
                }
            }
        }

        visitas++;
        Cookie cookie = new Cookie("visitasProfesores", String.valueOf(visitas));
        cookie.setMaxAge(60 * 60 * 24 * 7); // 7 días
        cookie.setPath(request.getContextPath());
        response.addCookie(cookie);

        request.setAttribute("visitas", visitas);

        // --- Carga de datos desde la base de datos ---
        try {
            List<Profesor> profesores = profesorDAO.findAll();
            List<Asignatura> asignaturas = asignaturaDAO.findAll();

            request.setAttribute("profesores", profesores);
            request.setAttribute("asignaturas", asignaturas);

            // --- Forward al JSP ---
            getServletContext()
                    .getRequestDispatcher("/listaProfesores.jsp")
                    .forward(request, response);

        } catch (SQLException e) {
            throw new ServletException("Error al obtener los profesores", e);
        }
    }
}
