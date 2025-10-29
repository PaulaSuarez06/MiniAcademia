package es.daw.demo.controllers;

import es.daw.demo.model.Asignatura;
import es.daw.demo.model.Profesor;
import es.daw.demo.repository.AsignaturaDAO;
import es.daw.demo.repository.GenericDAO;
import es.daw.demo.repository.ProfesorDAO;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@WebServlet("/profesores/buscar")
public class BuscarPorNombreServlet extends HttpServlet {

    GenericDAO<Profesor, Integer> profesorDAO;
    private ProfesorDAO profeDAO;

    public void init(ServletConfig config) throws ServletException {
        try {
            profesorDAO = new ProfesorDAO();
            profeDAO = new ProfesorDAO();
        } catch (SQLException e) {
            throw new ServletException("Error inicializando el DAO",e);
        }
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            String nombre = request.getParameter("nombre");
            Optional<Profesor> profesorOpt = profeDAO.findByNombre(nombre);

            List<Profesor> profesores = new ArrayList<>();
            if (profesorOpt.isPresent()) {
                profesores.add(profesorOpt.get());
            }

            // 🔹 Cargar las asignaturas igual que en el servlet principal
            AsignaturaDAO asignaturaDAO = new AsignaturaDAO();
            List<Asignatura> asignaturas = asignaturaDAO.findAll();

            request.setAttribute("profesores", profesores);
            request.setAttribute("asignaturas", asignaturas);

            // 👉 Forward al mismo JSP de listado
            request.getRequestDispatcher("/listaProfesores.jsp").forward(request, response);

        } catch (SQLException e) {
            throw new ServletException("Error al buscar profesor", e);
        }

    }


}
