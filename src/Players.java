import java.util.Scanner;   // Importing the Scanner Class.
import java.util.Random;    // Importing the Random Class.

public class Players        // Players class
{
    private int row;
    private int column;     // Variables

    private Scanner scan = new Scanner(System.in);
    private Random rnd = new Random();      // Creating objects of the respective classes.

    public void multiplayer(int num)        // This function enables two users to play one on one match with each other.
    {
        int count = num;    // Local variable performing various important roles in the following program.

        TTT game = new TTT();               // Creating object of the TTT class. That's called composition. :)

        do
        {
            System.out.println("\nCurrent Game");

            if (count % 2 == 0)
            {
                System.out.println("\nPlayer 1: X");    // Player 1 turn.
            }
            else
            {
                System.out.println("\nPlayer 2: O");    // Player 2 turn.
            }

            game.setPlayer(count);      // Sets the current player. Player 1 ( X ) or Player 2 ( O ).

            game.displayBoard();        // Displays the board.

            while(true)         // To check whether the user has input the right value or not.
            {
                System.out.print("Enter number of row: ");
                row = scan.nextInt();
                System.out.print("Enter number of column: ");   // Asks the user to enter the number of rows and columns.
                column = scan.nextInt();

                if((game.valueCheck(row, column)) && (row > 0 && row < 4) && (column > 0 && column < 4))  /* Checks whether the array is empty and whether the user has input the value within the range. */
                {
                    game.modifyBoard(row, column);          // Modifies the array if the array element is empty.
                    break;
                }
                else
                {
                    System.out.println("\nWrong Input!!!! Try again!!! \n");  // Wrong input. :(  Try again.
                }
            }

            if(game.checkWinner())      // Checks the winner after each turn.
            {
                System.out.println();
                game.displayBoard();    // Displays the board.
                if(count % 2 == 0)
                {
                    System.out.println("\nPlayer 1 (X) is the winner!!!\n");    // Yahoo, Player 1 is the winner.
                }
                else
                {
                    System.out.println("\nPlayer 2 (O) is the winner!!!\n");    // Oops, Player 2 is the winner.
                }
                break;                  // If the winner is there, then the loop breaks.
            }

            count++;                    // Counter to set players and check winners etc. That's the important part of my program.

        }
        while(!game.boardCheck());      // Loop continues until the board isn't full.

        if(game.boardCheck() && !game.checkWinner())    // If the board is full, and there is no winner, then it's a tie. :/
        {
            System.out.println("\nThis game is a tie!\n");
        }
    }

    public void computer(int turn)      // This function enables the player to play a match with the computer, an intelligent computer you know. :)
    {
        int count_computer = turn;      // An important local variable that plays various roles in this function.

        TTT game = new TTT();           // Creating object of the class TTT. (Composition)

        do
        {
            System.out.println("\nCurrent Game");
            if (count_computer % 2 == 0)
            {
                System.out.println("\nYou: X");         // Player's turn.
            }
            else
            {
                System.out.println("\nComputer: O");    // Computer's turn.
            }

            game.setPlayer(count_computer);             // Sets the player. User or Computer.

            game.displayBoard();

            if (count_computer % 2 == 0)
            {
                while(true)     // To check whether the user inputs a valid digit or not.
                {
                    System.out.print("Enter number of row: ");
                    row = scan.nextInt();
                    System.out.print("Enter number of column: ");
                    column = scan.nextInt();

                    if((row > 0 && row < 4) && (column > 0 && column < 4) && (game.valueCheck(row, column)))    // Checks whether the number input is correct or not.
                    {
                        game.modifyBoard(row, column);      // If the array element is empty then it modifies the array.
                        break;
                    }
                    else
                    {
                        System.out.println("\nWrong Input!!!! Try again!!!\n");     // Wrong input. :(  Try again.
                    }
                }
            }
            else
            {
                while(true)
                {
                    row = 1 + rnd.nextInt(3);
                    column = 1 + rnd.nextInt(3);    // Generating random numbers for the rows and columns. The range of random number is 1 - 3.

                    if (game.valueCheck(row, column))     /* Checks whether the element corresponding to random number is "EMPTY" or not */
                    {
                        break;                            // If the condition satisfies that the array element is empty, then the loop breaks.
                    }
                }
                game.modifyBoard(row, column);            // Modifies the array after getting a valid input as a random number.
            }

            if(game.checkWinner())          // Checks for the winner.
            {
                System.out.println();
                game.displayBoard();
                if(count_computer % 2 == 0)
                {
                    System.out.println("\nYou (X) are a winner!!!\n");          // Hurrah!! You are a winner.
                }
                else
                {
                    System.out.println("\nComputer (O) is the winner!!!\n");    // Oops, Computer won.
                }
                break;          // Breaks out of loop if there is a winner.
            }

            count_computer++;
        }
        while (!game.boardCheck());     // Loop continues until the board is full.

        if((game.boardCheck() && !game.checkWinner()))      // If there is no winner and the board is full, then the game is tie. :/
        {
            System.out.println("\nThis game is a tie!\n");  // Match drawn.
        }
    }

}