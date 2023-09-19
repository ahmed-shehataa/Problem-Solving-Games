package soduko;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {

    private final int size;
    private int[][] board;


    public SudokuBoard(int[][] board) {
        this.board = board;
        this.size = board.length;
    }


    public void print() {
        for (int row = 0; row < getSize(); row++) {
            if (row % 3 == 0 && row != 0)
                System.out.println("----------");

            for (int column = 0; column < getSize(); column++) {
                if (column % 3 == 0 && column != 0)
                    System.out.print("|");
                int item = board[row][column];
                System.out.print(item);
            }
            System.out.println();
        }
    }

    public static void printBoard(int[][] board, int size) {
        for (int row = 0; row < size; row++) {
            if (row % 3 == 0 && row != 0)
                System.out.println("----------");

            for (int column = 0; column < size; column++) {
                if (column % 3 == 0 && column != 0)
                    System.out.print("|");
                int item = board[row][column];
                System.out.print(item);
            }
            System.out.println();
        }
    }

    public void rotate_90() {
        for (int row = 0; row < getSize(); row++) {
            for (int column = row; column < getSize(); column++) {
                int temp = board[row][column];
                board[row][column] = board[column][row];
                board[column][row] = temp;

            }
        }
    }

    public void flip_vertical() {
        for (int row = 0; row < getSize(); row++) {
            for (int column = 0; column < getSize() / 2; column++) {
                int temp = board[row][column];
                board[row][column] = board[row][getSize() - 1 - column];
                board[row][getSize() - 1 - column] = temp;

            }
        }
    }

    public void flip_horizontal() {
        for (int column = 0; column < getSize(); column++) {
            for (int row = 0; row < getSize() / 2; row++) {
                int temp = board[row][column];
                board[row][column] = board[getSize() - 1 - row][column];
                board[getSize() - 1 - row][column] = temp;

            }
        }
    }



    public int[][] crop(int rowIndex, int columnIndex, int boxSize) {
        int[][] croppedBoard = new int[boxSize][boxSize];
        for (int row = rowIndex; row < rowIndex + boxSize; row++) {
            for (int column = columnIndex; column < columnIndex + boxSize; column++) {
                int item = board[row][column];
                croppedBoard[row - rowIndex][column - columnIndex] = item;
            }
        }
        return croppedBoard;
    }

    public void solve() {
        //do {
            completeRows();
            completeColumns();
            completeBoxes();
        //} while (!isSolved());
    }

    private void completeBoxes() {
        for (int row = 0; row < getSize(); row += 3) {
            for (int column = 0; column < getSize(); column += 3) {
                if (isOneMissingInBox(row, column)) {
                    NumberCoordinates numberCoordinates = getMissingNumberCoordinates(row, column);
                    if (numberCoordinates != null)
                        completeMissingNumberInBox(numberCoordinates);
                }
            }
        }
    }

    private void completeMissingNumberInBox(NumberCoordinates numberCoordinates) {
        int localBoxRow = numberCoordinates.getRow() - numberCoordinates.getRow() % 3;
        int localBoxColumn = numberCoordinates.getColumn() - numberCoordinates.getColumn() % 3;
        List localBoxArray = new ArrayList<Integer>();

        for (int i = localBoxRow; i < localBoxRow + 3; i++) {
            for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
                localBoxArray.add(board[i][j]);
            }
        }
        board[numberCoordinates.getRow()][numberCoordinates.getColumn()] = getMissingNumber(localBoxArray);
    }

    private int getMissingNumber(List<Integer> localBoxArray) {
        int sum = localBoxArray.size() * ((localBoxArray.size() + 1) / 2);
        int resultSum = 0;

        for (int i = 0; i < localBoxArray.size(); i++) {
            resultSum += localBoxArray.get(i);
        }

        return sum - resultSum;
    }

    private NumberCoordinates getMissingNumberCoordinates(int rowBox, int columnBox) {
        for (int i = rowBox; i < rowBox + 3; i++) {
            for (int j = columnBox; j < columnBox + 3; j++) {
                if (board[i][j] == 0) {
                    return new NumberCoordinates(i, j);
                }
            }
        }
        return null;
    }

    private boolean isOneMissingInBox(int rowBox, int columnBox) {
        int missingNumbers = 0;
        for (int i = rowBox; i < rowBox + 3; i++) {
            for (int j = columnBox; j < columnBox + 3; j++) {
                if (missingNumbers > 1) return false;
                if (board[i][j] == 0) {
                    missingNumbers++;
                }
            }
        }
        if (missingNumbers == 0) {
            return false;
        } else return missingNumbers == 1;
    }

    private void completeColumns() {
        rotate_90();
        completeRows();
        rotate_90();
    }

    private boolean isSolved() {
        for (int row = 0; row < getSize(); row++) {
            for (int column = 0; column < getSize(); column++) {
                int item = board[row][column];
                if (item == 0) return false;
            }
        }
        return true;
    }

    private void completeRows() {
        for (int row = 0; row < getSize(); row++) {
            int[] rowArray = board[row];
            if (getMissingState(rowArray))
                completeMissingItem(rowArray);
        }
    }

    private void completeMissingItem(int[] rowArray) {
        int sum = rowArray.length * ((rowArray.length + 1) / 2);
        int resultSum = 0;
        int missingNumberIndex = -1;

        for (int i = 0; i < rowArray.length; i++) {
            if (rowArray[i] == 0)
                missingNumberIndex = i;
            resultSum += rowArray[i];
        }
        int missingNumber = sum - resultSum;
        rowArray[missingNumberIndex] = missingNumber;
    }

    private boolean getMissingState(int[] array) {
        int emptyBlockCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (emptyBlockCount > 1) return false;
            if (array[i] == 0) {
                emptyBlockCount++;
            }
        }
        if (emptyBlockCount == 1) return true;
        return false;
    }

    public int getSize() {
        return this.size;
    }


    /**
     * @param number
     * @param row
     * @return
     */
    private boolean isNumberInRow(int number, int row) {
        for (int i = 0; i < getSize(); i++) {
            if (board[row][i] == number)
                return true;
        }
        return false;
    }

    private boolean isNumberInColumn(int number, int column) {
        for (int i = 0; i < getSize(); i++) {
            if (board[i][column] == number)
                return true;
        }
        return false;
    }

    private boolean isNumberInBox(int number, int row, int column) {
        int localBoxRow = row - row % 3;
        int localBoxColumn = column - column % 3;
        for (int i = localBoxRow; i < localBoxRow + 3; i++) {
            for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
                if (board[i][j] == number)
                    return true;
            }
        }
        return false;
    }

    private boolean isValidPlacement(int number, int row, int column) {
        return !isNumberInRow(number, row) &&
                !isNumberInColumn(number, column) &&
                !isNumberInBox(number, row, column);
    }

    public boolean solveBoard() {
        for (int row = 0; row < getSize(); row++) {
            for (int column = 0; column < getSize(); column++) {
                if (board[row][column] == 0) {
                    for (int numberToTry = 1; numberToTry <= getSize(); numberToTry++) {
                        if (isValidPlacement(numberToTry, row, column)) {
                            board[row][column] = numberToTry;
                            if (solveBoard()) {
                                return true;
                            } else {
                                board[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }


}
