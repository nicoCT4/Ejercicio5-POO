public class AuxiliarOp extends Jugador {
    private int ataques, bloqueosEfectivos, bloqueosFallidos;

    public AuxiliarOp(String nombre, String pais, int errores, int aces, int totalServicios, int ataques, int bloqueosEfectivos, int bloqueosFallidos){
        super(nombre, pais, errores, aces, totalServicios);
        this.ataques = ataques;
        this.bloqueosEfectivos = bloqueosEfectivos;
        this.bloqueosFallidos = bloqueosFallidos;
    }

    public int getAtaques(){
        return ataques;
    }
    public int getBloqueosEfectivos(){
        return bloqueosEfectivos;
    }
    public int getBloqueosFallidos(){
        return bloqueosFallidos;
    }
    @Override
    public double CalcularEfectividad(){
        return ((ataques + bloqueosEfectivos - bloqueosFallidos - errores) * 100 / (ataques +
        bloqueosEfectivos + bloqueosFallidos + errores)) + aces * 100 / totalServicios;
    }
    @Override
    public String toCSV(){
        return getNombre() + ";" + getPais() + ";" + getErrores() + ";" + getAces() + ";" + getTotalServicios() + ";" + ataques + ";" + bloqueosEfectivos + ";" + bloqueosFallidos;
    }
}
