import estructura.Trie;

public class Main {
    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.insertarPalabra("Perro");
        trie.insertarPalabra("Persona");
        trie.insertarPalabra("Permiso");
        trie.insertarPalabra("Maestro");
        trie.insertarPalabra("Mar");
        trie.insertarPalabra("Mamá");

        System.out.println("Prefijo 'Per': " + trie.obtenerSugerencias("Per"));
        System.out.println("Prefijo 'Pe': " + trie.obtenerSugerencias("Pe"));
        System.out.println("Prefijo 'Ma': " + trie.obtenerSugerencias("Ma"));
        System.out.println("Prefijo 'X': " + trie.obtenerSugerencias("X"));
    }
}
