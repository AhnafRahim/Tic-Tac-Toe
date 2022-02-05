package tictactoe;
import java.util.*;
public class TicTacToe 
{
	public static void main(String[] args) 
	{
		//Getting user input
		Scanner sc = new Scanner(System.in);
		int choice;
		
		//Continous loop to let the game run for as long as user desires.
		do{
			//creating new grid object 
			Grid g = new Grid();
			char x = 'X', o = 'O', player;
			int move;
			g.printGrid();

			//For the duration of the game, Player 'X' goes first and 'O' goes second.
			for(int i = 0; i < 9; i++){
				if(i % 2 == 0){
					player = x;
				}
				else{
					player = o;
				}
				//Ensures user is making valid moves. 
				boolean valid = false;
				do{
					System.out.print("Player " + player + ": Choose a number not already chosen. Make your move: ");
					move = sc.nextInt();
					
					//Makes sure user is not choosing an invalid option not on the grid. 
					if(move <= 0)
					{
						System.out.print("You can't choose a number less than or equal to 0. ");
						System.out.println();
					}
					else if(move != 0 && g.makeMove(move, player)){
						valid = true;
					}
				}
				while(!valid);
				g.printGrid();
				if(g.checkWin())
				{
					break;
				}
			}

			//Prints the winner of the game
			if(g.win)
			{
				System.out.print("Winner: ");
				if(g.xWin)
				{
					System.out.println("X");
				}
				else
				{
					System.out.println("O");
				}
			}
			else
			{
				System.out.println("No Winner!");
			}
			System.out.println("\n\nWould you like to play again? \n1. Yes\n2. No\n");
			choice = sc.nextInt();
		}
		while(choice == 1);

		//exits the game
		sc.close();
		System.out.println("Thank you for playing. Goodbye!");
	}
}
