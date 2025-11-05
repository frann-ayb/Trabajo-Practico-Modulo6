
package ar.charlycimino.tpm6e2;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private String nombre;
    private List<Profesor> profesores;
    private List<Curso> cursos;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    public void agregarProfesor(Profesor p) {
        if (!profesores.contains(p)) profesores.add(p);
    }

    public void agregarCurso(Curso c) {
        if (!cursos.contains(c)) cursos.add(c);
    }

    public Profesor buscarProfesorPorId(String id) {
        for (Profesor p : profesores) {
            if (p.getId().equalsIgnoreCase(id)) return p;
        }
        return null;
    }

    public Curso buscarCursoPorCodigo(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equalsIgnoreCase(codigo)) return c;
        }
        return null;
    }

    public void asignarProfesorACurso(String codigoCurso, String idProfesor) {
        Curso curso = buscarCursoPorCodigo(codigoCurso);
        Profesor prof = buscarProfesorPorId(idProfesor);
        if (curso != null && prof != null) {
            curso.setProfesor(prof);
            System.out.println("Profesor " + prof.getNombre() + " asignado al curso " + curso.getNombre());
        } else {
            System.out.println("Curso o profesor no encontrados.");
        }
    }

    public void listarProfesores() {
        for (Profesor p : profesores) {
            p.mostrarInfo();
        }
    }

    public void listarCursos() {
        for (Curso c : cursos) {
            c.mostrarInfo();
        }
    }

    public void eliminarCurso(String codigo) {
        Curso c = buscarCursoPorCodigo(codigo);
        if (c != null) {
            if (c.getProfesor() != null) {
                c.setProfesor(null);
            }
            cursos.remove(c);
            System.out.println("Curso eliminado: " + c.getNombre());
        }
    }

    public void eliminarProfesor(String id) {
        Profesor p = buscarProfesorPorId(id);
        if (p != null) {
            for (Curso c : new ArrayList<>(p.getCursos())) {
                c.setProfesor(null);
            }
            profesores.remove(p);
            System.out.println("Profesor eliminado: " + p.getNombre());
        }
    }

    public void reporteCursosPorProfesor() {
        System.out.println("\nReporte de cursos por profesor:");
        for (Profesor p : profesores) {
            System.out.println(p.getNombre() + " dicta " + p.getCursos().size() + " curso/s.");
        }
    }
}

