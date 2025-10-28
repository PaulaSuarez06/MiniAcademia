package es.daw.demo.repository;

import es.daw.demo.model.Profesor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProfesorDAO implements GenericDAO<Profesor, Integer> {
    private Connection connection;

    public ProfesorDAO() throws SQLException{
        connection = DBConnection.getConnection();
    }


    @Override
    public void save(Profesor entity) throws SQLException {

        String SQL = "INSERT INTO profesor (nombre, apellido, email) VALUES (?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(SQL)){
            ps.setString(1, entity.getNombre());
            ps.setString(2, entity.getApellidos());
            ps.setString(3, entity.getEmail());
            ps.executeUpdate();
        }

    }

    @Override
    public Optional<Profesor> findById(Integer integer) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<Profesor> findAll() throws SQLException {
        List<Profesor> profesores = new ArrayList<>();
        String SQL = "SELECT * FROM profesor";
        try(PreparedStatement ps = connection.prepareStatement(SQL)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                profesores.add(new Profesor(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email")));
            }
            return profesores;
        }
    }

    @Override
    public void update(Profesor entity) throws SQLException {

    }

    @Override
    public void delete(Integer integer) throws SQLException {

    }
}
