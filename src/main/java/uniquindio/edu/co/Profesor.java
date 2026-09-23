package uniquindio.edu.co;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
    private String nombre;
    private int documento;
    private int edad;
    private double salario;

    private List<Curso> listaCursos;

    public Profesor(String nombre, int documento, int edad, double salario){
        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
        this.salario = salario;

        listaCursos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "nombre='" + nombre + '\'' +
                ", documento=" + documento +
                ", edad=" + edad +
                ", salario=" + salario +
                ", listaCursos=" + listaCursos +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    //Metodo verificar cursos
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

    //Metodo agregar cursos
    public boolean agregarCurso(Curso curso, Universidad uni){
        boolean enUniversidad = uni.verificarCurso(curso.getCodigo());
        boolean agregado = false;
        boolean existe = verificarCurso(curso.getCodigo());
        if (!existe&&enUniversidad){
            listaCursos.add(curso);
            agregado = true;
        }
        return agregado;
    }
}
