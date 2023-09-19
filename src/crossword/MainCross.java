package crossword;

public class MainCross {

    public static void main(String[] args) {
        char[][] board = {
                {'+', '+', '+', '+', '+', '+', '+', '+', '+', '-',},
                {'-', '+', '+', '+', '+', '+', '+', '+', '+', '-',},
                {'-', '-', '-', '-', '-', '-', '-', '+', '+', '-',},
                {'-', '+', '+', '+', '+', '+', '+', '+', '+', '-',},
                {'-', '+', '+', '+', '+', '+', '+', '+', '+', '-',},
                {'-', '+', '+', '+', '+', '-', '-', '-', '-', '-',},
                {'-', '-', '-', '-', '-', '-', '+', '+', '+', '-',},
                {'-', '+', '+', '+', '+', '+', '+', '+', '+', '-',},
                {'+', '-', '-', '-', '-', '-', '-', '-', '-', '-',},
                {'+', '+', '+', '+', '+', '+', '+', '+', '+', '+',}
        };

        String[] words = {
                "CHEMISTRY",
                "PHYSICS",
                "CIVICS",
                "MATHS",
                "HISTORY",
                "GEOGRAPHY",
        };


        System.out.println("Before");
        CrosswordSolver.print(board);

        CrosswordSolver.solveCrossword(board, words, 0);

        System.out.println("After");
        CrosswordSolver.print(board);

    }
}
