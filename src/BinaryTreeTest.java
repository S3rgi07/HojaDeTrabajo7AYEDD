import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Clase de pruebas unitarias para validar las operaciones de inserción y
 * búsqueda del Árbol Binario de Búsqueda.
 */
public class BinaryTreeTest {

    private BinaryTree<Association<String, String>> arbol;

    /**
     * Configuración inicial antes de cada prueba.
     */
    @BeforeEach
    public void setUp() {
        arbol = new BinaryTree<>();
    }

    /**
     * Prueba que verifica si un elemento se inserta correctamente y puede ser
     * encontrado.
     */
    @Test
    public void testInsertAndSearch() {
        Association<String, String> testWord = new Association<>("dog", "perro");
        arbol.insert(testWord);

        Association<String, String> target = new Association<>("dog", null);
        Association<String, String> result = arbol.search(target);

        assertNotNull(result);
        assertEquals("perro", result.getValue());
    }

    /**
     * Prueba que verifica el comportamiento cuando se busca un elemento que no
     * existe.
     */
    @Test
    public void testNotFound() {
        Association<String, String> testWord = new Association<>("dog", "perro");
        arbol.insert(testWord);

        Association<String, String> target = new Association<>("cat", null);
        Association<String, String> result = arbol.search(target);

        assertNull(result);
    }
}