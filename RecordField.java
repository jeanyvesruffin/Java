import java.lang.reflect.Field;

/**
 * Extrait et affiche les champs déclarés d'un {@code record} local via réflexion.
 *
 * <p>La classe déclare un record local {@code Point(int x, int y)}, récupère
 * les champs déclarés avec {@link Class#getDeclaredFields()} et les affiche
 * en utilisant la sortie fournie par la classe utilitaire {@code IO}.</p>
 */
public class RecordField {
    /**
     * Point d'entrée qui récupère et affiche les champs du record {@code Point}.
     *
     * @param args arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        record Point(int x, int y) {
        }
        Class<?> c = Point.class;
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            IO.println("field = " + field);
        }

    }
}