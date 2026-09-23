package uniquindio.edu.co;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nombre;
    private String horario;
    private int codigo;
    private Modalidad modalidad;

    private List<Estudiante> listaEstudiantes;

    public Curso(String nombre, String horario, int codigo, Modalidad modalidad) {
        this.nombre = nombre;
        this.horario = horario;
        this.codigo = codigo;
        this.modalidad = modalidad;

        listaEstudiantes = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nombre='" + nombre + '\'' +
                ", horario='" + horario + '\'' +
                ", codigo='" + codigo + '\'' +
                ", listaEstudiantes=" + listaEstudiantes +
                ", modalidad=" + modalidad +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }

    public List<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(List<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
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
    public boolean agregarEstudiantes(Estudiante estudiante){
        boolean agregado = false;
        boolean existe = verificarEstudiantes(estudiante.getDocumento());
        if (existe==false){
            listaEstudiantes.add(estudiante);
            agregado = true;
        }
        return agregado;
    }
}
