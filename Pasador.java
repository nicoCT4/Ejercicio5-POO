public class Pasador extends Jugador {
    private int pases, fintas;

    public Pasador(String nombre, String pais, int errores, int aces, int totalServicios, int pases, int fintas){
        super(nombre, pais, errores, aces, totalServicios);
        this.pases = pases;
        this.fintas = fintas;
    }
    public int getPases(){
        return pases;
    }
    public int getFintas(){
        return fintas;
    }
    @Override
    public double CalcularEfectividad(){
        return (((pases + fintas - errores) * 100) / (pases + fintas + errores)) + (aces * 100 / totalServicios);
    }
    @Override
    public String toCSV(){
        return getNombre() + ";" + getPais() + ";" + getErrores() + ";" + getAces() + ";" + getTotalServicios() + ";" + pases + ";" + fintas;
    }
}
