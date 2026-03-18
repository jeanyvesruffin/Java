/**
 * Démonstration de plusieurs classes dans un même fichier.
 *
 * <p>
 * Exécute des méthodes utilitaires définies dans les classes
 * {@code GenerateMessage}
 * et {@code AnotherMessage} pour afficher des messages.
 * </p>
 */
public class MultipleClassesInSameFile {
    /**
     * Point d'entrée qui affiche deux messages générés par les classes utilitaires.
     *
     * @param args arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        IO.println(GenerateMessage.generateMessage());
        IO.println(AnotherMessage.anotherMessage());

    }
}

/**
 * Fournit un message simple.
 */
class GenerateMessage {
    /**
     * Génère un message fixe.
     *
     * @return une chaîne contenant le message
     */
    static String generateMessage() {
        return "Premier message";
    }
}

/**
 * Fournit un autre message simple.
 */
class AnotherMessage {
    /**
     * Génère un second message fixe.
     *
     * @return une chaîne contenant le message
     */
    static String anotherMessage() {
        return "Deuxième message";
    }
}