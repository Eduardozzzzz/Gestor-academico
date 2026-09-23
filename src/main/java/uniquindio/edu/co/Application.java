package uniquindio.edu.co;

import java.time.LocalDate;
import java.util.Scanner;

public class Application {
    static void main(){
        Scanner sc = new Scanner(System.in);
        Universidad uq = new Universidad("Universidad del quindio", "Norte", "Armenia", 530942034);
        int opcion;
        do{
            System.out.println("================Universidad menu================");
            System.out.println("1. Agregar estudiantes.");
            System.out.println("2. Mostrar estudiantes.");
            System.out.println("3. Agregar cursos.");
            System.out.println("4. Mostrar cursos. ");
            System.out.println("5. Agregar profesores. ");
            System.out.println("6. Mostrar profesores. ");
            System.out.println("================Profesores menu================");
            System.out.println("7. Asignar curso. ");
            System.out.println("8. Mostrar lista de cursos. ");
            System.out.println("================Cursos menu================");
            System.out.println("9. Matricular estudiante. ");
            System.out.println("10. Mostrar lista de estudiantes en el curso. ");
            System.out.println("================================================");
            System.out.println("0. Salir del programa. ");
            System.out.println("================================================");
            System.out.println(" Ingrese el numero de la opcion correspondiente.");
            System.out.println("================================================");
            opcion=sc.nextInt();
            switch (opcion){
                case 0:
                    System.out.println("Cerrando el programa.");
                    break;
                case 1:
                    System.out.println("Vamos a ingresar un estudiante, ingrese la informacion correspondiente.");
                    System.out.print("Nombre: ");
                    String nombre = sc.next();
                    System.out.print("Documento: ");
                    int documento = sc.nextInt();
                    System.out.print("Fecha de nacimiento: ");
                    System.out.print("Ano: ");
                    int ano = sc.nextInt();
                    System.out.print("Mes: ");
                    int mes = sc.nextInt();
                    System.out.print("Dia: ");
                    int dia = sc.nextInt();
                    Estudiante estudiante = new Estudiante(nombre,documento,LocalDate.of(ano,mes,dia));
                    if(uq.agregarEstudiante(estudiante)){
                        System.out.println("Estudiante anadido.");
                    }else{
                        System.out.println("El estudiante ya esta registrado.");
                    }
                    break;
                case 2:
                    System.out.println("Los " + uq.getListaEstudiantes().size() + " estudiantes que hay matriculados directamente en la universidad actualmente son: ");
                    System.out.println(uq.getListaEstudiantes());
                    break;
                case 3:
                    System.out.println("Vamos a crear un curso, ingrese la informacion correspondiente.");
                    System.out.print("Titulo del curso: ");
                    String titulo = sc.next();
                    System.out.print("Horario: ");
                    String horario = sc.next();
                    System.out.print("Codigo: ");
                    int codigo = sc.nextInt();
                    System.out.print("Modalidad: ");
                    String entrada = sc.next().toUpperCase();
                    Modalidad modalidad = Modalidad.valueOf(entrada);
                    Curso curso = new Curso(titulo,horario,codigo,modalidad);
                    if(uq.agregarCurso(curso)){
                        System.out.println("Curso creado.");
                    }else{
                        System.out.println("El curso ya esta registrado.");
                    }
                    break;
                case 4:
                    System.out.println("Los " + uq.getListaCursos().size() + " cursos que se dan en la universidad actualmente son: ");
                    System.out.println(uq.getListaCursos());
                    break;
                case 5:
                    System.out.println("Vamos a ingresar un profesor, ingrese la informacion correspondiente.");
                    System.out.print("Nombre: ");
                    String nombre1 = sc.next();
                    System.out.print("Documento: ");
                    int documento1 = sc.nextInt();
                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    System.out.print("Salario: ");
                    double salario = sc.nextDouble();
                    Profesor profesor = new Profesor(nombre1,documento1,edad,salario);
                    if(uq.agregarProfesor(profesor)){
                        System.out.println("Profesor anadido.");
                    }else{
                        System.out.println("El profesor ya esta registrado.");
                    }
                    break;
                case 6:
                    System.out.println("Los " + uq.getListaProfesores().size() + " profesores que ensenan en la universidad actualmente son: ");
                    System.out.println(uq.getListaProfesores());
                    break;
                case 7:
                    System.out.println("Profesores: ");
                    System.out.println(uq.getListaProfesores());
                    System.out.print("Documento del profesor: ");
                    int documento2 = sc.nextInt();

                    System.out.println("Cursos: ");
                    System.out.println(uq.getListaCursos());
                    System.out.print("Codigo del curso: ");
                    int codigo1 = sc.nextInt();

                    Profesor pro = uq.buscarProfesor(documento2);
                    Curso cur = uq.buscarCurso(codigo1);

                    if(pro != null && cur != null){
                        if(pro.agregarCurso(cur, uq)){
                            System.out.println("El curso " + cur.getNombre() + " ha sido asignado al profesor " + pro.getNombre() + ".");
                        }else{
                            System.out.println("No se pudo asignar (curso repetido o no valido).");
                        }
                    }else{
                        System.out.println("Profesor o curso no encontrado.");
                    }
                    break;
                case 8:
                    System.out.println("Profesores: ");
                    System.out.println(uq.getListaProfesores());
                    System.out.print("Documento del profesor: ");
                    int documento3 = sc.nextInt();
                    Profesor pro1 = uq.buscarProfesor(documento3);
                    if(pro1!= null){
                        System.out.println("Lista de cursos del profesor " + pro1.getNombre() + ".");
                        System.out.println(pro1.getListaCursos());
                    }else{
                        System.out.println("Profesor no encontrado.");
                    }
                    break;
                case 9:
                    System.out.println("Cursos: ");
                    System.out.println(uq.getListaCursos());
                    System.out.print("Codigo del curso: ");
                    int codigo2 = sc.nextInt();
                    System.out.println("Estudiantes: ");
                    System.out.println(uq.getListaEstudiantes());
                    System.out.print("Documento del estudiante: ");
                    int documento4 = sc.nextInt();
                    Curso cur1 = uq.buscarCurso(codigo2);
                    Estudiante estudiante1 = uq.buscarEstudiante(documento4);
                    if(cur1!= null && estudiante1!=null){
                        System.out.println("El curso " + cur1.getNombre() + " sera asignado al estudiante " + estudiante1.getNombre() + ".");
                        if(cur1.agregarEstudiantes(estudiante1)){
                            System.out.println("Estudiante matriculado en " + cur1.getNombre() + ".");
                        }else{
                            System.out.println("El estudiante ya esta en este curso.");
                        }
                    }else{
                        System.out.println("Estudiante o curso no encontrado.");
                    }
                    break;
                case 10:
                    System.out.println("Cursos: ");
                    System.out.println(uq.getListaCursos());
                    System.out.print("Codigo del curso: ");
                    int codigo3 = sc.nextInt();
                    Curso cur2 = uq.buscarCurso(codigo3);
                    if(cur2!= null){
                        System.out.println("Lista de estudiantes en el curso.");
                        System.out.println(cur2.getListaEstudiantes());
                    }else{
                        System.out.println("Curso no encontrado.");
                    }
                    break;
                default:
                    System.out.println("Opción no válida....");
                    break;
            }

        }while(opcion!=0);
        sc.close();
    }
}
