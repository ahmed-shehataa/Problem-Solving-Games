package soduko;

public class NumberCoordinates {

    private final int row;
    private final int column;

    public NumberCoordinates(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
