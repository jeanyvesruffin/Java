import java.lang.reflect.Field;

/**
 * Lit via réflexion la valeur d'un champ d'un {@code record} local et l'affiche.
 *
 * <p>La démonstration crée un record local {@code Point(int x, int y)}, instancie
 * un objet puis récupère le champ nommé {@code x} avec
 * {@link Class#getDeclaredField(String)}. Le code rend le champ accessible
 * pour lire sa valeur et l'affiche.</p>
 */
public class RecordReader {
    /**
     * Point d'entrée qui lit et affiche le champ {@code x} d'une instance de
     * {@code Point} en utilisant la réflexion.
     *
     * @param args arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {

        record Point(int x, int y) {
        }

        Point p = new Point(1, 2);
        try {
            Field xField = p.getClass().getDeclaredField("x");
            xField.setAccessible(true);
            int x = (int) xField.get(p);
            IO.println("x = " + x);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
