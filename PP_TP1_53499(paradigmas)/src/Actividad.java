import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Actividad {
    private int id;
    private String titulo;
    private int cupoMaximo;
    private static final int CUPO_MINIMO = 1;
    private final List<Inscripcion> inscripciones;

    public Actividad(int id, String titulo, int cupoMaximo) {
        if (cupoMaximo < CUPO_MINIMO) {
            throw new IllegalArgumentException("El cupo maximo debe ser mayor o igual a " + CUPO_MINIMO);
        }
        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;
        this.inscripciones = new ArrayList<>();
    }

    public Inscripcion inscribir(Estudiante estudiante) {
        if (inscripciones.size() >= cupoMaximo) {
            throw new IllegalStateException("No hay cupos disponibles");
        }
        Inscripcion inscripcion = new Inscripcion(LocalDate.now(), "Confirmada", this, estudiante);
        inscripciones.add(inscripcion);
        return inscripcion;
    }

    public void mostrarInscripciones() {
        System.out.println("Inscripciones de " + titulo + ":");
        if (inscripciones.isEmpty()) {
            System.out.println("  Sin inscripciones.");
            return;
        }
        for (Inscripcion inscripcion : inscripciones) {
            System.out.println("  - " + inscripcion);
        }
    }

    public final String mostrarIdentificacion() {
        return "Actividad #" + id + " - " + titulo + " [" + getTipo() + "]";
    }

    public abstract double calcularCostoMateriales();

    public abstract String getTipo();

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }
}
