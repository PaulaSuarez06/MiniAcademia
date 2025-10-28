package es.daw.demo.controllers;


import es.daw.demo.model.Profesor;
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

@WebServlet("/profesores/ver")
public class ListarProfesores extends HttpServlet {

    private GenericDAO<Profesor, Integer> profesorDAO;

    public void init(ServletConfig config) throws ServletException{
        try {
            profesorDAO = new ProfesorDAO();
        } catch (SQLException e) {
            throw new ServletException("Error inicializando el DAO",e);
        }
        super.init(config);

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Profesor> profesores = new ArrayList<>();
        try {
            profesores = profesorDAO.findAll();
            request.setAttribute("profesores", profesores);
            getServletContext().getRequestDispatcher("/listaProfesores.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error al obtener los profesores",e);
        }


    }
}
