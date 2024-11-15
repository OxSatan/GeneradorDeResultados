import controlador.ControladorEquipo;
import modelo.EquipoDAO;
import vista.VentanaPrincipal;

public class Main {
    public static void main(String[] args) {
        EquipoDAO equipoDAO = new EquipoDAO();
        VentanaPrincipal vista = new VentanaPrincipal();
        ControladorEquipo controlador = new ControladorEquipo(equipoDAO, vista);

        vista.setVisible(true);
    }
}
