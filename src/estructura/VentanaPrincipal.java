package estructura;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.List;

public class VentanaPrincipal extends JFrame {

    private final TextoPredictivoService servicio;
    private final List<String> diccionario;

    private JTextArea areaDiccionario;
    private JTextField campoTexto;
    private JTextArea areaSugerencias;

    public VentanaPrincipal(TextoPredictivoService servicio, List<String> diccionario) {
        this.servicio = servicio;
        this.diccionario = diccionario;
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setTitle("Texto predictivo con Trie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ---------- Panel del diccionario ----------
        JPanel panelDiccionario = new JPanel(new BorderLayout(5, 5));
        panelDiccionario.add(new JLabel("Diccionario:"), BorderLayout.NORTH);

        areaDiccionario = new JTextArea();
        areaDiccionario.setEditable(false);
        areaDiccionario.setLineWrap(true);
        areaDiccionario.setWrapStyleWord(true);
        areaDiccionario.setText(String.join(", ", diccionario));

        JScrollPane scrollDiccionario = new JScrollPane(areaDiccionario);
        panelDiccionario.add(scrollDiccionario, BorderLayout.CENTER);

        // ---------- Panel central: entrada + sugerencias ----------
        JPanel panelCentral = new JPanel(new BorderLayout(5, 5));

        // Entrada de texto
        JPanel panelEntrada = new JPanel(new BorderLayout(5, 5));
        panelEntrada.add(new JLabel("Ingresar texto:"), BorderLayout.NORTH);

        campoTexto = new JTextField();
        panelEntrada.add(campoTexto, BorderLayout.CENTER);

        panelCentral.add(panelEntrada, BorderLayout.NORTH);

        // Área de sugerencias
        JPanel panelSugerencias = new JPanel(new BorderLayout(5, 5));
        panelSugerencias.add(new JLabel("Sugerencias:"), BorderLayout.NORTH);

        areaSugerencias = new JTextArea(5, 20);
        areaSugerencias.setEditable(false);
        areaSugerencias.setLineWrap(true);
        areaSugerencias.setWrapStyleWord(true);

        JScrollPane scrollSugerencias = new JScrollPane(areaSugerencias);
        panelSugerencias.add(scrollSugerencias, BorderLayout.CENTER);

        panelCentral.add(panelSugerencias, BorderLayout.CENTER);

        // Agregar todo al panel principal
        panelPrincipal.add(panelDiccionario, BorderLayout.NORTH);
        panelPrincipal.add(panelCentral, BorderLayout.CENTER);

        setContentPane(panelPrincipal);
        pack();
        setLocationRelativeTo(null); // centrar ventana en pantalla

        // ---------- Listener para el texto ingresado ----------
        campoTexto.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarSugerencias();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarSugerencias();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarSugerencias();
            }
        });
    }

    private void actualizarSugerencias() {
        String prefijo = campoTexto.getText().trim().toLowerCase();

        if (prefijo.isEmpty()) {
            areaSugerencias.setText("");
            return;
        }

        List<String> sugerencias = servicio.buscarSugerencias(prefijo);

        if (sugerencias == null || sugerencias.isEmpty()) {
            areaSugerencias.setText("No hay sugerencias para ese prefijo.");
        } else {
            areaSugerencias.setText(String.join(", ", sugerencias));
        }
    }
}
