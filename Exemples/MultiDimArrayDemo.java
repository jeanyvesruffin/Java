package Exemples;

public class MultiDimArrayDemo {
    public static void main(String[] args) {
        String[][] names = {
                { "Mr. ", "Mrs. ", "Ms. " },
                { "Smith", "Jones" }
        };

        System.out.println(names[0][0]);
        System.out.println(names[1][0]);
        System.out.println(names[0][2]);
        System.out.println(names[1][1]);
        // Mr. Smith
        System.out.println(names[0][0] + names[1][0]);
        // Ms. Jones
        System.out.println(names[0][2] + names[1][1]);

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