package ar.charlycimino.tpm6e2;


public class TpM6E2 {
    public static void main(String[] args) {
        Universidad uni = new Universidad("UTN");

        Profesor p1 = new Profesor("P001", "Pepe Guevara", "Matemática");
        Profesor p2 = new Profesor("P002", "Carlos De La Cruz", "Programación");
        Profesor p3 = new Profesor("P003", "María Gómez", "Estadística");

        Curso c1 = new Curso("C101", "Álgebra");
        Curso c2 = new Curso("C102", "Java");
        Curso c3 = new Curso("C103", "Probabilidad");
        Curso c4 = new Curso("C104", "Base de Datos");
        Curso c5 = new Curso("C105", "Cálculo");

        uni.agregarProfesor(p1);
        uni.agregarProfesor(p2);
        uni.agregarProfesor(p3);
        uni.agregarCurso(c1);
        uni.agregarCurso(c2);
        uni.agregarCurso(c3);
        uni.agregarCurso(c4);
        uni.agregarCurso(c5);

        uni.asignarProfesorACurso("C101", "P001");
        uni.asignarProfesorACurso("C105", "P001");
        uni.asignarProfesorACurso("C102", "P002");
        uni.asignarProfesorACurso("C104", "P002");
        uni.asignarProfesorACurso("C103", "P003");

        System.out.println("\nista de cursos:");
        uni.listarCursos();

        System.out.println("\nLista de profesores:");
        uni.listarProfesores();

        System.out.println();
        p1.listarCursos();
        p2.listarCursos();
        p3.listarCursos();

        System.out.println("\nasignando curso C105 a otro profesor...");
        uni.asignarProfesorACurso("C105", "P003");

        System.out.println("\nEliminando curso C104...");
        uni.eliminarCurso("C104");

        System.out.println("\nEliminando profesor P002...");
        uni.eliminarProfesor("P002");

        uni.reporteCursosPorProfesor();

        System.out.println("\nCursos finales:");
        uni.listarCursos();
    }
}
