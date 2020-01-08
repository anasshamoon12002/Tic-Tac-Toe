import java.util.Scanner;   // Importing Scanner class

/*

Author:     Anas Shamoon

 */

public class Main      // Main class
{
    public static void main(String[] args)   // Main function
    {

        int choice;
        int turn;                 // Variables
        int continue_status;

        Scanner scan = new Scanner(System.in);    // Creating Scanner class' object

        Players play = new Players();             // Creating object of Players class

        System.out.println("\nTic Tac Toe");

        System.out.println("\nSCALE \nRows:     1 - 3 \nColumns:  1 - 3");

        do {                                      // Main interface between the user and the program.

            System.out.println("\nSelect one option:");
            System.out.println("1. Multiplayer   2. Computer");
            choice = scan.nextInt();

            if (choice == 1)
            {
                play.multiplayer(0);        // Function called from the Players class that at the backend calls the functions of the third class.
            }
            else if (choice == 2)
            {
                System.out.println("\nWho should play first?");
                System.out.println("1. Player   2. Computer");
                turn = scan.nextInt();

                if (turn == 1)
                {
                    play.computer(0);       /* Function called from the Players class that at the backend calls the functions of the third class. This function performs the duty of making the player make the first move. */
                }

                if (turn == 2)
                {
                    play.computer(1);       /* Function called from the Players class that at the backend calls the functions of the third class. This function performs the duty of making the computer to make the first move. */
                }

            }

            System.out.println("Do you want to play again?");     // Want to play again? Hit "1" otherwise hit "2".
            System.out.println("1. Yes   2. No");
            continue_status = scan.nextInt();

        }
        while(continue_status != 2);

        System.out.println("\nBye Bye!!! \n");   // Bye Bye. :)

    }
}
