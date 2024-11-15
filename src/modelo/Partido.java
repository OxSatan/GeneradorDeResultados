package modelo;

public class Partido {
    private Equipo local;
    private Equipo visitante;
    private int golesLocal;
    private int golesVisitante;

    public Partido(Equipo local, Equipo visitante) {
        this.local = local;
        this.visitante = visitante;
    }

    public void simularPartido() {
        this.golesLocal = (int) (Math.random() * 5); // Goles aleatorios entre 0 y 4
        this.golesVisitante = (int) (Math.random() * 5);
    }

    // Getters
    public Equipo getLocal() {
        return local;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }
}
