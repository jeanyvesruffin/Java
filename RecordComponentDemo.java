import java.lang.reflect.Method;
import java.lang.reflect.RecordComponent;
import java.lang.reflect.Type;

/**
 * Exemple d'utilisation de la réflexion pour inspecter les composants d'un {@code record}.
 *
 * <p>La classe déclare localement un record {@code Point(int x, int y)}, récupère ses
 * {@link java.lang.reflect.RecordComponent RecordComponent}s via
 * {@link Class#getRecordComponents()} et affiche, pour le premier composant trouvé,
 * des informations utiles : la classe déclarante, le nom du composant, la méthode
 * accessrice, son type et sa signature générique.
 *
 * <p>Cette classe est une démonstration. Elle ne gère pas tous les cas d'erreur (par
 * exemple, elle suppose qu'au moins un composant est présent dans le tableau retourné
 * par {@link Class#getRecordComponents()}).
 *
 * @author ruffi
 * @since 1.0
 * @see java.lang.Class#getRecordComponents()
 * @see java.lang.reflect.RecordComponent
 */
public class RecordComponentDemo {

    /**
     * Exécute la démonstration d'inspection des composants d'un record local.
     *
     * <p>Le flux principal :
     * <ol>
     *   <li>déclaration d'un record local {@code Point};</li>
     *   <li>récupération de ses composants via {@link Class#getRecordComponents()};</li>
     *   <li>affichage d'informations pour le premier composant trouvé (si présent).</li>
     * </ol>
     *
     * @param args arguments de la ligne de commande (ignorés)
     */
    public static void main(String[] args) {

        
        record Point<T>(T x, T y) {
        }

        Class<?> c = Point.class;

        RecordComponent[] components = c.getRecordComponents();
        Class<?> declaring = components[0].getDeclaringRecord();
        IO.println("Declaring record: " + declaring);

        String name = components[0].getName();
        IO.println("name = " + name);

        Method accessor = components[0].getAccessor();
        IO.println("accessor = " + accessor);

        Class<?> type = components[0].getType();
        IO.println("type = " + type);

        Type genericType = components[0].getGenericType();
        IO.println("genericType = " + genericType);

        String genericSignature = components[0].getGenericSignature();
        IO.println("genericSignature = " + genericSignature);

    }

}
