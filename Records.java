/**
 * Exemples d'utilisation des records et de l'API {@code Class} pour déterminer
 * si
 * une classe est un record.
 */
public class Records {

    /**
     * Point d'entrée qui déclare un record local et affiche si certaines classes
     * sont des records.
     *
     * @param args arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {

        record Point(int x, int y) {
        }

        Class<?> c1 = String.class;
        Class<?> c2 = Point.class;

        IO.println("Is " + c1.getSimpleName() + " a record class? " + c1.isRecord());
        IO.println("Is " + c2.getSimpleName() + " a record class?  " + c2.isRecord());

    }

}
