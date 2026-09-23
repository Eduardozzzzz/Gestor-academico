package uniquindio.edu.co;

import java.util.ArrayList;
import java.util.List;

public class Universidad {

    private String nombre;
    private String direccion;
    private String ciudad;
    private int telefono;

    //Creacion de listas
    private List<Estudiante> listaEstudiantes;
    private List<Profesor> listaProfesores;
    private List<Curso> listaCursos;

    public Universidad(String nombre, String direccion, String ciudad, int telefono){
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;

        //Inicializar las listas
        listaEstudiantes = new ArrayList<>();
        listaCursos = new ArrayList<>();
        listaProfesores = new ArrayList<>();

    }

    @Override
    public String toString() {
        return "Universidad{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", telefono=" + telefono +
                ", listaEstudiantes=" + listaEstudiantes +
                ", listaProfesores=" + listaProfesores +
                ", listaCursos=" + listaCursos +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public List<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(List<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public List<Profesor> getListaProfesores() {
        return listaProfesores;
    }

    public void setListaProfesores(List<Profesor> listaProfesores) {
        this.listaProfesores = listaProfesores;
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    //Metodo verificar estudiantes
    public boolean verificarEstudiantes(int documento){
        boolean existe=false;
        for(Estudiante estudiante:listaEstudiantes){
            if(estudiante.getDocumento()==documento){
                existe=true;
                break;
            }
        }
        return existe;
    }
    //Metodo agregar estudiantes
    public boolean agregarEstudiante(Estudiante estudiante){
        boolean agregado = false;
        boolean existe = verificarEstudiantes(estudiante.getDocumento());
        if (existe==false){
            listaEstudiantes.add(estudiante);
            agregado = true;
        }
        return agregado;
    }

    public boolean verificarProfesor(int documento){
        boolean existe=false;
        for(Profesor profesor:listaProfesores){
            if(profesor.getDocumento()==documento){
                existe=true;
                break;
            }
        }
        return existe;
    }
    public boolean agregarProfesor(Profesor profesor){
        boolean agregado = false;
        boolean existe = verificarProfesor(profesor.getDocumento());
        if(existe==false){
            listaProfesores.add(profesor);
            agregado = true;
        }
        return agregado;
    }

    //Actualizar profesor
    public boolean actualizarProfesor(int documento, Profesor profesorActualizado){
        boolean estaActualizado=false;
        for (Profesor profesor:listaProfesores){
            if(profesor.getDocumento()==documento){
                profesor.setNombre(profesorActualizado.getNombre());
                profesor.setEdad(profesorActualizado.getEdad());
                profesor.setSalario(profesorActualizado.getSalario());
                estaActualizado=true;
                break;
            }
        }
        return estaActualizado;
    }

    public boolean verificarCurso(int codigo){
        boolean existe=false;
        for(Curso curso:listaCursos){
            if(curso.getCodigo()==codigo){
                existe=true;
                break;
            }
        }
        return existe;
    }

    public boolean agregarCurso(Curso curso){
        boolean agregado = false;
        boolean existe = verificarCurso(curso.getCodigo());
        if(existe==false){
            listaCursos.add(curso);
            agregado = true;
        }
        return agregado;
    }

    //Buscar para asignar
    public Profesor buscarProfesor(int documento){
        for(Profesor p : listaProfesores){
            if(p.getDocumento()==documento) return p;
        }
        return null;  // no existe
    }
    public Curso buscarCurso(int codigo){
        for(Curso c : listaCursos){
            if(c.getCodigo()==codigo) return c;
        }
        return null;
    }
    public Estudiante buscarEstudiante(int documento){
        for(Estudiante e : listaEstudiantes){
            if(e.getDocumento()==documento) return e;
        }
        return null;  // no existe
    }
}
