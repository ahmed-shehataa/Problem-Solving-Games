package tic_tac;

public class Player {

    private final String name;
    private final char sing;

    public static char X = 'X';
    public static char O = 'O';

    public Player(String name, char sing) {
        this.name = name;
        this.sing = sing;
    }

    public String getName() {
        return name;
    }

    public char getSign() {
        return sing;
    }
}
