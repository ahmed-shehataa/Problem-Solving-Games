package games.crossword;

public class CrosswordSolver {
    public static boolean solveCrossword(char[][] grid, String[] words, int wordIndex) {
        // Base case: All words filled.
        if (wordIndex == words.length) {
            return true;
        }

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {

                if (grid[row][col] == '-' || grid[row][col] == words[wordIndex].charAt(0)) {
                    // Try placing horizontally
                    if (canPlaceWordHorizontal(grid, words[wordIndex], row, col)) {
                        // Place the word horizontally
                        placeWordHorizontal(grid, words[wordIndex], row, col);

                        // Recursively try to fill the next word
                        if (solveCrossword(grid, words, wordIndex + 1)) {
                            return true;
                        } else
                            // Backtrack if unsuccessful
                            removeWordHorizontal(grid, words[wordIndex], row, col);
                    }

                    // Try placing vertically
                    if (canPlaceWordVertical(grid, words[wordIndex], row, col)) {
                        // Place the word vertically
                        placeWordVertical(grid, words[wordIndex], row, col);

                        // Recursively try to fill the next word
                        if (solveCrossword(grid, words, wordIndex + 1)) {
                            return true;
                        } else
                            // Backtrack if unsuccessful
                            removeWordVertical(grid, words[wordIndex], row, col);
                    }
                }
            }
        }

        return false; // Backtrack
    }

    private static void removeWordVertical(char[][] grid, String word, int row, int col) {
        for (int i = 0; i < word.length(); i++) {
            grid[row + i][col] = '-';
        }
    }

    private static void placeWordVertical(char[][] grid, String word, int row, int col) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            grid[row + i][col] = chars[i];
        }
    }

    private static boolean canPlaceWordVertical(char[][] grid, String word, int itemRow, int itemCol) {
        int emptyFields = 0;
        char[] chars = word.toCharArray();
        int wordCounter = -1;

        for (int row = itemRow; row < grid.length; row++) {
            char item = grid[row][itemCol];
            wordCounter++;
            if (wordCounter == chars.length) break;
            if (chars[wordCounter] == item || item == '-') {
                emptyFields++;
            } else break;
        }
        return emptyFields == word.length();
    }

    private static void removeWordHorizontal(char[][] grid, String word, int row, int col) {
        for (int i = 0; i < word.length(); i++) {
            grid[row][col + i] = '-';
        }
    }

    private static void placeWordHorizontal(char[][] grid, String word, int row, int col) {
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            grid[row][col + i] = chars[i];
        }
    }

    private static boolean canPlaceWordHorizontal(char[][] grid, String word, int itemRow, int itemCol) {
        int emptyFields = 0;
        int wordCounter = -1;
        char[] chars = word.toCharArray();
        for (int column = itemCol; column < grid.length; column++) {
            char item = grid[itemRow][column];
            wordCounter++;
            if (wordCounter == chars.length) break;
            if (chars[wordCounter] == item || item == '-') {
                emptyFields++;
            } else break;
        }
        return emptyFields == word.length();
    }

    public static void print(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                char item = board[row][column];
                System.out.print(item);
            }
            System.out.println();
        }
    }
}
