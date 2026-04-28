import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase principal que lee el diccionario, construye el árbol binario de
 * búsqueda
 * y traduce un archivo de texto de inglés a español.
 */
public class MainTranslator {

    /**
     * Método principal que ejecuta el flujo del programa.
     * 
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        BinaryTree<Association<String, String>> arbol = new BinaryTree<>();

        // 1. Leer diccionario
        try {
            Scanner scanDict = new Scanner(new File("diccionario.txt"));
            while (scanDict.hasNextLine()) {
                String linea = scanDict.nextLine().trim();

                if (linea.startsWith("(") && linea.endsWith(")")) {
                    String contenido = linea.substring(1, linea.length() - 1);
                    String[] partes = contenido.split(",");

                    if (partes.length == 2) {
                        String ingles = partes[0].trim().toLowerCase();
                        String espanol = partes[1].trim().toLowerCase();
                        arbol.insert(new Association<>(ingles, espanol));
                    }
                }
            }
            scanDict.close();
        } catch (Exception e) {
            System.out.println("Error con el diccionario: " + e.getMessage());
            return; // Termina el programa si no hay diccionario
        }

        // 2. Recorrido in-order
        System.out.println("--- Diccionario In-Order ---");
        arbol.printInOrder();
        System.out.println("\n");

        // 3. Traducir el archivo de texto
        System.out.println("--- Traducción ---");
        try {
            Scanner scanTexto = new Scanner(new File("texto.txt"));
            // Regex para separar palabras de signos de puntuación
            Pattern pattern = Pattern.compile("([a-zA-Záéíóúñ]+)([^a-zA-Záéíóúñ]*)", Pattern.CASE_INSENSITIVE);

            while (scanTexto.hasNextLine()) {
                String linea = scanTexto.nextLine();
                Matcher matcher = pattern.matcher(linea);
                StringBuilder traduccion = new StringBuilder();

                while (matcher.find()) {
                    String palabra = matcher.group(1);
                    String signos = matcher.group(2);

                    // Buscamos la palabra en el árbol
                    Association<String, String> busqueda = new Association<>(palabra.toLowerCase(), null);
                    Association<String, String> resultado = arbol.search(busqueda);

                    if (resultado != null) {
                        traduccion.append(resultado.getValue());
                    } else {
                        // Si no está, le ponemos asteriscos como indica la hoja de trabajo
                        traduccion.append("*").append(palabra).append("*");
                    }
                    traduccion.append(signos);
                }
                System.out.println(traduccion.toString().trim());
            }
            scanTexto.close();

        } catch (Exception e) {
            System.out.println("No se pudo leer texto.txt: " + e.getMessage());
        }
    }
}