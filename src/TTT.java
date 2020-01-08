public class TTT        // Here comes the Tic Tac Toe class with all the methods present for the game.
{
    private String board[][];       // Private 3 by 3 array.
    private String playerMark;      // Private instance variable that stores the mark of the current player.

    private enum Entries            // Private enum Constants.
    {
        X,
        O,
        EMPTY
    }

    public TTT()                    // No argument constructor that initializes the array and the board.
    {
        board = new String[3][3];
        initializeBoard();
    }

    private void initializeBoard()      // Method to initialize the board.
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                board[i][j] = String.valueOf(Entries.EMPTY);
            }
        }
    }

    public void displayBoard()      // Method that displays board when called. This creates a visible tic tac toe board.
    {
        System.out.println("-------------------------");

        for (int i = 0; i < 3; i++)
        {
            System.out.print("| ");
            for (int j = 0; j < 3; j++)
            {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------------------");
        }
    }

    public boolean boardCheck()         // This method checks whether the board array has any "EMPTY" space available or not.
    {
        boolean isFull = true;

        for(int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                if(board[i][j].equals("EMPTY"))
                {
                    isFull = false;
                }
            }
        }
        return isFull;
    }

    public void modifyBoard(int rows, int columns)      // This method modifies the board if the corresponding element si "EMPTY".
    {
        if ((rows > 0 && rows < 4) && (columns > 0 && columns < 4))
        {
            if (board[rows - 1][columns - 1].equals("EMPTY"))
            {
                board[rows - 1][columns - 1] = getPlayerMark();
            }
        }
    }

    public void setPlayer(int count)        // This method sets the Player's Mark.
    {
        if(count % 2 == 0)
        {
            playerMark = "  " + String.valueOf(Entries.X) + "  ";
        }
        else
        {
            playerMark = "  " + String.valueOf(Entries.O) + "  ";
        }
    }


    private String getPlayerMark()      // returns the Player Mark.
    {
        return playerMark;
    }

    public boolean checkWinner()        // This method checks for the winner.
    {
        return (checkRows() || checkColumns() || checkDiagonals());
    }

    private boolean checkRows()         // This method checks checks the rows of the board to determine the winner.
    {
        for(int i = 0; i < board.length; i++)
        {
            if(checkRowAndCol(board[i][0], board[i][1], board[i][2]))
            {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns()      // This method checks for the columns of the board to determine the winner.
    {
        for (int i = 0; i < board.length; i++)
        {
            if(checkRowAndCol(board[0][i], board[1][i], board[2][i]))
            {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals()        // This method checks the diagonals of the board to determine the winner.
    {
        return (checkRowAndCol(board[0][0], board[1][1], board[2][2]) || (checkRowAndCol(board[0][2], board[1][1], board[2][0])));
    }

    private boolean checkRowAndCol(String s1, String s2, String s3)     /* This method actually checks whether the elements are same and whether they are empty or not. If they are not empty and the all the three elements are equal then this returns true. */
    {
        return ((!s1.equals("EMPTY")) && (s1.equals(s2)) && (s2.equals(s3)));
    }

    public boolean valueCheck(int row, int column)      // This method checks whether the specified element in the array is "EMPTY" or not.
    {
        return board[row - 1][column - 1].equals("EMPTY");
    }

}