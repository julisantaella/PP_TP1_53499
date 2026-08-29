public class App {
    public static void main(String[] args) {
        // EJERCICIO 1
        EventoUniversitario evento1 = new EventoUniversitario(
                "E001", "Introduccion a POO", 10000, false);
        EventoUniversitario copiaEvento1 = new EventoUniversitario(evento1);

        System.out.println("===== EJERCICIO 1 =====");
        System.out.println("EVENTO ORIGINAL");
        evento1.mostrarDatos();
        System.out.println("\nCOPIA");
        copiaEvento1.mostrarDatos();
        System.out.println("\nCantidad de eventos creados: " + EventoUniversitario.getCantidadEventos());

        // EJERCICIO 2 Y 3
        Estudiante estudiante1 = new Estudiante("1001", "Ana Perez");
        Estudiante estudiante2 = new Estudiante("1002", "Bruno Gomez");
        Estudiante estudiante3 = new Estudiante("1003", "Carla Lopez");

        EventoUniversitario evento2 = new EventoUniversitario(
                "E002", "Jornada de Java", 20000, false);
        Sala sala1 = new Sala(1, "Aula Magna");
        evento2.asignarSala(sala1);

        evento2.crearActividad(1, "POO desde cero", 10, "Charla");
        evento2.crearActividad(2, "Taller practico de Java", 10, "Taller");

        Actividad charla = evento2.getActividades().get(0);
        Actividad taller = evento2.getActividades().get(1);

        charla.inscribir(estudiante1);
        charla.inscribir(estudiante2);
        taller.inscribir(estudiante2);
        taller.inscribir(estudiante3);

        System.out.println("\n===== EJERCICIOS 2 Y 3 =====");
        evento2.mostrarDatos();
        charla.mostrarInscripciones();
        taller.mostrarInscripciones();

        System.out.println("\nIdentificacion polimorfica:");
        for (Actividad actividad : evento2.getActividades()) {
            System.out.println(actividad.mostrarIdentificacion());
            System.out.println("Costo de materiales: $" + actividad.calcularCostoMateriales());
        }

        System.out.println("\nCantidad total de eventos creados: "
                + EventoUniversitario.getCantidadEventos());

        // EJERCICIO 4: escenario indicado por la consigna
        // 3 estudiantes, 1 evento, 1 sala, 1 charla, 1 taller,
        // 2 inscripciones en la charla y 2 en el taller.
        System.out.println("\n===== EJERCICIO 4 =====");
        Estudiante e1 = new Estudiante("2001", "Estudiante 1");
        Estudiante e2 = new Estudiante("2002", "Estudiante 2");
        Estudiante e3 = new Estudiante("2003", "Estudiante 3");

        EventoUniversitario evento4 = new EventoUniversitario(
                "E004", "Evento para mapa de memoria", 10000, false);
        Sala sala4 = new Sala(4, "Sala 4");
        evento4.asignarSala(sala4);
        evento4.crearActividad(5, "Charla", 10, "Charla");
        evento4.crearActividad(6, "Taller", 10, "Taller");

        Actividad charla4 = evento4.getActividades().get(0);
        Actividad taller4 = evento4.getActividades().get(1);
        charla4.inscribir(e1);
        charla4.inscribir(e2);
        taller4.inscribir(e2);
        taller4.inscribir(e3);

        System.out.println("Escenario del Ejercicio 4 creado correctamente.");
        System.out.println("Objetos: 3 estudiantes, 1 evento, 1 sala, 1 charla, 1 taller y 4 inscripciones.");
    }
}
