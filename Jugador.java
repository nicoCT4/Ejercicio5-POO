public abstract class Jugador {
    protected String nombre;
    protected String pais;
    protected int errores;
    protected int aces;
    protected int totalServicios;
    protected String tipo;

    public Jugador(String nombre, String pais, int errores, int aces, int totalServicios){
        this.nombre = nombre;
        this.pais = pais;
        this.errores = errores;
        this.aces = aces;
        this.totalServicios = totalServicios;
        this.tipo = tipo;
    }
    //getters
    public String getNombre(){
        return nombre;
    }
    public String getTipo(){
        return tipo;
    }
    
    public String getPais(){
        return pais;
    }
    public int getErrores(){
        return errores;
    }
    public int getAces(){
        return aces;
    }
    public int getTotalServicios(){
        return totalServicios;
    }
    public String toString(){
        return "\nNombre: " + nombre + "\nPais: " + pais + "\nErrores: " + errores + "\nAces: " + aces + "\nTotal de servicios: " + totalServicios + "\n Efectividad: "+CalcularEfectividad();
    }

    //Metodos abstractos
    public abstract double CalcularEfectividad();

    public abstract String toCSV();
}
