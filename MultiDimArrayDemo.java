/**
 * Démonstration d'utilisation de tableaux multidimensionnels (2D arrays).
 *
 * <p>
 * Affiche des exemples simples de concaténation de chaînes, d'affichage d'une
 * matrice
 * d'entiers et d'un emploi du temps. Utilise la classe utilitaire {@code IO}
 * pour l'affichage.
 * </p>
 */
public class MultiDimArrayDemo {
    /**
     * Point d'entrée de la démonstration.
     *
     * @param args arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        String[][] names = {
                { "Mr. ", "Mrs. ", "Ms. " },
                { "Smith", "Jones" }
        };

        IO.println(names[0][0]);
        IO.println(names[1][0]);
        IO.println(names[0][2]);
        IO.println(names[1][1]);
        // Mr. Smith
        IO.println(names[0][0] + names[1][0]);
        // Ms. Jones
        IO.println(names[0][2] + names[1][1]);

        // Multidimensional arrays (2D array)
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        IO.println("3x3 Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                IO.print(matrix[i][j] + " ");
            }
            IO.println(); // New line after each row
        }

        // Try a different shaped matrix
        String[][] schedule = {
                { "Math", "Science", "English" },
                { "History", "Art", "PE" },
                { "Music", "Computer", "Study Hall" }
        };

        IO.println("");
        IO.println("Class Schedule:");
        String[] periods = { "Period 1", "Period 2", "Period 3" };
        for (int day = 0; day < schedule.length; day++) {
            IO.println("Day " + (day + 1) + ":");
            for (int period = 0; period < schedule[day].length; period++) {
                IO.println("  " + periods[period] + ": " + schedule[day][period]);
            }
        }
    }

}