package estructura;

import java.util.List;

public class TextoPredictivoService {

    private Trie trie;

    public TextoPredictivoService() {
        this.trie = new Trie();
    }

    public void cargarDiccionario(List<String> palabras) {
        for (String palabra : palabras) {
            trie.insertarPalabra(palabra);
        }
    }

    public List<String> buscarSugerencias(String prefijo) {
        return trie.obtenerSugerencias(prefijo);
    }
}
