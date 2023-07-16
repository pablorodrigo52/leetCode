/**
 * Word search uses a DFS search to know if a word exists on grid.
 * The search consists in look for corners of actual node (left, right, top, bottom) and verify if 
 * the connected node is the next letter in the word.
 * 
 * The commented code uses a additional stack to know the path until find the word.
 * Time complexity is O(n * m * 3^l) where n is the number of lines, m is the number of columns, 3 was the possible nodes and l is the length of word.
 * 
 */
class Solution {
    // Stack<String> visited = new Stack<>();
    public boolean exist(char[][] board, String word) {
        String reversedWord = new StringBuilder(word).reverse().toString();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == reversedWord.charAt(0) && 
                    dfsSearch(board, reversedWord, i, j, 1)) { // search a start point
                        return true;
                }
                // visited.clear();                
            }
        }

        return false;
    }


    private boolean dfsSearch(char[][] board, String word, int line, int column, int wordIndex) {
        boolean success = false;

        // visited.push("("+line+","+ column+")");
        if (word.length() == wordIndex) {
            return true;
        }

        char backupLetter = board[line][column];
        board[line][column] = '*';

        if (isValidToVisit(board, word, line, column-1, wordIndex)) { // left
            success = dfsSearch(board, word, line, column-1, wordIndex+1);
        } 
        
        if (!success && isValidToVisit(board, word, line+1, column, wordIndex)) { // down
            success = dfsSearch(board, word, line+1, column, wordIndex+1);
        } 
        
        if (!success && isValidToVisit(board, word, line, column+1, wordIndex)) { // right
            success = dfsSearch(board, word, line, column+1, wordIndex+1);
        } 
        
        if (!success && isValidToVisit(board, word, line-1, column, wordIndex)) { // up
            success = dfsSearch(board, word, line-1, column, wordIndex+1);
        }
        
        board[line][column] = backupLetter;
        // visited.pop();
        return success;
    }

    private boolean isValidToVisit(char[][] board, String word, int line, int column, int wordIndex) {
        return line >= 0 && 
            line < board.length && 
            column >= 0 &&
            column < board[line].length &&
            // !visited.contains("("+line+","+ column+")") &&
            word.charAt(wordIndex) == board[line][column];    
    }
}