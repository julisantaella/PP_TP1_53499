import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario {
    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int cantidadEventos = 0;

    private Sala sala;
    private final List<Actividad> actividades;

    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        this.actividades = new ArrayList<>();
        cantidadEventos++;
    }

    public EventoUniversitario(EventoUniversitario otroEvento) {
        this.id = otroEvento.id;
        this.titulo = otroEvento.titulo;
        this.costoBase = otroEvento.costoBase;
        this.gratuito = otroEvento.gratuito;
        this.actividades = new ArrayList<>();
        cantidadEventos++;
    }

    public double calcularCostoEstimado() {
        if (gratuito) {
            return 0;
        }
        double costoActividades = 0;
        for (Actividad actividad : actividades) {
            costoActividades += actividad.calcularCostoMateriales();
        }
        return (costoBase + costoActividades) * 1.21;
    }

    public void asignarSala(Sala sala) {
        this.sala = sala;
    }

    public void crearActividad(int id, String titulo, int cupo, String tipo) {
        if (tipo.equalsIgnoreCase("Charla")) {
            actividades.add(new Charla(id, titulo, cupo));
        } else if (tipo.equalsIgnoreCase("Taller")) {
            actividades.add(new Taller(id, titulo, cupo));
        } else {
            throw new IllegalArgumentException("Tipo de actividad no valido: " + tipo);
        }
    }

    public void mostrarDatos() {
        System.out.println("ID: " + id);
        System.out.println("Titulo: " + titulo);
        System.out.println("Costo base: $" + costoBase);
        System.out.println("Gratuito: " + gratuito);
        System.out.println("Sala: " + (sala == null ? "Sin sala asignada" : sala));
        System.out.println("Cantidad de actividades: " + actividades.size());
        System.out.println("Costo estimado: $" + calcularCostoEstimado());
    }

    public static int getCantidadEventos() {
        return cantidadEventos;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }
}
