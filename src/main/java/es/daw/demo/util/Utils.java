package es.daw.demo.util;

import es.daw.demo.model.Asignatura;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {


//    public static void obtenerNombreAsignatura(List<Asignatura> asignaturas, Integer id) {
//        asignaturas.stream()
//                .filter(a -> a.getId() == id.intValue()) // Compara el valor entero
//                .map(Asignatura::getNombre)
//                .forEach(System.out::println);
//    }

//    public static List<Asignatura> obtenerNombreAsignatura(List<Asignatura> asignaturas, Integer id) {
//        return asignaturas.stream()
//                .filter(a -> a.getId().equals(id)) // Compara el valor entero
//                .sorted((p1, p2) -> p2.getNombre().compareToIgnoreCase(p1.getNombre())) // DESC
//                .toList();
//    }

    public static String obtenerNombreAsignatura(List<Asignatura> asignaturas, Integer id) {
        return asignaturas.stream()
                .filter(a -> a.getId().equals(id)) // Compara el valor entero
                .map(Asignatura::getNombre)
                .findFirst()
                .orElse("Asignatura no encontrada");
    }

    public static List<Asignatura> obtenerAsignaturasPorCurso(List<Asignatura> asignaturas, String curso) {
        return asignaturas.stream()
                .filter(a -> a.getCurso().equalsIgnoreCase(curso))
                .collect(Collectors.toList());
    }

    public static List<Asignatura> obtenerAsignaturasPorProfesor(List<Asignatura> asignaturas, Integer idProfesor) {
        return asignaturas.stream()
                .filter(a -> a.getId_profesor().equals(idProfesor))
                .collect(Collectors.toList());
    }

    public static List<String> obtenerNombresAsignaturasPorProfesor(List<Asignatura> asignaturas, Integer idProfesor) {
        return asignaturas.stream()
                .filter(a -> a.getId_profesor().equals(idProfesor))
                .map(Asignatura::getNombre)
                .collect(Collectors.toList());
    }
}
