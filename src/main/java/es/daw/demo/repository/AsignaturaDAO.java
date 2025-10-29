package es.daw.demo.repository;

import es.daw.demo.model.Asignatura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AsignaturaDAO implements GenericDAO<Asignatura, Integer> {

    private Connection connection;

    public AsignaturaDAO() throws SQLException {
        connection = DBConnection.getConnection();
    }

    @Override
    public void save(Asignatura entity) throws SQLException {

    }

    @Override
    public Optional<Asignatura> findById(Integer integer) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<Asignatura> findAll() throws SQLException {
        List<Asignatura> asignaturas = new ArrayList<>();
        String SQL = "SELECT * FROM asignatura";
        try (PreparedStatement ps = connection.prepareStatement(SQL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                asignaturas.add(new Asignatura(
                        rs.getString("curso"),
                        rs.getString("nombre"),
                        rs.getInt("id"),
                        rs.getInt("id_profesor")));
            }
        }

        return asignaturas;

    }

    @Override
    public void update(Asignatura entity) throws SQLException {

    }

    @Override
    public void delete(Integer integer) throws SQLException {

    }
}
