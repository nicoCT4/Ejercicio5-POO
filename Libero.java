public class Libero extends Jugador {
    private int recibos;

    public Libero(String nombre, String pais, int errores, int aces, int totalServicios, int recibos){
        super(nombre, pais, errores, aces, totalServicios);
        this.recibos = recibos;
        this.tipo = "Libero";
    }

    public int getRecibos(){
        return recibos;
    }
    @Override
    public double CalcularEfectividad(){
        return ((recibos - getErrores()) * 100.0) / (recibos + getErrores()) + (getAces() * 100.0 / getTotalServicios());
    }
    @Override
    public String toCSV() {
        return tipo + ";" + getNombre() + ";" + getPais() + ";" + getErrores() + ";" + getAces() + ";" + getTotalServicios() + ";" + recibos;
    }
    
}
