package maze;

public class MazeMain {


    public static void main(String[] args) {

        int[][] board = {
                {1, 1, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 1, 1, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 1, 1, 1, 1},
        };

        MazeBoard mazeBoard = new MazeBoard(board);


        System.out.println("Before");
        mazeBoard.print();

        mazeBoard.solve(0, 0);

        System.out.println("After");
        mazeBoard.print();
    }
}