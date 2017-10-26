package is.ru.tictactoeProject;

public class tictactoe {

	private char[][] board; 
    private char currentPlayerMark;
			
    public tictactoe() {
        board = new char[3][3];
        currentPlayerMark = 'x';
        initializeBoard();
    }

    public void initializeBoard() {
		
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public char[][] getBoard() {
    	return board;
    }
	
}	