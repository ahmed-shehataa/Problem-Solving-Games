package games.tic_tac;

public class TicTacTeoBoard {

    private final Player playerOne;
    private final Player playerTwo;
    private Player currentPlayer;
    private final int size;
    private Player winnerPlayer;
    private boolean isBoardFilled;
    private char[][] board;


    public TicTacTeoBoard(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.currentPlayer = playerOne;
        this.size = 3;
        initBoard();
    }

    private void initBoard() {
        int counter = -0;
        board = new char[size][size];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                counter++;
                board[i][j] = (char) (counter + '0');
            }
        }
    }

    public void print() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void play(int position) {
        updateBoard(position);
        isBoardFilled = checkBoardIsFilled();
        checkWinner();
        if (isBoardFilled)
            return;
        switchPlayer();
    }

    private boolean checkBoardIsFilled() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (Character.isDigit(board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private void checkWinner() {
        // check rows
        char[] rowData = new char[size];
        for (int i = 0; i < board.length; i++) {
            Player player = checkArrayMatchSign(rowData);
            if (player != null) {
                setWinner(player);
                break;
            }
            for (int j = 0; j < board[i].length; j++) {
                if (Character.isDigit(board[i][j])) {
                    rowData = new char[size];
                    break;
                } else {
                    rowData[j] = board[i][j];
                }
            }
        }

        //check columns
        for (int i = 0; i < board.length; i++) {
            Player player = checkArrayMatchSign(rowData);
            if (player != null) {
                setWinner(player);
                break;
            }
            for (int j = 0; j < board[i].length; j++) {
                if (Character.isDigit(board[j][i])) {
                    rowData = new char[size];
                    break;
                } else {
                    rowData[j] = board[j][i];
                }
            }
        }

        //check x lines
        for (int i = 0; i < board.length; i++) {
            Player player = checkArrayMatchSign(rowData);
            if (player != null) {
                setWinner(player);
                break;
            }
            for (int j = 0; j < board[i].length; j++) {
                if (i == j) {
                    if (Character.isDigit(board[i][j])) {
                        rowData = new char[size];
                        break;
                    } else {
                        //System.out.println("check x lines " + board[i][j]);
                        rowData[i] = board[i][j];
                        //System.out.println("check x lines array" + rowData.toString());

                    }
                }
            }
        }
    }

    private void setWinner(Player player) {
        winnerPlayer = player;
    }

    private Player checkArrayMatchSign(char[] rowData) {
        String rowDataString = new String(rowData);
        if (rowDataString.equals("XXX")) {
            return playerOne;
        } else if (rowDataString.equals("OOO")) {
            return playerTwo;
        } else return null;
    }

    private void updateBoard(int position) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char positionAsChar = (char) (position + '0');
                if (positionAsChar == board[i][j]) {
                    board[i][j] = currentPlayer.getSign();
                    break;
                }
            }
        }
    }

    private void switchPlayer() {
        if (currentPlayer == playerOne)
            currentPlayer = playerTwo;
        else currentPlayer = playerOne;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public int getSize() {
        return size;
    }

    public Player getWinnerPlayer() {
        return winnerPlayer;
    }

    public boolean isBoardFilled() {
        return isBoardFilled;
    }
}
