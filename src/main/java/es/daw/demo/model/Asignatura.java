package es.daw.demo.model;

public class Asignatura {

    private Integer id;
    private String nombre;
    private String curso;
    private Integer id_profesor;


    public Asignatura() {
    }

    public Asignatura(String curso, String nombre, Integer id, Integer id_profesor) {
        this.curso = curso;
        this.nombre = nombre;
        this.id = id;
        this.id_profesor = id_profesor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(Integer id_profesor) {
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
