package HW6.Q2;

import java.util.Scanner;

/**
 * This class creates main field of the game
 * which the game is played on it and battleships
 * are placed on it
 * @author Mohamad Chaman-Motlagh
 * @version 1
 */
public class Field {
    char[][] board;

    /**
     * A Field needs nothing to get created
     */
    public Field()
    {
        board = new char[10][10];
        for(int i =0 ; i < 10 ; i++)
            for(int j = 0 ; j < 10 ; j++)
                board[i][j] = ' ';
    }
    public void createBattleship() {
        System.out.println("Please enter the type of battleship\n **1 for vertical \t and \t other thing for horizontal");
        int type = -1;
        try {
            Scanner scanner = new Scanner(System.in);
            type = scanner.nextInt();
        } catch (Exception e){
            type = 2;
        }
        if(type != 1)
            type = 2;
        if(type == 2)
        {
            System.out.println("You chose horizontal,");
            System.out.println("Please enter the row you want to put you battleship in it (an integer between 0 , 9): ");
            int row = -1;
            while (true)
            {
                try {
                    Scanner scanner = new Scanner(System.in);
                    row = scanner.nextInt();
                }catch (Exception e){
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Wrong input");
                    row = scanner.nextInt();
                }
                if(row >= 0 && row <= 9)
                    break;
                System.out.println("Wrong input, try agian");

            }
            int[] startAndEnd;
            while (true) {
                startAndEnd = stratAndEndgiver();
                if (haveOverlap(true, row, startAndEnd))
                {
                    System.out.println("Incorrect locations, try again");
                    continue;
                }
                break;
            }
            for(int i = startAndEnd[0] ; i <= startAndEnd[1] ; i++)
                board[row][i] = '@';
        }
        else if(type == 1)
        {
            System.out.println("you chose vertical,");
            System.out.println("Please enter the column you want to put you battleship in it (an integer between 0 , 9): ");
            int column = -1;
            while (true)
            {
                try {
                    Scanner scanner = new Scanner(System.in);
                    column = scanner.nextInt();
                }catch (Exception e){
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Wrong input, try again");
                    column = scanner.nextInt();
                }
                if(column >= 0 && column <= 9)
                    break;
                System.out.println("Wrong input, try again");
            }
            int[] startAndEnd;
            while (true) {
                startAndEnd = stratAndEndgiver();
                if (haveOverlap(false, column, startAndEnd))
                {
                    System.out.println("Incorrect locations, try again");
                    continue;
                }
                break;
            }
            for(int i = startAndEnd[0] ; i <= startAndEnd[1] ; i++)
                board[i][column] = '@';
        }
    }
    /*
    Return start and end of a battleship, start is always smaller than end
    first one is start and second location in array is end
     */
    private int[] stratAndEndgiver()
    {
        System.out.println("Please enter starting point and ending point of battleship in told order, an integer between 0 , 9");
        int start = -1;
        int end = -1;
        while (true)
        {
            try {
                Scanner scanner = new Scanner(System.in);
                start = scanner.nextInt();
                end = scanner.nextInt();
            }catch (Exception e){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Wrong input, try again");
                start = scanner.nextInt();
                end = scanner.nextInt();
            }
            if ( (start >= 0 && start <= 9) && (end >= 0 && end <= 9) && (Math.abs(start - end) < 5))
                break;
            System.out.println("Wrong input, try again");
        }
        int[] result = new int[2];
        if (end < start)
        {
            int temp = start;
            start = end;
            end = temp;
        }
        result[0] = start;
        result[1] = end;
        return result;
    }
    /*
    Checks whether to battleships have over lap or not,
    return true if they have overlap and false if they don't
     */
    private boolean haveOverlap(boolean isHorizontal, int columnOrRow, int[] startAndEnd)
    {
        if(isHorizontal)
        {
            for(int i = startAndEnd[0] ; i <= startAndEnd[1] ; i++)
                if(board[columnOrRow][i] == '@')
                    return true;
        }
        else
        {
            for(int i = startAndEnd[0] ; i <= startAndEnd[1] ; i++)
                if(board[i][columnOrRow] == '@')
                    return true;
        }
        return false;
    }

    /**
     * Prints board of the game for currents player
     */
    public void printBoard()
    {

        for (int i = 0 ; i < 10 ; i++) {
            for (int j = 0; j < 10; j++) {
                if(board[i][j] == '@')
                    System.out.print("\u001B[34m " + board[i][j] + " \u001B[0m");
                else
                    System.out.print(" " + board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    /**
     * @return borad of game as a two dimensional array of chars
     */
    public char[][] getBoard() {
        return board;
    }

    /**
     * Sets a new board for field
     * @param board is given board
     */
    public void setBoard(char[][] board) {
        this.board = board;
    }
}
