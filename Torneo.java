import java.util.ArrayList;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Torneo {
    private BufferedReader lector;
    private String linea;
    private String partes[] = null;
    private ArrayList<Jugador> jugadores;

    public Torneo(){
        jugadores = new ArrayList<Jugador>();
    }

    public void AgregarJugador(Jugador jugador){
        jugadores.add(jugador);
    }
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void MostrarPasadores() {
        System.out.println("Pasadores con más del 80% de efectividad:");
    
        int cantidadPasadores = 0; // Variable para rastrear la cantidad de pasadores con más del 80% de efectividad
    
        for (Jugador jugador : jugadores) {
            if (jugador instanceof Pasador) {
                double efectividad = jugador.CalcularEfectividad();
    
                if (efectividad > 80.0) {
                    cantidadPasadores++;
                    System.out.println(jugador.getNombre() + " - " + efectividad + "% de efectividad");
                }
            }
        }
    
        System.out.println("Total de pasadores con más del 80% de efectividad: " + cantidadPasadores);
    }
    
    
    

    public void MostrarJugadores() {
        for (Jugador jugador : jugadores) {
            if (jugador instanceof Libero) {
                System.out.println("\nLibero: " + jugador);
            } else if (jugador instanceof Pasador) {
                System.out.println("\nPasador: " + jugador);
            } else if (jugador instanceof AuxiliarOp) {
                System.out.println("\nAuxiliarOp: " + jugador);
            }
        }
    }

    public void Mostrar3MejoresLiberos() {
    ArrayList<Jugador> liberos = new ArrayList<Jugador>();
    
    for (Jugador jugador : jugadores) {
        if (jugador instanceof Libero) {
            liberos.add(jugador);
        }
    }

    if (liberos.size() < 3) {
        System.out.println("No hay suficientes liberos para mostrar los 3 mejores.");
    } else {
        liberos.sort(Comparator.comparingDouble(Jugador::CalcularEfectividad).reversed());
        
        System.out.println("Los 3 mejores liberos son:");
        for (int i = 0; i < 3; i++) {
            Jugador libero = liberos.get(i);
            double efectividad = libero.CalcularEfectividad();
            System.out.println((i + 1) + ". " + libero.getNombre() + " - " + efectividad + "% de efectividad");
        }
    }
}

    
    

    public void CargarCSV(String nombreArchivo) {
        try {
            lector = new BufferedReader(new FileReader(nombreArchivo));
            boolean primeraLinea = true;  // Variable para rastrear la primera línea
            while ((linea = lector.readLine()) != null) {
                partes = linea.split(";");
                
                // Omitir la primera línea (encabezados)
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }
    
                // Asegurarse de que haya suficientes campos para representar un jugador
                if (partes.length >= 7) {
                    String tipo = partes[0];
                    String nombre = partes[1];
                    String pais = partes[2];
                    int errores = Integer.parseInt(partes[3]);
                    int aces = Integer.parseInt(partes[4]);
                    int totalServicios = Integer.parseInt(partes[5]);
    
                    Jugador jugador = null;
    
                    if (tipo.equals("Pasador")) {
                        int pases = partes[6].isEmpty() ? 0 : Integer.parseInt(partes[6]);
                        int fintas = partes[7].isEmpty() ? 0 : Integer.parseInt(partes[7]);
                        jugador = new Pasador(nombre, pais, errores, aces, totalServicios, pases, fintas);
                    } else if (tipo.equals("Libero")) {
                        int recibos = partes[6].isEmpty() ? 0 : Integer.parseInt(partes[6]);
                        jugador = new Libero(nombre, pais, errores, aces, totalServicios, recibos);
                    } else if (tipo.equals("AuxiliarOp")) {
                        int ataques = partes[6].isEmpty() ? 0 : Integer.parseInt(partes[6]);
                        int bloqueosFallidos = partes[7].isEmpty() ? 0 : Integer.parseInt(partes[7]);
                        int bloqueosEfectivos = partes[8].isEmpty() ? 0 : Integer.parseInt(partes[8]);
                        jugador = new AuxiliarOp(nombre, pais, errores, aces, totalServicios, ataques, bloqueosEfectivos, bloqueosFallidos);
                    }
    
                    if (jugador != null) {
                        AgregarJugador(jugador);  // Agrega el jugador al ArrayList de jugadores en la clase Torneo
                    }   
                }
            }
            lector.close();
            linea = null;
            partes = null;
        } catch (Exception e) {
            System.out.println("Error al leer el archivo");
            System.out.println(e);
        }
    }

    public void GuardarCSV(String nombreArchivo) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Jugador jugador : jugadores) {
                String linea = jugador.toCSV();
                escritor.write(linea);
                escritor.newLine();
            }
            System.out.println("Datos guardados en " + nombreArchivo);
        } catch (Exception e) {
            System.out.println("Error al guardar el archivo CSV");
            System.out.println(e);
        }
    }
}
