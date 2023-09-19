package maze;

public class MazeBoard {

    private final int size;
    private int[][] board;

    public MazeBoard(int[][] board) {
        this.board = board;
        this.size = board.length;
    }

    public void print() {
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                int item = board[row][column];
                System.out.print(item);
            }
            System.out.println();
        }
    }

    public boolean solve(int rowItem, int columnItem) {
        for (int row = rowItem; row < size; row++) {
            for (int column = columnItem; column < size; column++) {
                int number = board[row][column];

                if (number == 1 || number == 5) {
                    // you reached the end of the track
                    if (number == 1 && row == size - 1 && column == size - 1) {
                        board[row][column] = 5;
                        return true;
                    }

                    for (int directionToGo = 0; directionToGo < size - 1; directionToGo++) {
                        switch (directionToGo) {
                           /* // up
                            case 0:
                                if (canMoveUp(row, column)) {
                                    solve
                                }
                                break;*/
                            // down
                            case 1:
                                if (canMoveDown(row, column)) {
                                    System.out.println("Down");
                                    // change the item to be 5
                                    board[row][column] = 5;
                                    if (solve(row + 1, column)) {
                                        return true;
                                    }

                                    // undo changes
                                    board[row][column] = 1;
                                }
                                break;

                            // right
                            case 2:
                                if (canMoveRight(row, column)) {
                                    System.out.println("Right");

                                    // change the item to be 5
                                    board[row][column] = 5;
                                    if (solve(row, column + 1)) {
                                        return true;
                                    }
                                    // undo changes
                                    board[row][column] = 1;
                                }
                                break;

                            // left
                            case 3:
                                if (canMoveLeft(row, column)) {
                                    System.out.println("Left");

                                    // change the item to be 5
                                    board[row][column] = 5;
                                    if (solve(row, column - 1)) {
                                        return true;
                                    }
                                    // undo changes
                                    board[row][column] = 1;
                                }
                                break;
                        }

                    }
                    return false;

                }
            }

        }
        return true;
    }

    private boolean canMoveLeft(int row, int column) {
        int newColumn = column - 1;
        if (newColumn < 0) return false;
        return board[row][newColumn] == 1;
    }

    private boolean canMoveRight(int row, int column) {
        int newColumn = column + 1;
        if (newColumn == size) return false;
        if (newColumn < 0) return false;
        return board[row][newColumn] == 1;
    }

    private boolean canMoveUp(int row, int column) {
        int newRow = row - 1;
        if (row < 0) return false;
        if (column < 0) return false;
        return board[newRow][column] == 1;
    }

    private boolean canMoveDown(int row, int column) {
        int newRow = row + 1;
        if (newRow == size) return false;
        if (row < 0) return false;
        return board[newRow][column] == 1;
    }
}
