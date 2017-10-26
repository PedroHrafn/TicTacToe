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

    public boolean isFull() {

    	for(int i = 0; i < 3; i++) {
    		for(int j = 0; j < 3; j++) {
    			if(board[i][j] == '-') {
    				return false;
    			}
    		}
    	}
    	return true;
    }
	
    public boolean placeMark(int row, int col) {
        
        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (board[row][col] == '-') {
                    board[row][col] = currentPlayerMark;
                    return true;
                }
            }
        }
        
        return false;
    }

    public void changePlayer() {
        if (currentPlayerMark == 'x') {
            currentPlayerMark = 'o';
        }
        else {
            currentPlayerMark = 'x';
        }
    }

    public char getPlayer()
    {
        return currentPlayerMark;
    }
	
	public static void main(String[] args)
	{
		return;
    }
    
    public boolean winConditions (char[][] board)
    {
        for (int i = 0; i < board.length; i++)
        {
            if( board[i][1] == board[i][0]
            &&  board[i][1] == board[i][2])
            {
                if(board[i][1] != '-')
                {
                    return true;
                }
            }

            if( board[1][i] == board[2][i]
            &&  board[1][i] == board[3][i])
            {
                if(board[1][i] != '-')
                {
                    return true;
                }
            }

            if ( board[1][1] == board[0][0] 
            &&   board[1][1] == board[2][2])
            {
                if (board[1][1] != '-')
                {
                    return true;
                }
            }
            
            if ( board[2][0] == board[0][2] 
            &&   board[2][0] == board[1][1])
            {
                if (board[2][0] != '-')
                {
                    return true;
                }
            }
        }

        return false;
    }
}	