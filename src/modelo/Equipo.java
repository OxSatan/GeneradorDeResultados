package modelo;

public class Equipo {
    private int id;
    private String equipo;
    private String ciudad;
    private String entrenador;

    public Equipo(int id, String equipo, String ciudad, String entrenador) {
        this.id = id;
        this.equipo = equipo;
        this.ciudad = ciudad;
        this.entrenador = entrenador;
    }

    public Equipo(String equipo, String ciudad, String entrenador) {
        this.equipo = equipo;
        this.ciudad = ciudad;
        this.entrenador = entrenador;
    }

    public int getId() {
        return id;
    }

    public String getEquipo() {
        return equipo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getEntrenador() {
        return entrenador;
    }

    @Override
    public String toString() {
        return equipo; // Esto se utiliza para mostrar el nombre del equipo en el JComboBox
    }
}
