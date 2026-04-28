/**
 * Implementación genérica de un Árbol Binario de Búsqueda (BST).
 * 
 * @param <E> El tipo de dato que almacenará el árbol, el cual debe ser
 *            Comparable.
 */
public class BinaryTree<E extends Comparable<E>> {

    /**
     * Clase interna que representa un nodo del árbol.
     */
    private class Node {
        E data;
        Node left, right;

        public Node(E data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root;

    /**
     * Constructor que inicializa un árbol vacío.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Inserta un nuevo elemento en el árbol.
     * 
     * @param data El elemento a insertar.
     */
    public void insert(E data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node current, E data) {
        if (current == null) {
            return new Node(data);
        }

        if (data.compareTo(current.data) < 0) {
            current.left = insertRec(current.left, data);
        } else if (data.compareTo(current.data) > 0) {
            current.right = insertRec(current.right, data);
        }
        return current;
    }

    /**
     * Busca un elemento en el árbol binario.
     * 
     * @param searchItem El elemento a buscar (se utiliza para comparar).
     * @return El elemento encontrado, o null si no se encuentra en el árbol.
     */
    public E search(E searchItem) {
        Node result = searchRec(root, searchItem);
        if (result != null) {
            return result.data;
        }
        return null;
    }

    private Node searchRec(Node current, E searchItem) {
        if (current == null || current.data.compareTo(searchItem) == 0) {
            return current;
        }
        if (current.data.compareTo(searchItem) > 0) {
            return searchRec(current.left, searchItem);
        }
        return searchRec(current.right, searchItem);
    }

    /**
     * Realiza un recorrido in-order del árbol y lo imprime en la consola.
     */
    public void printInOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.print(node.data + " ");
            inOrderRec(node.right);
        }
    }
}