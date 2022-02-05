package tictactoe;

public class Grid 
{
	public char[][] grid = new char[3][3];
	public boolean xWin, oWin;
	public boolean win = false;
	public Grid()
	{
		int r = grid.length;
		int c = grid[0].length;
		int counter = 1;
		for(int i = 0; i < r; i++)
		{
			for(int j = 0; j < c; j++)
			{
				grid[i][j] = Integer.toString(counter).charAt(0);
				counter++;
			}
		}
	}
	
	//method to print the grid by loopping through the 2d array 
	public void printGrid()
	{
		int r = grid.length;
		int c = grid[0].length;
		for(int i = 0; i < r; i++)
		{
			for(int j = 0; j < c; j++)
			{
				System.out.print(grid[i][j] + "	 ");
			}
			System.out.println();
		}
	}
	
	//method to allow player to make their move 
	public boolean makeMove(int x, char player)
	{
		int r, c;
		switch(x)
		{
		case 1:
			r = 0;
			c = 0;
			break;
		case 2:
			r = 0;
			c = 1;
			break;
		case 3:
			r = 0;
			c = 2;
			break;
		case 4:
			r = 1;
			c = 0;
			break;
		case 5:
			r = 1;
			c = 1;
			break;
		case 6:
			r = 1;
			c = 2;
			break;
		case 7:
			r = 2;
			c = 0;
			break;
		case 8:
			r = 2;
			c = 1;
			break;
		case 9:
			r = 2;
			c = 2;
			break;
		default:
			r = -1;
			c = -1;
		}
		if(grid[r][c] != 'X' && grid[r][c] != 'O')
		{
			grid[r][c] = player;
			return true;
		}
		return false;
	}

	//Method to check whether the player has won or not 
	public boolean checkWin()
	{
		char winner =' ';
		//Establishes which part of the grid each row and column is 
		char[] row1 = grid[0];
		char[] row2 = grid[1];
		char[] row3 = grid[2];
		char[] col1 = {grid[0][0], grid[1][0], grid[2][0]};
		char[] col2 = {grid[0][1], grid[1][1], grid[2][1]};
		char[] col3 = {grid[0][2], grid[1][2], grid[2][2]};
		char[] upDiag = {grid[2][0],grid[1][1], grid[0][2]};
		char[] downDiag = {grid[0][0], grid[1][1], grid[2][2]};
		
		//Conditionals to check whether the 
		if(row1[0] == row1[1] && row1[1] == row1[2])
		{
			win = true;
			winner = row1[0];
			System.out.println("Row 1 Win!");
		}
		else if(row2[0] == row2[1] && row2[1] == row2[2])
		{
			win = true;
			winner = row2[0];
			System.out.println("Row 2 Win!");
		}
		else if(row3[0] == row3[1] && row3[1] == row3[2])
		{
			win = true;
			winner = row3[0];
			System.out.println("Row 3 Win!");
		}
		else if(col1[0] == col1[1] && col1[1] == col1[2])
		{
			win = true;
			winner = col1[0];
			System.out.println("Column 1 Win!");
		}
		else if(col2[0] == col2[1] && col2[1] == col2[2])
		{
			win = true;
			winner = col2[0];
			System.out.println("Column 2 Win!");
		}
		else if(col3[0] == col3[1] && col3[1] == col3[2])
		{
			win = true;
			winner = col3[0];
			System.out.println("Column 3 Win!");
		}
		else if(upDiag[0] == upDiag[1] && upDiag[1] == upDiag[2])
		{
			win = true;
			winner = upDiag[0];
			System.out.println("Upward Diagonal Win!");
		}
		else if(downDiag[0] == downDiag[1] && downDiag[1] == downDiag[2])
		{
			win = true;
			winner = downDiag[0];
			System.out.println("Downward Diagonal Win!");
		}
		if(win && winner == 'X')
		{
			xWin = true;
		}
		if(win && winner == 'O')
		{
			oWin = true;
		}
		return win;
	}
	
}
