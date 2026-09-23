package uniquindio.edu.co;
import java.time.LocalDate;

public class Estudiante {
    private String nombre;
    private int documento;
    private LocalDate fechaNacimiento;

    public Estudiante(String nombre, int documento, LocalDate fechaNacimiento){
        this.nombre = nombre;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", documento=" + documento +
                ", fechaNacimiento=" + fechaNacimiento +
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
