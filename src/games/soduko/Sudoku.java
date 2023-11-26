package games.soduko;

public class Sudoku {

    public static void main(String[] args) {

        int[][] board_9 = {
                {0, 3, 7, 5, 1, 9, 8, 0, 4},
                {8, 0, 5, 7, 2, 0, 1, 3, 6},
                {0, 2, 1, 3, 0, 8, 5, 7, 0},
                {3, 6, 0, 1, 9, 5, 7, 0, 2},
                {2, 0, 4, 6, 3, 0, 9, 5, 8},
                {5, 7, 9, 8, 4, 2, 0, 6, 1},
                {7, 8, 6, 0, 5, 1, 2, 9, 3},
                {0, 5, 3, 2, 8, 6, 4, 0, 7},
                {1, 4, 2, 9, 0, 3, 6, 8, 5}
        };

        int[][] board_3 = {
                {0, 3, 7},
                {8, 0, 5},
                {0, 2, 1},
        };

        SudokuBoard sudokuBoard = new SudokuBoard(board_9);
        sudokuBoard.print();

        System.out.println("\nAfter");
        sudokuBoard.solveBoard();
       // sudokuBoard.solveBoard();
        sudokuBoard.print();


    }

}
