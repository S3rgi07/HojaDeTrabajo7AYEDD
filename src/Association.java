/**
 * Clase que representa una asociación entre una palabra en inglés y su
 * traducción al español.
 * Implementa Comparable para poder ordenar las asociaciones en el árbol
 * binario.
 * 
 * @param <K> El tipo de la llave (la palabra en inglés, que debe ser
 *            Comparable).
 * @param <V> El tipo del valor (la traducción al español).
 */
public class Association<K extends Comparable<K>, V> implements Comparable<Association<K, V>> {
    private K key;
    private V value;

    /**
     * Constructor de la asociación.
     * 
     * @param key   La llave (palabra en inglés).
     * @param value El valor (traducción al español).
     */
    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Obtiene la llave de la asociación.
     * 
     * @return La llave.
     */
    public K getKey() {
        return key;
    }

    /**
     * Obtiene el valor de la asociación.
     * 
     * @return El valor.
     */
    public V getValue() {
        return value;
    }

    /**
     * Compara esta asociación con otra basándose únicamente en la llave.
     * 
     * @param otra La otra asociación a comparar.
     * @return Un entero negativo, cero, o positivo según el orden de las llaves.
     */
    @Override
    public int compareTo(Association<K, V> otra) {
        // Solo nos interesa comparar por la llave (inglés)
        return this.key.compareTo(otra.key);
    }

    /**
     * Representación en formato de cadena de la asociación.
     * 
     * @return Cadena con el formato (llave, valor).
     */
    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}