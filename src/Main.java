import estructura.TextoPredictivoService;
import estructura.VentanaPrincipal;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Diccionario base
        List<String> diccionario = List.of(
                "casa", "casita", "caso", "cascada",
                "perro", "persona", "permiso",
                "computadora", "comer", "cometa"
        );

        TextoPredictivoService servicio = new TextoPredictivoService();
        servicio.cargarDiccionario(diccionario);

        javax.swing.SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal(servicio, diccionario);
            ventana.setVisible(true);
        });
    }
}
