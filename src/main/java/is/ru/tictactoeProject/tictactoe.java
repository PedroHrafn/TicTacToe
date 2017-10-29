package is.ru.tictactoeProject;

import java.util.Scanner;

public class tictactoe {

	private char[][] board; 
    private char currentPlayerMark;
    private boolean gameOver;
			
    public tictactoe() {
        board = new char[3][3];
        currentPlayerMark = 'x';
        initializeBoard();
        gameOver = false;
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

    public void printBoard() {
        System.out.println("-------------");
        
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
	
	 public boolean getGameOver() {
    	return gameOver;
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
	
    public boolean placeMark(int row, int col) 
    {
        if ((row >= 0) && (row < 3)) 
        {
            if ((col >= 0) && (col < 3)) 
            {
                if (board[row][col] == '-') 
                {
                    board[row][col] = currentPlayerMark;
                    winConditions(getBoard());
                    changePlayer();
                    return true;
                }
            }
        }
        
        return false;
    }

    public boolean winConditions (char[][] board)
    {
        // Loop through possible straight lines 
        // to check for win
		getGameOver();
        for (int i = 0; i < 3; i++)
        {
            if( board[i][1] == board[i][0]
            &&  board[i][1] == board[i][2])
            {
                if(board[i][1] != '-')
                {
                    gameOver = true;
					return gameOver;
                }
            }

            if( board[0][i] == board[1][i]
            &&  board[0][i] == board[2][i])
            {
                if(board[1][i] != '-')
                {
                    gameOver = true;
					return gameOver;
                }
            }
        }

        // Check for wins at angle
        if ( board[1][1] == board[0][0] 
        &&   board[1][1] == board[2][2])
        {
            if (board[1][1] != '-')
            {
                gameOver = true;
                return gameOver;
            }
        }
        
        if ( board[2][0] == board[0][2] 
        &&   board[2][0] == board[1][1])
        {
            if (board[2][0] != '-')
            {
				gameOver = true;
                return gameOver;
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

    public boolean checkIfSame(char input1, char input2, char intput3) {
        return((input1 != '-') && (input1 == input2) && (input2 == intput3));
    }
	
	public boolean checkInput() {
		int n;
		int j;
		int input;
		while(true){
			
			Scanner in = new Scanner(System.in);
			if(in.hasNextInt()){
				
				input = in.nextInt();	
				
				if (input == 1){
					n = 0;
					j = 0;
					placeMark(n,j);
					return true;
				}
				else if (input == 2){
					n = 0;
					j = 1;
					placeMark(n,j);
					return true;
				}
				else if (input == 3){
					n = 0;
					j = 2;
					placeMark(n,j);
					return true;
				}
				else if (input == 4){
					n = 1;
					j = 0;
					placeMark(n,j);
					return true;
				}
				else if (input == 5){
					n = 1;
					j = 1;
					placeMark(n,j);
					return true;
				}
				else if (input == 6){
					n = 1;
					j = 2;
					placeMark(n,j);
					return true;
				}
				else if (input == 7){
					n = 2;
					j = 0;
					placeMark(n,j);
					return true;
				}
				else if (input == 8){
					n = 2;
					j = 1;
					placeMark(n,j);
					return true;
				}
				else if (input == 9){
					n = 2;
					j = 2;
					placeMark(n,j);
					return true;
				}
				else{
					System.out.println("Please only use numbers between 1-9");
				}
			}	
			else{
				System.out.println("Please only use numbers between 1-9");
				return false;
			}
			
		}
	}
	
	
	public static void main(String[] args)
	{
		tictactoe game = new tictactoe();
		int counter = 0;
		while (!game.isFull()){
			game.printBoard();
			System.out.print(game.getPlayer() + " has to make a move \n");
			game.checkInput();
			if(game.getGameOver()){
				game.changePlayer();
				System.out.print(game.getPlayer() + " is the Winner Winner chicken dinner \n");
				
				break;
			}
			counter ++;

			
		}
        game.printBoard();
		if(counter > 8){
			System.out.println("The game is a DRAW!!!!");
		}	
			
		return;
    }
    
}	