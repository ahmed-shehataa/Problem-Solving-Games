package tic_tac;

import java.util.Scanner;

public class TicTacTio {

    public static void main(String[] args) {

        System.out.println("Welcome to TicTacTio");
        Scanner scanner= new Scanner(System.in);

        System.out.println("Insert First player name:");
        Player playerOne = new Player(scanner.next(), Player.X);

        System.out.println("Insert Second player name:");
        Player playerTwo = new Player(scanner.next(), Player.O);
        TicTacTeoBoard ticTacTeoBoard = new TicTacTeoBoard(playerOne, playerTwo);

        do {
            System.out.println("Current board is");
            ticTacTeoBoard.print();
            System.out.println("Please " + ticTacTeoBoard.getCurrentPlayer().getName()
                    + " insert the new position of " +
                    ticTacTeoBoard.getCurrentPlayer().getSign());

            int positionOfSign = scanner.nextInt();
            ticTacTeoBoard.play(positionOfSign);


        } while (ticTacTeoBoard.getWinnerPlayer() == null && !ticTacTeoBoard.isBoardFilled());


        ticTacTeoBoard.print();
        if (ticTacTeoBoard.getWinnerPlayer() != null) {
            System.out.println("------- Winner is " + ticTacTeoBoard.getWinnerPlayer().getName() + " --------");
        } else {
            System.out.println("There is no winner");
        }

    }
}
