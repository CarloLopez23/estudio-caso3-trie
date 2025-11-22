package estructura;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    Map<Character, TrieNode> hijos;
    boolean finDePalabra;

    public TrieNode() {
        hijos = new HashMap<>();
        finDePalabra = false;
    }
}
