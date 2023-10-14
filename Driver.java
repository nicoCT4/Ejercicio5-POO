/**
 * Autor: Nicolás Concuá
 * Fecha: 13/10/2023
 * Carnet: 23197
 * Universidad del Valle de Guatemala
 * Ejericio 5 Polimorfismo via herencia
 */
import java.util.Scanner;
public class Driver{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        boolean go = true;
        int opcion = 0;
        int pos = 0;
        Torneo archivo = new Torneo();
        archivo.CargarCSV("DatosVolley.csv");

        while (go){
            PrintMenu();
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    archivo.MostrarJugadores();
                    break;
                case 2:
                    System.out.println("De que posicion es el jugador?");
                    System.out.println("1. Pasador");
                    System.out.println("2. Libero");
                    System.out.println("3. AuxiliarOp");
                    pos = sc.nextInt();
                    if (pos == 1){
                        System.out.println("Ingrese el nombre del jugador");
                        String nombre = sc.next();
                        System.out.println("Ingrese el pais del jugador");
                        String pais = sc.next();
                        System.out.println("Ingrese la cantidad de errores del jugador");
                        int errores = sc.nextInt();
                        System.out.println("Ingrese la cantidad de aces del jugador");
                        int aces = sc.nextInt();
                        System.out.println("Ingrese la cantidad de servicios totales del jugador");
                        int totalServicios = sc.nextInt();
                        System.out.println("Ingrese la cantidad de pases del jugador");
                        int pases = sc.nextInt();
                        System.out.println("Ingrese la cantidad de fintas del jugador");
                        int fintas = sc.nextInt();
                        Pasador pasador = new Pasador(nombre, pais, errores, aces, totalServicios, pases, fintas);
                        archivo.AgregarJugador(pasador);
                    } else if (pos == 2){
                        System.out.println("Ingrese el nombre del jugador");
                        String nombre = sc.next();
                        System.out.println("Ingrese el pais del jugador");
                        String pais = sc.next();
                        System.out.println("Ingrese la cantidad de errores del jugador");
                        int errores = sc.nextInt();
                        System.out.println("Ingrese la cantidad de aces del jugador");
                        int aces = sc.nextInt();
                        System.out.println("Ingrese la cantidad de servicios totales del jugador");
                        int totalServicios = sc.nextInt();
                        System.out.println("Ingrese la cantidad de recibos del jugador");
                        int recibos = sc.nextInt();
                        Libero libero = new Libero(nombre, pais, errores, aces, totalServicios, recibos);
                        archivo.AgregarJugador(libero);
                    } else if (pos == 3){
                        System.out.println("Ingrese el nombre del jugador");
                        String nombre = sc.next();
                        System.out.println("Ingrese el pais del jugador");
                        String pais = sc.next();
                        System.out.println("Ingrese la cantidad de errores del jugador");
                        int errores = sc.nextInt();
                        System.out.println("Ingrese la cantidad de aces del jugador");
                        int aces = sc.nextInt();
                        System.out.println("Ingrese la cantidad de servicios totales del jugador");
                        int totalServicios = sc.nextInt();
                        System.out.println("Ingrese la cantidad de ataques del jugador");
                        int ataques = sc.nextInt();
                        System.out.println("Ingrese la cantidad de bloqueos efectivos del jugador");
                        int bloqueosEfectivos = sc.nextInt();
                        System.out.println("Ingrese la cantidad de bloqueos fallidos del jugador");
                        int bloqueosFallidos = sc.nextInt();
                        AuxiliarOp auxiliarOp = new AuxiliarOp(nombre, pais, errores, aces, totalServicios, ataques, bloqueosEfectivos, bloqueosFallidos);
                        archivo.AgregarJugador(auxiliarOp);
                    }

                case 5:
                    archivo.GuardarCSV("DatosVolley.csv");
                    break;
            }
        }

    }
    public static void PrintMenu(){
        System.out.println("\nBienvenidos Al Torneo de Volleyball");
        System.out.println("1. Mostrar a los jugadores Inscritos");
        System.out.println("2. Agregar un nuevo jugador");
        System.out.println("3. Mostrar a los 3 mejores Liberos");
        System.out.println("4. La cantidad de pasadores con más de un 80% de efectividad");
        System.out.println("5. Guardar los nuevos jugadores");
        System.out.println("Que opcion desea realizar?\n");
    }
}