import java.util.ArrayList;

public class Model {
    private ArrayList<Character>[][] board;

    // Constructor
    public Model() {
        board = new ArrayList[7][7];

        
        for (int row = 0; row < 7; row++) {
            for (int col = 0; col < 7; col++) {
                board[row][col] = new ArrayList<Character>();
            }
        }

        baseBoard();
    }

    
    // Method for the board that is output to start the game
    private void baseBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = (row % 2 == 0) ? 0 : 1; col < 7; col += 2) {
                board[row][col].add('R'); 
            }
        }

        for (int row = 4; row < 7; row++) {
            for (int col = (row % 2 == 0) ? 0 : 1; col < 7; col += 2) {
                board[row][col].add('B'); 
            }
        }
    }

    
    // boolean method to move and capture pieces
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
        
        if (outOfBounds(startRow, startCol) || outOfBounds(endRow, endCol) || board[startRow][startCol].isEmpty()) {
            return false;
        }

        ArrayList<Character> startStack = board[startRow][startCol];  
        ArrayList<Character> endStack = board[endRow][endCol];        

        
        if (startRow + 2 == endRow && startCol + 2 == endCol) {
            

            
            ArrayList<Character> middleStack = board[startRow + 1][startCol + 1];
            if (!middleStack.isEmpty()) {
                char piece = middleStack.remove(0); 

                
                startStack.add(0, piece); 
            }
        }

        
        
        endStack.addAll(startStack); 

        
        board[startRow][startCol].clear();

        return true;
    }

    // Method to peek at the top of the stack
    public Character peekTop(int row, int col) {
       
        if (outOfBounds(row, col) || board[row][col].isEmpty()) {
            return null;  
        }

        
        ArrayList<Character> stack = board[row][col];
        return stack.get(stack.size() - 1);
    }

    // Method to peak the stack
    public String peek(int row, int col) {
        if (outOfBounds(row, col)) {
            return "Out of bounds";
        }

        if (board[row][col].isEmpty()) {
            return "Empty stack";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("Top: ");
        
        
        for (int i = board[row][col].size() - 1; i >= 0; i--) {
            sb.append(board[row][col].get(i));
            if (i > 0) {
                sb.append(" "); 
            }
        }

        sb.append(" :Bottom"); 
        return sb.toString();
    }



    // Method to test if the user input takes the piece out of bounds
    public boolean outOfBounds(int row, int col) {
        return row < 0 || row >= 7 || col < 0 || col >= 7;
    }

    
    // Method to check if a player won
    public boolean checkForWinner(char color) {
        for (int row = 0; row < 7; row++) {
            for (int col = 0; col < 7; col++) {
                if (!board[row][col].isEmpty() && board[row][col].get(board[row][col].size() - 1) == color) {
                   
                    return false;
                }
            }
        }
      
        return true;
    }

    
    // Method to draw the board at any time
    public void drawBoard() {
        for (int row = 0; row < 7; row++) {
            for (int col = 0; col < 7; col++) {
                if (board[row][col].isEmpty()) {
                    System.out.print("- ");
                } else {
                    System.out.print(board[row][col].get(board[row][col].size() - 1) + " ");
                }
            }
            System.out.println();
        }
    }
}

