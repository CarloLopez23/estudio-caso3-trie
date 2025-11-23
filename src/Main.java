import estructura.TextoPredictivoService;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        List<String> diccionario = List.of(
                "casa", "casita", "caso", "cascada",
                "perro", "persona", "permiso",
                "computadora", "comer", "cometa"
        );

        TextoPredictivoService servicio = new TextoPredictivoService();
        servicio.cargarDiccionario(diccionario);

        // TEMPORAL hasta que exista la GUI
        // new VentanaPrincipal(servicio);

        // PRUEBAS
        System.out.println(servicio.buscarSugerencias("pe"));
        System.out.println(servicio.buscarSugerencias("ca"));
        System.out.println(servicio.buscarSugerencias("com"));
    }
}

