package estructura;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    private TrieNode raiz;

    public Trie() {
        raiz = new TrieNode();
    }

    public void insertarPalabra(String palabra) {
        TrieNode actual = raiz;

        for (char c : palabra.toLowerCase().toCharArray()) {
            actual.hijos.putIfAbsent(c, new TrieNode());
            actual = actual.hijos.get(c);
        }
        actual.finDePalabra = true;
    }

    public boolean contienePrefijo(String prefijo) {
        TrieNode nodo = buscarNodo(prefijo.toLowerCase());
        return nodo != null;
    }

    public List<String> obtenerSugerencias(String prefijo) {
        List<String> resultados = new ArrayList<>();
        TrieNode nodo = buscarNodo(prefijo.toLowerCase());

        if (nodo == null)
            return resultados;

        obtenerSugerenciasRecursivo(nodo, prefijo.toLowerCase(), resultados);
        return resultados;
    }

    private TrieNode buscarNodo(String prefijo) {
        TrieNode actual = raiz;

        for (char c : prefijo.toCharArray()) {
            if (!actual.hijos.containsKey(c))
                return null;
            actual = actual.hijos.get(c);
        }
        return actual;
    }

    private void obtenerSugerenciasRecursivo(TrieNode nodo, String palabraActual, List<String> resultados) {

        if (nodo.finDePalabra) {
            resultados.add(palabraActual);
        }

        for (char c : nodo.hijos.keySet()) {
            obtenerSugerenciasRecursivo(nodo.hijos.get(c), palabraActual + c, resultados);
        }
    }
}
