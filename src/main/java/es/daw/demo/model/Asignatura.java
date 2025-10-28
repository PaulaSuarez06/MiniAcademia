package es.daw.demo.model;

public class Asignatura {

    private int id;
    private String nombre;
    private String curso;
    private int id_profesor;


    public Asignatura() {
    }

    public Asignatura(String curso, String nombre, int id, int id_profesor) {
        this.curso = curso;
        this.nombre = nombre;
        this.id = id;
        this.id_profesor = id_profesor;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", curso='" + curso + '\'' +
                ", id_profesor=" + id_profesor +
                '}';
    }
}
